package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.repository.FilmRepository;

import java.util.Collection;
@Service
@ThreadSafe
public class SimpleFilmService implements FilmService {
    private final FilmRepository filmRepository;

    public SimpleFilmService(FilmRepository sql20FilmRepository) {
        this.filmRepository = sql20FilmRepository;
    }

    @Override
    public Collection<Film> findAll() {
        return filmRepository.findAll();
    }
}
