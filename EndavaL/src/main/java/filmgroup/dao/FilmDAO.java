package filmgroup.dao;


import filmgroup.model.Film;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FilmDAO {
    List<Film> allFilms();
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(int id);
}
