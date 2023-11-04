package com.samuel.junit.tests.entities;

import com.samuel.junit.entities.Financing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinancingTest {

    @Test
    void constructorShouldCreateObjectWhenValidData() {
        // action
        Financing financing = new Financing(100000.0, 2000.0, 80);
        // assert
        assertNotNull(financing);
        assertEquals(100000.0, financing.getTotalAmount());
        assertEquals(2000.0, financing.getIncome());
        assertEquals(80, financing.getMonths());
    }

    @Test
    void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = new Financing(100000.0, 2000.0, 24);
        });
    }

    @Test
    void setTotalAmountShouldSetDataWhenValidData() {
        // arrange
        Financing financing = new Financing(100000.0, 2000.0, 80);
        // action
        financing.setTotalAmount(90000.0);
        // assert
        assertEquals(90000.0, financing.getTotalAmount());
    }

    @Test
    void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData() {
        Financing financing = new Financing(100000.0, 2000.0, 80);

        assertThrows(IllegalArgumentException.class, () -> {
            financing.setTotalAmount(101000.0);
        });
    }

    @Test
    void setIncomeShouldSetDataWhenValidData() {
        // arrange
        Financing financing = new Financing(100000.0, 2000.0, 80);
        // action
        financing.setIncome(2500.0);
        // assert
        assertEquals(2500.0, financing.getIncome());
    }

    @Test
    void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {
        Financing financing = new Financing(100000.0, 2000.0, 80);

        assertThrows(IllegalArgumentException.class, () -> {
            financing.setIncome(1000.0);
        });
    }

    @Test
    void setMonthsShouldSetDataWhenValidData() {
        // arrange
        Financing financing = new Financing(100000.0, 2000.0, 80);
        // action
        financing.setMonths(82);
        // assert
        assertEquals(82, financing.getMonths());
    }

    @Test
    void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {
        Financing financing = new Financing(100000.0, 2000.0, 80);

        assertThrows(IllegalArgumentException.class, () -> {
            financing.setMonths(78);
        });
    }

    @Test
    void entryShouldCalculateEntryCorrectly() {
        // arrange
        Financing financing = new Financing(100000.0, 2000.0, 80);
        // action
        Double entry = financing.entry();
        // assert
        assertEquals(20000.0, entry);
    }

    @Test
    void quotaShouldCalculateQuotaCorrectly() {
        // arrange
        Financing financing = new Financing(100000.0, 2000.0, 80);
        // action
        Double quota = financing.quota();
        // assert
        assertEquals(1000.0, quota);
    }
}