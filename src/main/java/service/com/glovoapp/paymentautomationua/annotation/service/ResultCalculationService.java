package service.com.glovoapp.paymentautomationua.annotation.service;

import com.glovoapp.paymentautomationua.service.converter.ResultCalculationConverter;
import com.glovoapp.paymentautomationua.service.dto.ResultCalculationRequest;
import com.glovoapp.paymentautomationua.service.dto.ResultCalculationResponse;
import com.glovoapp.paymentautomationua.service.dto.ResultCalculationServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
