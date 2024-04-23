package ru.job4j.cinema.dto;


import ru.job4j.cinema.model.Film;
import ru.job4j.cinema.model.Genre;

public class FilmDto {
    private int id;
    private String name;
    private String description;
    private int year;
    private int minimalAge;
    private int durationInMinutes;
    private String genre;
    private int imageId;

    public FilmDto() {

    }

    public FilmDto(Film film, Genre genre) {
        this.id = film.getId();
        this.name = film.getName();
        this.description = film.getDescription();
        this.year = film.getYear();
        this.minimalAge = film.getMinimalAge();
        this.durationInMinutes = film.getDurationInMinutes();
        this.genre = genre.getName();
        this.imageId = film.getFileId();
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
