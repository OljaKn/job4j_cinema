package ru.job4j.cinema.service;

import ru.job4j.cinema.model.User;
import java.util.Optional;

public interface UserService {
    public Optional<User> save(User user);

    public Optional<User> findByEmailAndPassword(String email, String password);
}
