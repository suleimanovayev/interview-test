package service.com.glovoapp.paymentautomationua.annotation.dto;

import lombok.Data;

@Data
public class ResultCalculationRequestDto {

    @QueryParam("category")
    @NotNull(message = "category is mandatory")
    private String category;

    @QueryParam("location")
    @NotNull(message = "location is mandatory")
    private String location;

    @QueryParam("fromdate")
    @NotNull(message = "Authorization is mandatory")
    private String fromDate;

    @QueryParam("untildate")
    @NotNull(message = "fromdate is mandatory")
    private String untilDate;

    @QueryParam("trigger")
    @NotNull(message = "trigger is mandatory")
    private String trigger;
}
