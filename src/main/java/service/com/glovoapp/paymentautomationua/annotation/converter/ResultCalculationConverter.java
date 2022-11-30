package service.com.glovoapp.paymentautomationua.annotation.converter;

import lombok.extern.log4j.Log4j2;
import service.com.glovoapp.paymentautomationua.annotation.IRequestDataConverter;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationCategory;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationRequest;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationServiceRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Log4j2
public class ResultCalculationConverter implements IRequestDataConverter<ResultCalculationRequest, ResultCalculationServiceRequest> {

    @Override
    public ResultCalculationServiceRequest convert(ResultCalculationRequest data) {
        Objects.requireNonNull(data, "data is null");

        ResultCalculationServiceRequest serviceRequest = convertRequest(data);
        convertTrigger(data, serviceRequest);

        return serviceRequest;
    }

    private void convertTrigger(ResultCalculationRequest data, ResultCalculationServiceRequest serviceRequest) {
        try {
            serviceRequest.setPriority(Integer.parseInt(data.getTrigger()));
        } catch (NumberFormatException exc) {
            log.error("Could not parse priority. {}", exc);
            serviceRequest.setTrigger(data.getTrigger().toLowerCase());
        }
    }

    private ResultCalculationServiceRequest convertRequest(ResultCalculationRequest data) {
        return ResultCalculationServiceRequest.builder()
                .category(ResultCalculationCategory.valueOf(data.getCategory().toUpperCase()))
                .location(Long.valueOf(data.getLocation()))
                .fromDate(LocalDate.parse(data.getFromDate(),
                        DateTimeFormatter.ISO_LOCAL_DATE))
                .untilDate(LocalDate.parse(data.getUntilDate(),
                        DateTimeFormatter.ISO_LOCAL_DATE))
                .build();
    }
}
