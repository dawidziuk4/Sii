package com.example.sii.repository;

import com.example.sii.dto.ReservationInfo;
import com.example.sii.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.example.sii.dto.ReservationInfo(u.login, r.prelection) FROM User u JOIN u.reservations r WHERE r.prelection =?1")
    public List<ReservationInfo> getSinglePrelectionInfo(Integer prelectionNr);

    @Query("SELECT new com.example.sii.dto.ReservationInfo(u.login, r.prelection) FROM User u JOIN u.reservations r ")
    public List<ReservationInfo> getAllPrelectionsInfo();

    public User findByLogin(String login);
}
