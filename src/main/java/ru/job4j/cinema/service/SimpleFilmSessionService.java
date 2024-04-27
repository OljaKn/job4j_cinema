package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FilmSessionDto;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.repository.FilmSessionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleFilmSessionService implements FilmSessionService {
    private final FilmSessionRepository filmSessionRepository;

    public SimpleFilmSessionService(FilmSessionRepository sql2oFilmSessionRepository) {
        this.filmSessionRepository = sql2oFilmSessionRepository;
    }

    @Override
    public Optional<FilmSessionDto> findById(int id) {
        Optional<FilmSession> filmSessionOpt = filmSessionRepository.findById(id);
        if (filmSessionOpt.isEmpty()) {
            return Optional.empty();
        }
        FilmSession fs = filmSessionOpt.get();
        FilmSessionDto fsd = new FilmSessionDto(fs.getId(), fs.getFilmId(), fs.getHallsId(), fs.getStartTime(), fs.getEndTime(), fs.getPrice());
        return Optional.of(fsd);
    }

    @Override
    public Collection<FilmSessionDto> getAll() {
        Collection<FilmSession> fs = filmSessionRepository.getAll();
        List<FilmSessionDto> filmSessionDto = new ArrayList<>();
        for (FilmSession filmSession : fs) {
            filmSessionDto.add(new FilmSessionDto(filmSession.getId(), filmSession.getFilmId(), filmSession.getHallsId(), filmSession.getStartTime(), filmSession.getEndTime(), filmSession.getPrice()));
        }
        return filmSessionDto;
    }
}
