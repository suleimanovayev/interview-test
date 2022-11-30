package service.com.glovoapp.paymentautomationua.annotation.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ResultCalculationServiceRequest {
    private ResultCalculationCategory category;
    private Long location;
    private LocalDate fromDate;
    private LocalDate untilDate;
    private int priority;
    private String trigger;
}
