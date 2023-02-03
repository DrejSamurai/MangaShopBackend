package finki.ukim.mk.mangashopbackend.services;

import finki.ukim.mk.mangashopbackend.models.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
        Optional<Publisher> findById(Long id);

        List<Publisher> findAll();

        Optional<Publisher> save(String name, String address);

        void deleteById(Long id);
}
