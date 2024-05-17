package com.svalero.FilmAPI.controller;
import com.svalero.FilmAPI.domain.Film;
import com.svalero.FilmAPI.dto.FilmInDto;
import com.svalero.FilmAPI.service.FilmService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;
    private final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @GetMapping("/films")
    public ResponseEntity<List<Film>> getFilms() {
        logger.info("ini GET /films");
        List<Film> films = filmService.getFilms();
        logger.info("end GET /films");
        return ResponseEntity.ok(films);
    }

    @PostMapping("/films")
    public ResponseEntity<Film> addFilm(@Valid @RequestBody FilmInDto filmInDto) {
        logger.info("ini POST /films");
        Film film = filmService.addFilm(filmInDto);
        logger.info("end POST /films");
        return ResponseEntity.status(HttpStatus.CREATED).body(film);
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable long id) {
        logger.info("ini GET /film/{}", id);
        Film film = filmService.getFilmById(id);
        logger.info("end GET /film/{}", id);
        return ResponseEntity.ok(film);
    }

    @PutMapping("/film/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable long id,
                                                   @Valid @RequestBody FilmInDto filmInDto) {
        logger.info("ini PUT /film/{}", id);
        Film film = filmService.updateFilm(id, filmInDto);
        logger.info("end PUT /film/{}", id);
        return ResponseEntity.ok(film);
    }

    @DeleteMapping("/film/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable long id) {
        logger.info("ini DELETE /film/{}", id);
        filmService.deleteFilm(id);
        logger.info("end DELETE /film/{}", id);
        return ResponseEntity.noContent().build();
    }
}
