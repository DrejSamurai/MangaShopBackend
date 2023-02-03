package finki.ukim.mk.mangashopbackend.models;

import finki.ukim.mk.mangashopbackend.enumerators.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Author author;
    private Double price;
    private Integer quantity;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @ManyToOne
    private Publisher publisher;

    public Manga(String name, Author author, Double price, Integer quantity, Genre genre, Publisher publisher) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.genre = genre;
        this.publisher = publisher;
    }
}
