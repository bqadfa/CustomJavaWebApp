package filmgroup.service;

import filmgroup.model.Film;
import filmgroup.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class FilmServiceImpl implements FilmService {


    @Autowired
    private FilmDAO filmDAO;

    public FilmServiceImpl(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    //@Autowired
    /*public void setFilmDAO(FilmDAO filmDAO){
        this.filmDAO = filmDAO;
    }
    */

    @Override
    @Transactional
    public List<Film> allFilms() {
        return filmDAO.allFilms();
    }

    @Override
    @Transactional
    public void add(Film film) {
        filmDAO.add(film);
    }

    @Override
    @Transactional
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    @Override
    @Transactional
    public void edit(Film film) {
        filmDAO.edit(film);
    }

    @Override
    @Transactional
    public Film getById(int id) {
        return filmDAO.getById(id);
    }
}
