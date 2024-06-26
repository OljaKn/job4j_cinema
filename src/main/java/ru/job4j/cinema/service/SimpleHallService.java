package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Hall;
import ru.job4j.cinema.repository.HallRepository;

import java.util.Collection;

@Service
public class SimpleHallService implements HallService {
    private final HallRepository hallRepository;

    public SimpleHallService(HallRepository sql2ohallRepository) {
        this.hallRepository = sql2ohallRepository;
    }

    @Override
    public Hall findById(int id) {
        return hallRepository.findById(id);
    }

    @Override
    public Collection<Hall> getAll() {
        return hallRepository.getAll();
    }
}
