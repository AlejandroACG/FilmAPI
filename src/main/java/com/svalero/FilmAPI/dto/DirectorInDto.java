package com.svalero.FilmAPI.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorInDto {
    private List<Long> filmIds = new ArrayList<>();
    private String name;
    private String surname;
    private Integer accolades;
    private LocalDate birthdate;
    private Boolean oscar;
}
