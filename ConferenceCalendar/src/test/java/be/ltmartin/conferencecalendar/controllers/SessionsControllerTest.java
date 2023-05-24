package be.ltmartin.conferencecalendar.controllers;

import be.ltmartin.conferencecalendar.ConferenceCalendarApplication;
import be.ltmartin.conferencecalendar.models.Session;
import be.ltmartin.conferencecalendar.repositories.SessionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = ConferenceCalendarApplication.class)
class SessionsControllerTest {

    @InjectMocks
    private SessionsController sessionsController;
    @Mock
    private SessionRepository sessionRepository;

    @Test
    void list() {
        Session session1 = Session.builder()
                .session_id(1L)
                .session_name("session1_name")
                .session_length(1)
                .session_description("session1 description")
                .build();

        Session session2 = Session.builder()
                .session_id(2L)
                .session_name("session2_name")
                .session_length(2)
                .session_description("session2 description")
                .build();

        Session session3 = Session.builder()
                .session_id(3L)
                .session_name("session3_name")
                .session_length(3)
                .session_description("session3 description")
                .build();

        List<Session> sessions = List.of(session1, session2, session3);

        when(sessionRepository.findAll()).thenReturn(sessions);

        ResponseEntity<List<Session>> response = sessionsController.list();
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody(), sessions);
    }

    @Test
    void get() {
        Session session1 = Session.builder()
                .session_id(1L)
                .session_name("session1_name")
                .session_length(1)
                .session_description("session1 description")
                .build();

        when(sessionRepository.getReferenceById(1L)).thenReturn(session1);

        ResponseEntity<Session> foundSession = sessionsController.get(1L);

        Assertions.assertEquals(foundSession.getBody(), session1);
        Assertions.assertEquals(foundSession.getStatusCode(), HttpStatus.FOUND);
    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}