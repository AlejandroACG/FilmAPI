package com.svalero.FilmAPI.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @ManyToOne
    @JoinColumn(name = "production_company_id", nullable = false)
    @JsonBackReference
    private ProductionCompany productionCompany;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    @JsonBackReference
    private Director director;

    @Column
    private String title;

    @Column
    private String genre;

    @Column
    private Integer revenue;

    @Column
    private LocalDate release;

    @Column(name = "family_friendly")
    private Boolean familyFriendly;
}
