package com.kara.studentscareer.bachelorpapel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class BachelorPapelApplication {

    public static void main(String[] args) {
        SpringApplication.run(BachelorPapelApplication.class, args);
    }
}
