package com.hcms.hostelcomplaintmanagementsystem.repository;

import com.hcms.hostelcomplaintmanagementsystem.model.Hostel;
import com.hcms.hostelcomplaintmanagementsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoomRepo extends JpaRepository<Room, UUID> {
    List<Room> findByHostel_HostelId(UUID hostelHostelId);

    boolean existsByRoomNumber(int roomNumber);

    boolean existsByRoomNumberAndHostel_HostelId(int roomNumber, UUID hostelHostelId);
}
