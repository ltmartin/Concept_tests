package be.ltmartin.springdemo.service;

import be.ltmartin.springdemo.model.Speaker;
import be.ltmartin.springdemo.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(SpeakerService.SPEAKER_SERVICE_BEAN_NAME)
public class SpeakerServiceImpl implements SpeakerService {
    private SpeakerRepository repository;

    public SpeakerServiceImpl() {
        System.out.println(this.getClass().getName() + " parameterless constructor");
    }

    @Autowired
    public SpeakerServiceImpl(SpeakerRepository repository) {
        System.out.println(this.getClass().getName() + " parameter constructor");
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }

}
