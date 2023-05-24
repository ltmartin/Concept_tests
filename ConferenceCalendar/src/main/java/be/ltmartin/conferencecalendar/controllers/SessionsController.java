package be.ltmartin.conferencecalendar.controllers;

import be.ltmartin.conferencecalendar.models.Session;
import be.ltmartin.conferencecalendar.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    private final SessionRepository sessionRepository;
    @Autowired
    public SessionsController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    @GetMapping
    public ResponseEntity<List<Session>> list(){
        return new ResponseEntity<>(this.sessionRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Session> get(@PathVariable final Long id){
        Optional<Session> sessionOptional = Optional.of(this.sessionRepository.getReferenceById(id));
        return sessionOptional.map(session -> new ResponseEntity<>(session, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Session> create(@RequestBody final Session session){
        return new ResponseEntity<>(this.sessionRepository.saveAndFlush(session), HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable final Long id){
        this.sessionRepository.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Session> update(@PathVariable final Long id, @RequestBody final Session session){
        Session existingSession = this.sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return new ResponseEntity<>(this.sessionRepository.saveAndFlush(existingSession), HttpStatus.OK);
    }
}
