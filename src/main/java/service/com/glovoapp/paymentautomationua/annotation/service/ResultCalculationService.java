package service.com.glovoapp.paymentautomationua.annotation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import service.com.glovoapp.paymentautomationua.annotation.converter.ResultCalculationConverter;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationRequestDto;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationResponseDto;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationServiceRequest;

import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
public class ResultCalculationService {
    private final ResultCalculationConverter resultCalculationConverter;
    private final RequestHandler requestHandler;

    public ResultCalculationResponseDto work(ResultCalculationRequestDto request) {
        Objects.requireNonNull(request, "request is null");

        ResultCalculationServiceRequest serverRequest = resultCalculationConverter.convert(request);
        return requestHandler.handleRequest(serverRequest);
    }
}
