package com.stackroute.muzixApplication.controller;

import com.stackroute.muzixApplication.domain.Track;
import com.stackroute.muzixApplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixApplication.exception.TrackNotFoundException;
import com.stackroute.muzixApplication.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *This is controller class which create object of TrackService class and
 * consume the methods of it.
 */
@RestController
@RequestMapping(value = "api/v1/")
@Api(value="Music Application",description = "You can add, search, update and delete your music list.")
public class TrackController {

    /* It instantiate the TrackService class so as to consume the
     * method of the same
     */
    private TrackService trackService;

    /*
     * Parameterized constructor to create TrackController instance.
     */
    @Autowired
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    /*
     * This method provide user a mean to add new track in the database.
     */
    @ApiOperation(value = "Add new music track")
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created new music track", HttpStatus.CREATED);
        }catch (TrackAlreadyExistsException ex){
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /*
     * This method provide user with all the track in the database.
     */
    @ApiOperation(value = "Get all music track")
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTrack(){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTrack(), HttpStatus.CREATED);
        }catch (TrackNotFoundException ex){
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /*
     *This method provide track details to the user of particular track Id.
     */
    @ApiOperation(value = "Get all music track by track Id")
    @GetMapping("/track/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(trackService.getTrackById(trackId), HttpStatus.OK);
        }catch (TrackNotFoundException ex){
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /*
     * This method help user to update track comment of a particular track Id.
     */
    @ApiOperation(value = "Update music track by track")
    @PutMapping("updateTrack")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(trackService.updateTrack(track), HttpStatus.ACCEPTED);
        }catch (TrackNotFoundException ex){
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /*
     * This method help user to remove the track from database based on the input track Id.
     */
    @ApiOperation(value = "Delete music track by track Id")
    @DeleteMapping("trackRemove/{trackId}")
    public ResponseEntity<?> removeTrackById (@PathVariable int trackId){
        ResponseEntity responseEntity;
        try {
            trackService.removeTrackById(trackId);
            responseEntity = new ResponseEntity<String>("removed", HttpStatus.ACCEPTED);
        }catch (TrackNotFoundException ex){
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /*
     * This method help user to update track comment of a particular track Id.
     */
    @GetMapping("/trackall/{trackName}")
    public ResponseEntity<?> gettrackByName(@PathVariable String trackName){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(trackService.getTrackByName(trackName), HttpStatus.ACCEPTED);
        }catch (TrackNotFoundException ex){
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

}
