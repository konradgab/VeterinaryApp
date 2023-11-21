package pl.gr.veterinaryapp.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gr.veterinaryapp.model.dto.ReportDto;
import pl.gr.veterinaryapp.service.ReportService;

@RequiredArgsConstructor
@RequestMapping("api/reports")
@RestController
public class ReportRestController {
    private final ReportService reportService;

    @GetMapping
    public ReportDto generateReportForThisMonth(@RequestParam int year, @RequestParam int month) {
        return reportService.generateReportForThisMonth(year, month);
    }
}
