package filmgroup.service;

import filmgroup.model.Film;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface FilmService {

    List<Film> allFilms();
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(int id);
}