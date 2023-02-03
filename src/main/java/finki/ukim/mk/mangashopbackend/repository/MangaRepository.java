package finki.ukim.mk.mangashopbackend.repository;

import finki.ukim.mk.mangashopbackend.models.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MangaRepository extends JpaRepository<Manga, Long> {
    Optional<Manga> findByName(String name);
}