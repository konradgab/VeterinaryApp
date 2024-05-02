package pl.gr.veterinaryapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VetReportDto {
    private Long id;
    private String name;
    private String surname;
    private Long numberOfVisits;
    private BigDecimal totalVisitPrice;
    private Set<Long> visitIds;
}
