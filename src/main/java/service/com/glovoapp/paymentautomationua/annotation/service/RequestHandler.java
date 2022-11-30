package service.com.glovoapp.paymentautomationua.annotation.service;

import service.com.glovoapp.paymentautomationua.annotation.IRequestHandler;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationResponseDto;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationServiceRequest;

import java.util.Objects;

public class RequestHandler implements IRequestHandler {

    public ResultCalculationResponseDto handleRequest(ResultCalculationServiceRequest serviceRequest) {
        Objects.requireNonNull(serviceRequest, "serviceRequest is null");

        return new ResultCalculationResponseDto();
    }
}
