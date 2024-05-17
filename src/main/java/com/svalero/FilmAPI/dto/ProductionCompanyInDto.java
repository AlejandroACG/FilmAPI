package com.svalero.FilmAPI.dto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionCompanyInDto {
    private List<Long> filmIds = new ArrayList<>();
    private String name;
    private String location;
    private Integer revenue;
    private LocalDate established;
    private Boolean active;
}
