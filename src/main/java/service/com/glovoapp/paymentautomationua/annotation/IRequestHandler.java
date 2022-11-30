package service.com.glovoapp.paymentautomationua.annotation;

import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationResponseDto;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationServiceRequest;

public interface IRequestHandler {
    ResultCalculationResponseDto handleRequest(ResultCalculationServiceRequest serviceRequest);
}
