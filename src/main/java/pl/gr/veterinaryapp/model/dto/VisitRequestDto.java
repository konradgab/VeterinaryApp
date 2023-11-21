package pl.gr.veterinaryapp.model.dto;

import lombok.*;
import pl.gr.veterinaryapp.common.OperationType;
import pl.gr.veterinaryapp.common.VisitType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;

@Data
@Builder(builderClassName = "VisitRequestDtoBuilder")
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class VisitRequestDto {

    private final Long vetId;
    private final Long petId;
    private final OffsetDateTime startDateTime;
    private final Duration duration;
    private final BigDecimal price;
    private final VisitType visitType;
    private final OperationType operationType;

//    public static class VisitRequestDtoBuilder {
//
//        private Long vetId = 1L;
//        private Long petId = 1L;
//        private OffsetDateTime startDateTime = OffsetDateTime.MIN;
//        private Duration duration = Duration.ZERO;
//        private BigDecimal price = BigDecimal.ZERO;
//    }
}
