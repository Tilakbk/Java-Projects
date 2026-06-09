package com.hcms.hostelcomplaintmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HostelComplaintManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HostelComplaintManagementSystemApplication.class, args);
    }

}

