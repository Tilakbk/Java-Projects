    package com.hcms.hostelcomplaintmanagementsystem.repository;

    import com.hcms.hostelcomplaintmanagementsystem.model.Staff;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.util.List;
    import java.util.UUID;

    @Repository
    public interface StaffRepo extends JpaRepository<Staff,UUID> {
        boolean existsByEmail(String email);
        boolean existsByPhone(String phone);

        @Query("select s from Staff s where s.role=:role")
        List<Staff> findAllByRole(@Param("role") String role);

        @Query("select case " +
                "when count (s)>0 then true else false " +
                "end " +
                "from Staff s where s.email=:email and s.staffId !=:staffId")
        boolean existsByEmailAndStaffIdNot(@Param("email") String email, @Param("staffId") UUID staffId);

        @Query("select case " +
                "when count (s)>0 then true else false " +
                "end " +
                "from Staff s where s.phone=:phone and s.staffId !=:staffId")
        boolean existsByPhoneAndStaffIdNot(@Param("phone") String phone,@Param("staffId") UUID staffId);
    }
