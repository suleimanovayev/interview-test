package service.com.glovoapp.paymentautomationua.annotation.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultCalculationCategory {

    public static ResultCalculationCategory valueOf(String category) {
        return new ResultCalculationCategory();
    }
}
