package com.example.sii.repository;

import com.example.sii.dto.ReservationInfo;
import com.example.sii.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.example.sii.dto.ReservationInfo(u.login,u.email, r.prelection,r.topic) FROM User u JOIN u.reservations r WHERE r.prelection =?1")
    public List<ReservationInfo> getSinglePrelectionInfo(Integer prelectionNr);

    @Query("SELECT new com.example.sii.dto.ReservationInfo(u.login,u.email, r.prelection,r.topic) FROM User u JOIN u.reservations r ")
    public List<ReservationInfo> getAllRservationsInfo();

    public User findByLogin(String login);

    @Query("SELECT login FROM User WHERE login =?1")
    public String loginIsTaken(String login);

    @Query("SELECT r.prelection FROM User u JOIN u.reservations r WHERE u.login=?1 AND u.email=?2")
    public List<Integer> findAllReservedPrelectionByUser(String login, String email);

}
