package com.stackroute.muzixApplication.repository;

import com.stackroute.muzixApplication.domain.Track;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * This is Track object repository interface to implement the track service in repository.
 */
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer>{

    @Query("SELECT t FROM Track t WHERE t.trackName = ?1")
    public List<Track> trackByName(String trackName);
}
