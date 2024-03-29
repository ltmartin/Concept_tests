package be.ltmartin.conferencecalendar.repositories;

import be.ltmartin.conferencecalendar.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
