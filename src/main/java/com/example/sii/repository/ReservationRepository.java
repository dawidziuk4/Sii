package com.example.sii.repository;

import com.example.sii.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query("SELECT COUNT(r.id) FROM Reservation r WHERE r.prelection = ?1")
    public int countPrelectionAttendance(int prelection);

    @Query("SELECT r.id from User u JOIN u.reservations r WHERE r.prelection=?1 AND u.login=?2")
    public Long findIdByPrelectionAndLogin(Integer prelection,String login);

    @Query("SELECT COUNT(r.id) from User u JOIN u.reservations r WHERE r.topic =?1")
    public int countChosenTopic(int topic);

}
