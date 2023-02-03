package finki.ukim.mk.mangashopbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String last_name;

    @OneToMany
    private List<Manga> manga;

    public Author(String name, String lastName, List<Manga> mangaList) {
        this.name = name;
        this.last_name = lastName;
        this.manga = mangaList;
    }
}
