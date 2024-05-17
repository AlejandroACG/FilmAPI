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
@Entity(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Film> films = new ArrayList<>();

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer accolades;
    @Column
    private LocalDate birthdate;
    @Column
    private Boolean oscar;
}
