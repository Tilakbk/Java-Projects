package com.hcms.hostelcomplaintmanagementsystem.repository;

import com.hcms.hostelcomplaintmanagementsystem.model.Hostel;
import com.hcms.hostelcomplaintmanagementsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoomRepo extends JpaRepository<Room, UUID> {

    @Query("select r from Room r where r.hostel.hostelId=:hostelId")
    List<Room> findByHostel_HostelId(@Param("hostelId") UUID hostelHostelId);

    @Query("select " +
            "case" +
            " when count(r)>0 then true else false " +
            "end" +
            " from Room r where r.roomNumber= :roomNumber and r.hostel.hostelId=:hostelId")
    boolean existsByRoomNumberAndHostel_HostelId(@Param("roomNumber") int roomNumber,@Param("hostelId") UUID hostelHostelId);
}
