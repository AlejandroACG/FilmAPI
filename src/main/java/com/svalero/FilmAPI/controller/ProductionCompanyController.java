package com.svalero.FilmAPI.controller;
import com.svalero.FilmAPI.domain.ProductionCompany;
import com.svalero.FilmAPI.dto.ProductionCompanyInDto;
import com.svalero.FilmAPI.service.ProductionCompanyService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductionCompanyController {
    @Autowired
    private ProductionCompanyService productionCompanyService;
    private final Logger logger = LoggerFactory.getLogger(ProductionCompanyController.class);

    @GetMapping("/production-companies")
    public ResponseEntity<List<ProductionCompany>> getProductionCompanies() {
        logger.info("ini GET /production-companies");
        List<ProductionCompany> productionCompanies = productionCompanyService.getProductionCompanies();
        logger.info("end GET /production-companies");
        return ResponseEntity.ok(productionCompanies);
    }

    @PostMapping("/production-companies")
    public ResponseEntity<ProductionCompany> addProductionCompany(
            @Valid @RequestBody ProductionCompanyInDto productionCompanyInDto) {
        logger.info("ini POST /production-companies");
        ProductionCompany productionCompany = productionCompanyService.addProductionCompany(productionCompanyInDto);
        logger.info("end POST /production-companies");
        return ResponseEntity.status(HttpStatus.CREATED).body(productionCompany);
    }

    @GetMapping("/production-company/{id}")
    public ResponseEntity<ProductionCompany> getProductionCompanyById(@PathVariable long id) {
        logger.info("ini GET /production-company/{}", id);
        ProductionCompany productionCompany = productionCompanyService.getProductionCompanyById(id);
        logger.info("end GET /production-company/{}", id);
        return ResponseEntity.ok(productionCompany);
    }

    @PutMapping("/production-company/{id}")
    public ResponseEntity<ProductionCompany> updateProductionCompany(@PathVariable long id,
                                           @Valid @RequestBody ProductionCompanyInDto productionCompanyInDto) {
        logger.info("ini PUT /production-company/{}", id);
        ProductionCompany productionCompany = productionCompanyService.updateProductionCompany(id, productionCompanyInDto);
        logger.info("end PUT /production-company/{}", id);
        return ResponseEntity.ok(productionCompany);
    }

    @DeleteMapping("/production-company/{id}")
    public ResponseEntity<Void> deleteProductionCompany(@PathVariable long id) {
        logger.info("ini DELETE /production-company/{}", id);
        productionCompanyService.deleteProductionCompany(id);
        logger.info("end DELETE /production-company/{}", id);
        return ResponseEntity.noContent().build();
    }
}
