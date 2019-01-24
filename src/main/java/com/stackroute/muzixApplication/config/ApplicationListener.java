package com.stackroute.muzixApplication.config;

import com.stackroute.muzixApplication.domain.Track;
import com.stackroute.muzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/*
 *This class help user to pre fill seed data in the created Track object.
 */
@Component
public class ApplicationListener implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {

    /*
     *Instance of TrackRepository to fill the seed with startup data.
     */
    @Autowired
    private TrackRepository trackRepository;

    @Value("2")
    private int trackId;

    @Value("default listener")
    private String trackName;

    @Value("default listener comments")
    private String trackComment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Track track = new Track(trackId, trackName, trackComment);
        trackRepository.save(track);
    }

}
