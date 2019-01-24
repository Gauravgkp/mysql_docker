package com.stackroute.muzixApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Track class which deifne the track object property viz,
 * trackId, trackName and trackComment.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {

    @Id
    private int trackId; // Primary key to identify each track uniquely.
    private String trackName; //Stores the music name.
    private String trackComment; // Provide added comment about the particular music.

//    /* Parameterized constructor to add new music track in the database. */
//    public Track(int trackId, String trackName, String trackComment) {
//        this.trackId = trackId;
//        this.trackName = trackName;
//        this.trackComment = trackComment;
//    }
//
//    public Track(){
//
//    }
//
//    public int getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(int trackId) {
//        this.trackId = trackId;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getTrackComment() {
//        return trackComment;
//    }
//
//    public void setTrackComment(String trackComment) {
//        this.trackComment = trackComment;
//    }
//
//    @Override
//    public String toString() {
//        return "Track{" +
//                "trackId=" + trackId +
//                ", trackName='" + trackName + '\'' +
//                ", trackComment='" + trackComment + '\'' +
//                '}';
//    }
}
