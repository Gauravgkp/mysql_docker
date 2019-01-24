package com.stackroute.muzixApplication.service;

import com.stackroute.muzixApplication.domain.Track;
import com.stackroute.muzixApplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixApplication.exception.TrackNotFoundException;
import com.stackroute.muzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl (TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Music track Id already exist");
        }
        Track savedTrack = trackRepository.save(track);
        if(savedTrack == null){
            throw new TrackAlreadyExistsException("Music track Id already exist");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTrack() throws TrackNotFoundException {
        if(trackRepository.findAll() == null){
            throw new TrackNotFoundException("No music track exist");
        }
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int trackId) throws TrackNotFoundException {
        if(!trackRepository.existsById(trackId)){
            throw new TrackNotFoundException("No music track exist with given track Id.");
        }
        Track trackById = trackRepository.findById(trackId).get();
        return trackById;
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        if(!trackRepository.existsById(track.getTrackId())){
            throw new TrackNotFoundException("No music track exist with given track Id to update.");
        }
        Track updatedTrack = trackRepository.save(track);
        return updatedTrack;
    }

    @Override
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
        List<Track> gettrackByName = trackRepository.trackByName(trackName);
        if(gettrackByName == null){
            throw new TrackNotFoundException("No music track exist with given track name.");
        }
        return gettrackByName;
    }

    @Override
    public void removeTrackById(int trackId) throws TrackNotFoundException {
        if(!trackRepository.existsById(trackId)){
            throw new TrackNotFoundException("No music track exist with given track id to remove.");
        }
        trackRepository.deleteById(trackId);
    }
}
