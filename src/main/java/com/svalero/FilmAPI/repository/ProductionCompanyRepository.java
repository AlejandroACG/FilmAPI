package com.svalero.FilmAPI.repository;
import com.svalero.FilmAPI.domain.ProductionCompany;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductionCompanyRepository extends CrudRepository<ProductionCompany, Long> {
    @NonNull
    List<ProductionCompany> findAll();
}
