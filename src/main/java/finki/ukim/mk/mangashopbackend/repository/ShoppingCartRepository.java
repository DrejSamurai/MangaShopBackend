package finki.ukim.mk.mangashopbackend.repository;

import finki.ukim.mk.mangashopbackend.enumerators.ShoppingCartStatus;
import finki.ukim.mk.mangashopbackend.models.ShoppingCart;
import finki.ukim.mk.mangashopbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserAndShoppingCartStatus(User user, ShoppingCartStatus shoppingCartStatus);
}