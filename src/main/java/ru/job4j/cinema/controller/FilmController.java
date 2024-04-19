package ru.job4j.cinema.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cinema.service.FilmService;
import ru.job4j.cinema.service.GenreService;

@Slf4j
@Controller
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;

    private final GenreService genreService;

    public FilmController(FilmService filmService, GenreService genreService) {
        this.filmService = filmService;
        this.genreService = genreService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("films", filmService.findAll());
        model.addAttribute("genre", genreService.findAll());
        return "films/list";
    }

}
