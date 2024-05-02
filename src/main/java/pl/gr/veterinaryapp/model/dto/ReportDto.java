package pl.gr.veterinaryapp.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

@Data
public class ReportDto {
    private YearMonth date;
    private int numberOfVisits;
    private List<VetReportDto> vetReportDto;
    private BigDecimal earnings;
}
