package filmgroup.dao;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import filmgroup.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;

@Repository
public class FilmDAOImpl implements FilmDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Film> films = new HashMap<Integer, Film>();
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Film> allFilms(){
        String request = "FROM Film";
        return sessionFactory.getCurrentSession().createQuery(request).list();
    }

    @Override
    public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }

    @Override
    public void delete(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public Film getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }
}
