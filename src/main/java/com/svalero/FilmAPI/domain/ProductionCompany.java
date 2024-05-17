package com.svalero.FilmAPI.domain;
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
@Entity(name = "production_companies")
public class ProductionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "productionCompany", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Film> films = new ArrayList<>();

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private Integer revenue;

    @Column
    private LocalDate established;

    @Column
    private Boolean active;
}
