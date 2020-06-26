package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    Smartphone smartphoneOne = new Smartphone(1, "testPhoneName1", 1111, "testManufacturer1");

    @Test
    void phoneNameTrue() {
        assertTrue(smartphoneOne.matches("testPhoneName1"));
    }

    @Test
    void phoneNameFalse() {
        assertFalse(smartphoneOne.matches("testPhoneNameX"));
    }

    @Test
    void phoneManufacturerTrue() {
        assertTrue(smartphoneOne.matches("testManufacturer1"));
    }

    @Test
    void phoneManufacturerFalse() {
        assertFalse(smartphoneOne.matches("testManufacturerX"));
    }


}