package be.ltmartin.springdemo.service;

import be.ltmartin.springdemo.model.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> findAll();
}
