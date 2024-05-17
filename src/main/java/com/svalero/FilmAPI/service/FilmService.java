package com.svalero.FilmAPI.service;
import com.svalero.FilmAPI.domain.Film;
import com.svalero.FilmAPI.dto.FilmInDto;
import com.svalero.FilmAPI.repository.FilmRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    public Film addFilm(FilmInDto filmInDto) {
        return filmRepository.save(modelMapper.map(filmInDto, Film.class));
    }

    public Film getFilmById(long id) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()) {
            return filmOptional.get();
        } else {
            throw new EntityNotFoundException("Film", id);
        }
    }

    public Film updateFilm(long id, FilmInDto filmInDto) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()) {
            Film film = filmOptional.get();
            modelMapper.map(filmInDto, film);
            return filmRepository.save(film);
        } else {
            throw new EntityNotFoundException("Film", id);
        }
    }

    public void deleteFilm(long id) {
        if (filmRepository.existsById(id)) {
            filmRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Film", id);
        }
    }
}
