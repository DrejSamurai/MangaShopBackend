package finki.ukim.mk.mangashopbackend.models;

import finki.ukim.mk.mangashopbackend.enumerators.ShoppingCartStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateOfCreation;

    @Enumerated(value = EnumType.STRING)
    private ShoppingCartStatus shoppingCartStatus;

    @ManyToOne
    private User user;
}
