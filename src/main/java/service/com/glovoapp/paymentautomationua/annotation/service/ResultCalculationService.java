package service.com.glovoapp.paymentautomationua.annotation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import service.com.glovoapp.paymentautomationua.annotation.converter.ResultCalculationConverter;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationRequest;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationResponse;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationServiceRequest;

import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
public class ResultCalculationService {
    private final ResultCalculationConverter resultCalculationConverter;
    private final RequestHandler requestHandler;

    public ResultCalculationResponse work(ResultCalculationRequest request) {
        Objects.requireNonNull(request, "request is null");

        ResultCalculationServiceRequest serverRequest = resultCalculationConverter.convert(request);
        return requestHandler.handleRequest(serverRequest);
    }
}
