package org.example.domain_driven_dev;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculateDiscountServiceTest {

    @Test
    public void noCustomer_thenExceptionShouldBeThrow() {
        // 테스트 목적의 대역 객체
        CustomerRepository stubRepo = mock(CustomerRepository.class);
        when(stubRepo.findById("noCustId")).thenReturn(null);

        RuleDiscounter stubRule = (cust, lines) -> null;

        CalculateDiscountService calDisSvc =
                new CalculateDiscountService(stubRepo, stubRule);
        assertThrows(NoCustomerException.class, () -> calDisSvc.calculateDiscount(someLines, "noCustId"));
    }

}