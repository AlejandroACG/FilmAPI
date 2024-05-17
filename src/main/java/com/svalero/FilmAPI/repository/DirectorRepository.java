package com.svalero.FilmAPI.repository;
import com.svalero.FilmAPI.domain.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
    @NonNull
    List<Director> findAll();
}
