package com.stackroute.muzixApplication.service;

import com.stackroute.muzixApplication.domain.Track;
import com.stackroute.muzixApplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixApplication.exception.TrackNotFoundException;

import java.util.List;

/*
 * This is an interface to implement the Track class of domain package.
 */
public interface TrackService {

    /*
     * This method provide user a mean to add new track in the database.
     */
     public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    /*
     * This method provide user with all the track in the database.
     */
    public List<Track> getAllTrack () throws TrackNotFoundException;

    /*
     *This method provide track details to the user of particular track Id.
     */
    public Track getTrackById(int trackId) throws TrackNotFoundException;

    /*
     * This method help user to update track comment of a particular track Id.
     */
    public Track updateTrack(Track track) throws TrackNotFoundException;

    /*
     * This method help user to remove the track from database based on the input track Id.
     */
    public void removeTrackById (int trackId) throws TrackNotFoundException;

    /*
     * This method help user to update track comment of a particular track Id.
     */
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException;
}
