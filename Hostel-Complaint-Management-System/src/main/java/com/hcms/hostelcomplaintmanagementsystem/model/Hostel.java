package com.hcms.hostelcomplaintmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID hostelId;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @OneToOne
    @JoinColumn(name ="warden_id", nullable = false)
    private Staff staff;
}
