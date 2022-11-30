package service.com.glovoapp.paymentautomationua.annotation.service;

import service.com.glovoapp.paymentautomationua.annotation.IRequestHandler;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationResponse;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationServiceRequest;

import java.util.Objects;

public class RequestHandler implements IRequestHandler {

    public ResultCalculationResponse handleRequest(ResultCalculationServiceRequest serviceRequest) {
        Objects.requireNonNull(serviceRequest, "serviceRequest is null");

        return new ResultCalculationResponse();
    }
}
