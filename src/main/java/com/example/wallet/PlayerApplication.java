package com.example.wallet;

import org.apache.hc.core5.http.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PlayerApplication {

    public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(PlayerApplication.class, args);
        Balance.sendBalanceUpdate();
    }

}
