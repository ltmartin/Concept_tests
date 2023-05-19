package be.ltmartin.springdemo.repository;

import be.ltmartin.springdemo.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository(SpeakerRepository.SPEAKER_REPOSITORY_BEAN_NAME)
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
    private final Calendar cal;

    @Autowired
    public HibernateSpeakerRepositoryImpl(Calendar cal) {
        this.cal = cal;
    }

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Leandro");
        speaker.setLastName("Tabares-Martín");
        speakers.add(speaker);

        System.out.println(cal.getTime());

        return speakers;
    }
}
