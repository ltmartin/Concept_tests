package be.ltmartin.springdemo.service;

import be.ltmartin.springdemo.model.Speaker;
import be.ltmartin.springdemo.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {
    private SpeakerRepository repository;

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }


    public void setRepository(SpeakerRepository repository) {
        this.repository = repository;
    }
}
