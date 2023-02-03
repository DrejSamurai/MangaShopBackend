package finki.ukim.mk.mangashopbackend.services;

import finki.ukim.mk.mangashopbackend.enumerators.Genre;
import finki.ukim.mk.mangashopbackend.models.Author;
import finki.ukim.mk.mangashopbackend.models.Manga;
import finki.ukim.mk.mangashopbackend.models.Publisher;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MangaService {
    public List<Manga> findAll();

    public Optional<Manga> findById(Long id);

    public Optional<Manga> findByName(String name);

    public Optional<Manga> save(String name, Author author, Double price,Integer quantity, Genre genre, Publisher publisher);

    public void deleteById(Long id);

    public Optional<Manga> edit(Long id, String name, Author author, Double price,Integer quantity, Genre genre, Publisher publisher);
}
