package com.svalero.FilmAPI.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmInDto {
    private Long productionCompanyId;
    private Long directorId;
    private String title;
    private String genre;
    private Integer revenue;
    private LocalDate release;
    private Boolean familyFriendly;
}
