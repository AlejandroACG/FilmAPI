package com.svalero.FilmAPI.controller;
import com.svalero.FilmAPI.domain.Director;
import com.svalero.FilmAPI.dto.DirectorInDto;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DirectorController {
    @Autowired
    private DirectorService directorService;
    private final Logger logger = LoggerFactory.getLogger(DirectorController.class);

    @GetMapping("/directors")
    public ResponseEntity<List<Director>> getDirectors() {
        logger.info("ini GET /directors");
        List<Director> directors = directorService.getDirectors();
        logger.info("end GET /directors");
        return ResponseEntity.ok(directors);
    }

    @PostMapping("/directors")
    public ResponseEntity<Director> addDirector(@Valid @RequestBody DirectorInDto directorInDto) {
        logger.info("ini POST /directors");
        Director director = directorService.addDirector(directorInDto);
        logger.info("end POST /directors");
        return ResponseEntity.status(HttpStatus.CREATED).body(director);
    }

    @GetMapping("/director/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable long id) {
        logger.info("ini GET /director/{}", id);
        Director director = directorService.getDirectorById(id);
        logger.info("end GET /director/{}", id);
        return ResponseEntity.ok(director);
    }

    @PutMapping("/director/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable long id,
                                                           @Valid @RequestBody DirectorInDto directorInDto) {
        logger.info("ini PUT /director/{}", id);
        Director director = directorService.updateDirector(id, directorInDto);
        logger.info("end PUT /director/{}", id);
        return ResponseEntity.ok(director);
    }

    @DeleteMapping("/director/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable long id) {
        logger.info("ini DELETE /director/{}", id);
        directorService.deleteDirector(id);
        logger.info("end DELETE /director/{}", id);
        return ResponseEntity.noContent().build();
    }
}
