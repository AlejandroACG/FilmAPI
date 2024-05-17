package com.svalero.FilmAPI.repository;
import com.svalero.FilmAPI.domain.Film;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    @NonNull
    List<Film> findAll();
}
