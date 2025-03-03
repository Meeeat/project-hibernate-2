package com.module4.hibernate2_1;

import com.module4.hibernate2_1.service.CustomerService;
import com.module4.hibernate2_1.service.RentalService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        runCustomerService();
        runRentalService();


    }

    private static void runRentalService() {
        RentalService rentalService = new RentalService();
        rentalService.returnRentedFilm(11593, (byte) 1, new BigDecimal("5.00"));

        rentalService.rentInventory(1, 1, (byte) 1, new BigDecimal("10.00"));
    }

    private static void runCustomerService() {
        CustomerService customerService = new CustomerService();

        customerService.createNewCustomer(
                "Vasia",
                "Pupkin",
                "vasia_pupkin@none.net",
                "123 Main St",
                "California",
                "Los Angeles",
                "USA",
                "90001",
                "123-456-7890"
        );
    }

}