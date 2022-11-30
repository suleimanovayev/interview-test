package service.com.glovoapp.paymentautomationua.annotation.converter;

import lombok.extern.log4j.Log4j2;
import service.com.glovoapp.paymentautomationua.annotation.IRequestDataConverter;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationCategory;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationRequestDto;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationServiceRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Log4j2
public class ResultCalculationConverter implements IRequestDataConverter<ResultCalculationRequestDto, ResultCalculationServiceRequest> {

    @Override
    public ResultCalculationServiceRequest convert(ResultCalculationRequestDto data) {
        Objects.requireNonNull(data, "data is null");

        ResultCalculationServiceRequest serviceRequest = convertRequest(data);
        convertTrigger(data, serviceRequest);

        return serviceRequest;
    }

    private void convertTrigger(ResultCalculationRequestDto data, ResultCalculationServiceRequest serviceRequest) {
        try {
            serviceRequest.setPriority(Integer.parseInt(data.getTrigger()));
        } catch (NumberFormatException exc) {
            log.error("Could not parse priority. {}", exc);
            serviceRequest.setTrigger(data.getTrigger().toLowerCase());
        }
    }

    private ResultCalculationServiceRequest convertRequest(ResultCalculationRequestDto data) {
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
