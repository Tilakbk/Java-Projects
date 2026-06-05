package com.hcms.hostelcomplaintmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ResolutionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID logId;

    @ManyToOne
    @JoinColumn(name = "complaint_id",nullable = false)
    private Complaint complaint;

    @ManyToOne
    @JoinColumn(name="staff_id",nullable = false)
    private Staff staff;

    @NotNull
    private String action_taken;

    @CreatedDate
    private LocalDateTime resolved_at;


}
