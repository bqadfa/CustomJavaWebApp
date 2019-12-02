//package controller;
package filmgroup.controller;

import filmgroup.dao.FilmDAO;
import filmgroup.dao.FilmDAOImpl;
import filmgroup.model.Film;

import filmgroup.service.FilmService;
import filmgroup.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;




@Controller
public class FilmController {

    //@Autowired
    private FilmService filmService; //= new FilmServiceImpl();


    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Web-app of film catalogue");
        modelAndView.addObject("message", "Welcome page!");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public ModelAndView allFilms(){
        List<Film> films = filmService.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable int id){
        Film film = filmService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("film", film);
        modelAndView.addObject("film", filmService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("film") Film film){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.edit(film);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute(name = "film") Film film){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.add(film);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Film film = filmService.getById(id);
        filmService.delete(film);
        return modelAndView;
    }

    /*
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "qwertyZxc1!";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Failed to connect!");
            e.printStackTrace();
        }
    }

     */
}




