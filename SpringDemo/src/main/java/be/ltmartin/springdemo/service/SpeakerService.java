package be.ltmartin.springdemo.service;

import be.ltmartin.springdemo.model.Speaker;

import java.util.List;

public interface SpeakerService {
    String SPEAKER_SERVICE_BEAN_NAME = "speakerService";
    List<Speaker> findAll();
}
