package service.com.glovoapp.paymentautomationua.annotation.controller;

import lombok.RequiredArgsConstructor;
import service.com.glovoapp.paymentautomationua.annotation.annotation.ControllerAuthorized;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationRequestDto;
import service.com.glovoapp.paymentautomationua.annotation.dto.ResultCalculationResponseDto;
import service.com.glovoapp.paymentautomationua.annotation.service.ResultCalculationService;

import java.time.format.DateTimeParseException;

// add logger
@Log4j2
@Path("/calculate")
// custom authorization check
@ControllerAuthorized
@RequiredArgsConstructor
// Change name of class to understand what it does
public class CalculationController {
    private final ResultCalculationService resultCalculationService;

    @GET
    // modify url. Instead of @Path("/calculate/{category}/{location}/{fromdate}/{untildate}/{trigger}").
    // easy to get lost in parameters
    @Path("/results")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    // Validate request
    // Add @BeanParam
    public Response calculateResults(@Valid @BeanParam ResultCalculationRequestDto request) {
        // Put logic inside service layer. In my previous place of work, handled the exceptions in the controller.
        try {
            ResultCalculationResponseDto response = resultCalculationService.work(request);
            return Response.ok(response).build();
            // add Response status in exception
        } catch (DateTimeParseException exc) {
            log.error("Could not parse one of the dates: '{}' or '{}'. {}", request.getFromDate(), request.getUntilDate(), exc);
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (NumberFormatException exc) {
            log.error("Could not parse location id '{}'. {}", request.getLocation(), exc);
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception exc) {
            log.error("Could calculate result. {}", exc);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}