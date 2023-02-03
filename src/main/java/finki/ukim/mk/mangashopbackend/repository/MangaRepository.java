package finki.ukim.mk.mangashopbackend.repository;

import finki.ukim.mk.mangashopbackend.models.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {
    Optional<Manga> findByName(String name);
}