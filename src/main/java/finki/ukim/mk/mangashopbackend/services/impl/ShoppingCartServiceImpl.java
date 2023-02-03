package finki.ukim.mk.mangashopbackend.services.impl;

import finki.ukim.mk.mangashopbackend.enumerators.ShoppingCartStatus;
import finki.ukim.mk.mangashopbackend.exceptions.MangaNotFoundException;
import finki.ukim.mk.mangashopbackend.exceptions.UserNotFoundException;
import finki.ukim.mk.mangashopbackend.models.Manga;
import finki.ukim.mk.mangashopbackend.models.ShoppingCart;
import finki.ukim.mk.mangashopbackend.models.User;
import finki.ukim.mk.mangashopbackend.repository.MangaRepository;
import finki.ukim.mk.mangashopbackend.repository.ShoppingCartRepository;
import finki.ukim.mk.mangashopbackend.repository.UserRepository;
import finki.ukim.mk.mangashopbackend.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final MangaRepository mangaRepository;

    @Override
    public List<Manga> listAllMangaInShoppingCart(Long cartId) {
        return this.shoppingCartRepository.findById(cartId)
                .get().getMangaList();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(()-> new UserNotFoundException(username));

        return this.shoppingCartRepository
                .findByUserAndShoppingCartStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
        public ShoppingCart addMangaToShoppingCart(String username, Long mangaId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Manga manga = this.mangaRepository.findById(mangaId)
                .orElseThrow(()-> new MangaNotFoundException(mangaId));
        shoppingCart.getMangaList()
                .add(manga);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
