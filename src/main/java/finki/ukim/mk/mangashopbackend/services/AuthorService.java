package finki.ukim.mk.mangashopbackend.services;

import finki.ukim.mk.mangashopbackend.models.Author;
import finki.ukim.mk.mangashopbackend.models.Manga;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);
    Author findByName(String name);
    Author create (String name, String last_name, List<Manga> mangaList);
    void delete(Long id);

    List<Author> findAllAuthors();

    List<Manga> findAllMangaByAuthorName(String name);

}
