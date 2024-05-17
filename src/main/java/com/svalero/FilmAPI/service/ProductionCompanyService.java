package com.svalero.FilmAPI.service;
import com.svalero.FilmAPI.domain.ProductionCompany;
import com.svalero.FilmAPI.dto.ProductionCompanyInDto;
import com.svalero.FilmAPI.repository.ProductionCompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductionCompanyService {
    @Autowired
    private ProductionCompanyRepository productionCompanyRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanyRepository.findAll();
    }

    public ProductionCompany addProductionCompany(ProductionCompanyInDto productionCompanyInDto) {
        return productionCompanyRepository.save(modelMapper.map(productionCompanyInDto, ProductionCompany.class));
    }

    public ProductionCompany getProductionCompanyById(long id) {
        Optional<ProductionCompany> productionCompanyOptional = productionCompanyRepository.findById(id);
        if (productionCompanyOptional.isPresent()) {
            return productionCompanyOptional.get();
        } else {
            throw new EntityNotFoundException("ProductionCompany", id);
        }
    }

    public ProductionCompany updateProductionCompany(long id, ProductionCompanyInDto productionCompanyInDto) {
        Optional<ProductionCompany> productionCompanyOptional = productionCompanyRepository.findById(id);
        if (productionCompanyOptional.isPresent()) {
            ProductionCompany productionCompany = productionCompanyOptional.get();
            modelMapper.map(productionCompanyInDto, productionCompany);
            return productionCompanyRepository.save(productionCompany);
        } else {
            throw new EntityNotFoundException("ProductionCompany", id);
        }
    }

    public void deleteProductionCompany(long id) {
        if (productionCompanyRepository.existsById(id)) {
            productionCompanyRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("ProductionCompany", id);
        }
    }
}
