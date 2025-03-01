package com.module4.hibernate2_1;

import com.module4.hibernate2_1.service.CustomerService;

public class Main {

    public static void main(String[] args) {

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