package com.rates.exchange;

import com.rates.exchange.configuration.PasswordEncodingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
        //PasswordEncodingConfiguration passwordEncodingConfiguration = new PasswordEncodingConfiguration();
        //System.out.println("////////"+passwordEncodingConfiguration.bCryptPasswordEncoder().encode("1111"));
    }

}
