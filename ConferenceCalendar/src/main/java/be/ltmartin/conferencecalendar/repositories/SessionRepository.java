package be.ltmartin.conferencecalendar.repositories;

import be.ltmartin.conferencecalendar.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
