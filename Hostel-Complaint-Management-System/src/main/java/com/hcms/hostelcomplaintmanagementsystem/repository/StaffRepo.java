    package com.hcms.hostelcomplaintmanagementsystem.repository;

    import com.hcms.hostelcomplaintmanagementsystem.model.Staff;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.UUID;

    @Repository
    public interface StaffRepo extends JpaRepository<Staff,UUID> {
        boolean existsByEmail(String email);

        boolean existsByPhone(String phone);
    }
