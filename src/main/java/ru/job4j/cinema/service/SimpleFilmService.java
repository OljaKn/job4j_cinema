package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FilmDto;
import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.model.Genre;
import ru.job4j.cinema.repository.FilmRepository;
import ru.job4j.cinema.repository.GenreRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@ThreadSafe
public class SimpleFilmService implements FilmService {
    private final FilmRepository filmRepository;
    private final GenreRepository genreRepository;

    public SimpleFilmService(FilmRepository sql2oFilmRepository, GenreRepository sql2oGenreRepository) {
        this.filmRepository = sql2oFilmRepository;
        this.genreRepository = sql2oGenreRepository;
    }

    @Override
    public Optional<FilmDto> findById(int id) {
        Optional<Film> film = filmRepository.findById(id);
        if (film.isEmpty()) {
            return Optional.empty();
        }
        Genre genre = genreRepository.findById(film.get().getGenreId());
        FilmDto filmDto = new FilmDto(film.get(), genre);
        return Optional.of(filmDto);
    }

    @Override
    public Collection<FilmDto> findAll() {
        Collection<Film> films = filmRepository.findAll();
        List<FilmDto> filmDto = new ArrayList<>();
        for (Film film : films) {
            Genre genre = genreRepository.findById(film.getGenreId());
            filmDto.add(new FilmDto(film, genre));
        }
        return filmDto;
    }
}
