package service.com.glovoapp.paymentautomationua.annotation;

import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationResponse;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationServiceRequest;

public interface IRequestHandler {
    ResultCalculationResponse handleRequest(ResultCalculationServiceRequest serviceRequest);
}
