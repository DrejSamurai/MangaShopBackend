package finki.ukim.mk.mangashopbackend.services.impl;

import finki.ukim.mk.mangashopbackend.models.Author;
import finki.ukim.mk.mangashopbackend.models.Manga;
import finki.ukim.mk.mangashopbackend.repository.AuthorRepository;
import finki.ukim.mk.mangashopbackend.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;


    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findAuthorByName(name);
    }

    @Override
    public Author create(String name, String last_name, List<Manga> mangaList) {
        Author author = new Author(name,last_name,mangaList);
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Manga> findAllMangaByAuthorName(String name) {
        Author author = authorRepository.findAuthorByName(name);
        return author.getManga();
    }
}
