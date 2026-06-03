package com.hcms.hostelcomplaintmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID staff_id;

    @NotNull
    private String name;

    @NotNull
    private String role;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String phone;


}