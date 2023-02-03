package finki.ukim.mk.mangashopbackend.repository;

import finki.ukim.mk.mangashopbackend.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}