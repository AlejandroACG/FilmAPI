package com.svalero.FilmAPI.service;
import com.svalero.FilmAPI.domain.Director;
import com.svalero.FilmAPI.dto.DirectorInDto;
import com.svalero.FilmAPI.exception.EntityNotFoundException;
import com.svalero.FilmAPI.repository.DirectorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private ModelMapper modelMapper;
    private final String entityName = "Director";

    public List<Director> getDirectors() {
        return directorRepository.findAll();
    }

    public Director addDirector(DirectorInDto directorInDto) {
        return directorRepository.save(modelMapper.map(directorInDto, Director.class));
    }

    public Director getDirectorById(long id) {
        Optional<Director> directorOptional = directorRepository.findById(id);
        if (directorOptional.isPresent()) {
            return directorOptional.get();
        } else {
            throw new EntityNotFoundException(entityName, id);
        }
    }

    public Director updateDirector(long id, DirectorInDto directorInDto) {
        Optional<Director> directorOptional = directorRepository.findById(id);
        if (directorOptional.isPresent()) {
            Director director = directorOptional.get();
            modelMapper.map(directorInDto, director);
            return directorRepository.save(director);
        } else {
            throw new EntityNotFoundException(entityName, id);
        }
    }

    public void deleteDirector(long id) {
        if (directorRepository.existsById(id)) {
            directorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(entityName, id);
        }
    }
}
