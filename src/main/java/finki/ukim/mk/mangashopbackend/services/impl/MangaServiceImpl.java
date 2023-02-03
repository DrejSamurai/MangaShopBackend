package finki.ukim.mk.mangashopbackend.services.impl;

import finki.ukim.mk.mangashopbackend.enumerators.Genre;
import finki.ukim.mk.mangashopbackend.exceptions.MangaNotFoundException;
import finki.ukim.mk.mangashopbackend.models.Author;
import finki.ukim.mk.mangashopbackend.models.Manga;
import finki.ukim.mk.mangashopbackend.models.Publisher;
import finki.ukim.mk.mangashopbackend.repository.MangaRepository;
import finki.ukim.mk.mangashopbackend.services.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MangaServiceImpl implements MangaService {
    private final MangaRepository mangaRepository;
    @Override
    public List<Manga> findAll() {
        return this.mangaRepository.findAll();
    }

    @Override
    public Optional<Manga> findById(Long id) {
        return this.mangaRepository.findById(id);
    }

    @Override
    public Optional<Manga> findByName(String name) {
        return this.mangaRepository.findByName(name);
    }

    @Override
    public Optional<Manga> save(String name, Author author, Double price, Integer quantity, Genre genre, Publisher publisher) {
        Manga manga = new Manga(name, author, price, quantity, genre, publisher);
        return Optional.of(this.mangaRepository.save(manga));
    }

    @Override
    public void deleteById(Long id) {
        this.mangaRepository.deleteById(id);
    }

    @Override
    public Optional<Manga> edit(Long id, String name, Author author, Double price, Integer quantity, Genre genre, Publisher publisher) {
        Manga manga = this.mangaRepository.findById(id).orElseThrow(()-> new MangaNotFoundException(id));
        manga.setName(name);
        manga.setAuthor(author);
        manga.setPrice(price);
        manga.setQuantity(quantity);
        manga.setGenre(genre);
        manga.setPublisher(publisher);
        mangaRepository.save(manga);
        return Optional.of(manga);
    }
}
