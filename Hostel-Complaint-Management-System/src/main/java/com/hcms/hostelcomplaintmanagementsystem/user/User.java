package com.hcms.hostelcomplaintmanagementsystem.user;

import com.hcms.hostelcomplaintmanagementsystem.model.Hostel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private UUID userId;

    @NotBlank
    private String fullName;

    @NotBlank
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hostel_d")
    private Hostel hostel;

}

