package be.ltmartin.conferencecalendar.controllers;

import be.ltmartin.conferencecalendar.models.Session;
import be.ltmartin.conferencecalendar.repositories.SessionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

//@SpringBootTest(classes = ConferenceCalendarApplication.class)
@WebMvcTest(controllers = SessionsController.class)
@AutoConfigureMockMvc(addFilters = false)
class SessionsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SessionRepository sessionRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private Session session1, session2, session3;

    @BeforeEach
    private void init(){
        session1 = Session.builder()
                .session_id(1L)
                .session_name("session1_name")
                .session_length(1)
                .session_description("session1 description")
                .build();

        session2 = Session.builder()
                .session_id(2L)
                .session_name("session2_name")
                .session_length(2)
                .session_description("session2 description")
                .build();

        session3 = Session.builder()
                .session_id(3L)
                .session_name("session3_name")
                .session_length(3)
                .session_description("session3 description")
                .build();
    }

    @Test
    void list() throws Exception {
        List<Session> sessions = List.of(session1, session2, session3);

        when(sessionRepository.findAll()).thenReturn(sessions);

        ResultActions response = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/sessions")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(result -> result.getResponse().getContentAsString().equals(sessions.toString()));

    }

    @Test
    void get() throws Exception{
        when(sessionRepository.getReferenceById(ArgumentMatchers.eq(1L))).thenReturn(session1);

        ResultActions response = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/sessions/1")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(result -> result.getResponse().getContentAsString().equals(session1.toString()));
    }

    @Test
    void create() {
        try {
        given(sessionRepository.saveAndFlush(ArgumentMatchers.any()))
                .willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

            ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/sessions")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(session1)));

            response.andExpect(MockMvcResultMatchers.status().isCreated());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}