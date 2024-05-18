package com.svalero.FilmAPI.service;
import com.svalero.FilmAPI.domain.Film;
import com.svalero.FilmAPI.dto.FilmInDto;
import com.svalero.FilmAPI.exception.EntityNotFoundException;
import com.svalero.FilmAPI.repository.DirectorRepository;
import com.svalero.FilmAPI.repository.FilmRepository;
import com.svalero.FilmAPI.repository.ProductionCompanyRepository;
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
    private DirectorRepository directorRepository;
    @Autowired
    private ProductionCompanyRepository productionCompanyRepository;
    @Autowired
    private ModelMapper modelMapper;
    private final String entityName = "Film";

    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    public Film addFilm(FilmInDto filmInDto) {
        long productionCompanyId = filmInDto.getProductionCompanyId();
        long directorId = filmInDto.getDirectorId();
        if (productionCompanyRepository.existsById(productionCompanyId)) {
            if (directorRepository.existsById(directorId)) {
                Film film = modelMapper.map(filmInDto, Film.class);
                film.setProductionCompany(productionCompanyRepository.findById(productionCompanyId).orElse(null));
                film.setDirector(directorRepository.findById(directorId).orElse(null));
                return modelMapper.map(filmRepository.save(film), Film.class);
            } else {
                throw new EntityNotFoundException("Director", filmInDto.getDirectorId());
            }
        } else {
            throw new EntityNotFoundException("Production Company", filmInDto.getProductionCompanyId());
        }
    }

    public Film getFilmById(long id) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()) {
            return filmOptional.get();
        } else {
            throw new EntityNotFoundException(entityName, id);
        }
    }

    public Film updateFilm(long id, FilmInDto filmInDto) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()) {
            Film film = filmOptional.get();
            modelMapper.map(filmInDto, film);
            return filmRepository.save(film);
        } else {
            throw new EntityNotFoundException(entityName, id);
        }
    }

    public void deleteFilm(long id) {
        if (filmRepository.existsById(id)) {
            filmRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(entityName, id);
        }
    }
}
