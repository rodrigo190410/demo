package com.example.demo;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.*;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner startConfiguration(
         @Autowired
         ReservationService reservationService,
         @Autowired
         CustomerService customerService,
         @Autowired
         UserService userService,
         @Autowired
         ParcelService parcelService,
         @Autowired
         AuthorityService authorityService
    ){
        return args -> {

            Authority authority1 = authorityService.add(new Authority(null,"ROLE_ADMIN",null));
            Authority authority2 = authorityService.add(new Authority(null,"ROLE_USER",null));
            Authority authority3 = authorityService.add(new Authority(null,"ROLE_ASSIST",null));

            //Data de prueba
            userService.addDTO(new UserDTO(null, "brunouser", "pass", "ROLE_USER"));
            userService.addDTO(new UserDTO(null, "luisuser", "pass", "ROLE_USER"));
            userService.addDTO(new UserDTO(null, "adrianauser", "pass", "ROLE_USER;ROLE_ASSIST"));


            customerService.add(new Customer(
                    null, "Bruno", "Guerrero", 999666333, userService.findById(1L), null,
                    null, null
                    ));
            customerService.add(new Customer(
                    null, "Luis Miguel", "Rojas", 123456789, userService.findById(2L), null,
                    null, null
            ));
            customerService.add(new Customer(
                    null, "Adriana", "Tapia", 987654321, userService.findById(3L), null,
                    null, null
            ));


            parcelService.add(new Parcel(null, "Cajarmaca - Sector Condorillo Alto", 2.5, -13.4589,
                    -76.1325,LocalDate.of(2026,04,30),
                    null, customerService.findById(1L)
                    ));
            parcelService.add(new Parcel(null, "Changuillo - San Javier", 4.5, -28.4589,
                    -50.1325,LocalDate.of(2026,04,25),
                    null, customerService.findById(2L)
            ));

            parcelService.add(new Parcel(null, "Huaral - Fundo Los Olivos", 6.0, -43.4753,
                    -25.4004,LocalDate.of(2026,04,04),
                    null, customerService.findById(3L)
            ));


            reservationService.add(new Reservation(
                    null, LocalDate.of(2026, 05,16),
                    LocalDate.of(2026, 05,18),
                    1.5, 333.33, 500.0, "ON GOING",null, new ArrayList<>(), customerService.findById(1L),
                    null, null, null
            ));

            reservationService.add(new Reservation(
                    null, LocalDate.of(2026, 05,22),
                    LocalDate.of(2026, 05,24),
                    3.5, 100.0, 350.0, "PENDING",null, new ArrayList<>(), customerService.findById(2L),
                    null, null, null
            ));

            reservationService.add(new Reservation(
                    null, LocalDate.of(2026, 05,26),
                    LocalDate.of(2026, 05,28),
                    6.0, 83.33, 500.0, "CANCELLED",null, new ArrayList<>(), customerService.findById(3L),
                    null, null, null
            ));
        };
    }

}
