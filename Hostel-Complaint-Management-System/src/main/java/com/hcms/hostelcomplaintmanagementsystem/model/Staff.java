package com.hcms.hostelcomplaintmanagementsystem.model;

import com.hcms.hostelcomplaintmanagementsystem.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID staffId;

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

    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
    private List<ResolutionLog> resolutionLogs;

    @OneToMany(mappedBy = "assignedStaff", cascade = CascadeType.ALL)
    private List<Complaint> assignedComplaint;
}