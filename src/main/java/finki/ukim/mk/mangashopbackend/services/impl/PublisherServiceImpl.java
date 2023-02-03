package finki.ukim.mk.mangashopbackend.services.impl;

import finki.ukim.mk.mangashopbackend.models.Publisher;
import finki.ukim.mk.mangashopbackend.repository.PublisherRepository;
import finki.ukim.mk.mangashopbackend.services.PublisherService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Override
    public Optional<Publisher> findById(Long id) {
        return this.publisherRepository.findById(id);
    }

    @Override
    public List<Publisher> findAll() {
        return this.publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> save(String name, String address) {
        Publisher publisher = new Publisher(name, address);
        return Optional.of(publisherRepository.save(publisher));
    }

    @Override
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}
