package be.ltmartin.springdemo.repository;

import be.ltmartin.springdemo.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Leandro");
        speaker.setLastName("Tabares-Martín");
        speakers.add(speaker);

        return speakers;
    }
}
