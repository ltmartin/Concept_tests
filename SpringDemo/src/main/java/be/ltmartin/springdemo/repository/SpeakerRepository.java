package be.ltmartin.springdemo.repository;

import be.ltmartin.springdemo.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    public static final String SPEAKER_REPOSITORY_BEAN_NAME = "speakerRepository";
    List<Speaker> findAll();
}
