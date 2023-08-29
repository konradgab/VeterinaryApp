package pl.gr.veterinaryapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gr.veterinaryapp.common.VisitStatus;
import pl.gr.veterinaryapp.mapper.VetMapper;
import pl.gr.veterinaryapp.model.dto.ReportDto;
import pl.gr.veterinaryapp.model.dto.VetReportDto;
import pl.gr.veterinaryapp.model.entity.Visit;
import pl.gr.veterinaryapp.repository.VisitRepository;
import pl.gr.veterinaryapp.service.ReportService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final VisitRepository visitRepository;
    private final VetMapper vetMapper;

    @Override
    public ReportDto generateReportForThisMonth(int year, int month) {
        ReportDto reportDto = new ReportDto();
        Set<Visit> visits = visitRepository.findVisitsByYearAndMonth(year, month, VisitStatus.FINISHED);
        List<VetReportDto> vetStatistics = new ArrayList<>(visits.stream()
                .collect(Collectors.groupingBy(
                        visit -> visit.getVet().getId(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                visitsForVet -> {
                                    VetReportDto vetReportDto = vetMapper.toReportDto(visitsForVet.get(0).getVet());
                                    vetReportDto.setNumberOfVisits((long) visits.size());
                                    vetReportDto.setTotalVisitPrice(visitsForVet.stream()
                                            .map(Visit::getPrice)
                                            .reduce(BigDecimal.ZERO, BigDecimal::add));
                                    vetReportDto.setVisitIds(visitsForVet.stream()
                                            .map(Visit::getId)
                                            .collect(Collectors.toSet()));
                                    return vetReportDto;
                                }
                        )
                ))
                .values());

        int numberOfVisits = visits.size();
        BigDecimal earnings = visits.stream().map(Visit::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        reportDto.setEarnings(earnings);
        reportDto.setNumberOfVisits(numberOfVisits);
        reportDto.setDate(YearMonth.of(year, month));
        reportDto.setVetReportDto(vetStatistics);
        return reportDto;
    }
}
