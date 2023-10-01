package pl.gr.veterinaryapp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VisitStatus {
    SCHEDULED("Visit was scheduled successfully"),
    CANCELLED("Visit was scheduled successfully"),
    FINISHED("3"),
    DID_NOT_APPEAR("4"),
    EXPIRED("5");

    String description;
}
