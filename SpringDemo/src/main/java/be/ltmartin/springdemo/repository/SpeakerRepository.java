package be.ltmartin.springdemo.repository;

import be.ltmartin.springdemo.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
