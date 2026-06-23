    package com.hcms.hostelcomplaintmanagementsystem.repository;

    import com.hcms.hostelcomplaintmanagementsystem.model.Staff;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;
    import java.util.UUID;

    @Repository
    public interface StaffRepo extends JpaRepository<Staff,UUID> {
        boolean existsByEmail(String email);
        boolean existsByPhone(String phone);
        List<Staff> findAllByRole(String role);
        boolean existsByEmailAndStaffIdNot(String email, UUID staffId);
        boolean existsByPhoneAndStaffIdNot(String phone, UUID staffId);
    }
