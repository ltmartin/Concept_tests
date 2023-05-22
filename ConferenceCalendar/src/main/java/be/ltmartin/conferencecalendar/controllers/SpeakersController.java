package be.ltmartin.conferencecalendar.controllers;

import be.ltmartin.conferencecalendar.models.Speaker;
import be.ltmartin.conferencecalendar.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    private final SpeakerRepository speakerRepository;
    @Autowired
    public SpeakersController(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }
    @GetMapping
    public ResponseEntity<List<Speaker>> list(){
        return new ResponseEntity<>(this.speakerRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Speaker> get(@PathVariable Long id){
        Optional<Speaker> speakerOptional = Optional.of(this.speakerRepository.getReferenceById(id));
        return speakerOptional
                .map(speaker -> new ResponseEntity<>(speaker, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Speaker> create(@RequestBody final Speaker speaker){
        return new ResponseEntity<>(this.speakerRepository.saveAndFlush(speaker), HttpStatus.CREATED);
    }
}
