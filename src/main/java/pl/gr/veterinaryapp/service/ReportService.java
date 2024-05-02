package pl.gr.veterinaryapp.service;

import pl.gr.veterinaryapp.model.dto.ReportDto;

public interface ReportService {
ReportDto generateReportForThisMonth(int year,int month);
}
