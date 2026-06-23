package com.hcms.hostelcomplaintmanagementsystem.user;

import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.EmailAlreadyExistsException;
import com.hcms.hostelcomplaintmanagementsystem.model.Hostel;
import com.hcms.hostelcomplaintmanagementsystem.model.Staff;
import com.hcms.hostelcomplaintmanagementsystem.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(String fullName, String email, String password, Role role, Hostel hostel, Student student, Staff staff)
    {


        if (userRepo.existsByEmail(email))
        {
            throw  new EmailAlreadyExistsException(email+" This email already exists");
        }
        User user= new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        user.setStudent(student);
        user.setStaff(staff);

        userRepo.save(user);
    }
}
