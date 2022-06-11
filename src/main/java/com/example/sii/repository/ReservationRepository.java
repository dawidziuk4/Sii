package com.example.sii.repository;

import com.example.sii.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT COUNT(r.id) FROM Reservation r WHERE r.prelection = ?1")
    public int countPrelectionAttendance(int prelection);

    @Modifying
    @Query(value = "INSERT INTO Reservation(prelection) VALUES(?1)", nativeQuery = true)
    public void addReservation(int prelection);
}
