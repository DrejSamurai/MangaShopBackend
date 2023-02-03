package finki.ukim.mk.mangashopbackend.services;

import finki.ukim.mk.mangashopbackend.models.Manga;
import finki.ukim.mk.mangashopbackend.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    public List<Manga> listAllMangaInShoppingCart(Long cartId);
    public ShoppingCart getActiveShoppingCart(String username);
    public ShoppingCart addMangaToShoppingCart(String username, Long mangaId);

}
