package com.module4.hibernate2_1;

import com.module4.hibernate2_1.entity.Rating;
import com.module4.hibernate2_1.entity.SpecialFeature;
import com.module4.hibernate2_1.service.CustomerService;
import com.module4.hibernate2_1.service.RentalService;
import com.module4.hibernate2_1.service.FilmService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        runCustomerService();
        runRentalService();
        runFilmService();


    }

    private static void runFilmService() {
        FilmService filmService = new FilmService();

        filmService.addNewFilm(
                "The Shmatrix",
                "Mentally ill person tries to avoid mental hospital.",
                1999,
                (byte) 1,
                new HashSet<>(Arrays.asList((short) 1, (short) 2)),
                new HashSet<>(Arrays.asList((byte) 1, (byte) 2)),
                (byte) 7,
                new BigDecimal("4.99"),
                (short) 136,
                new BigDecimal("19.99"),
                Rating.R,
                new HashSet<>(Arrays.asList(SpecialFeature.TRAILERS, SpecialFeature.COMMENTARIES)),
                (byte) 1
        );
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