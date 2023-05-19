import be.ltmartin.springdemo.repository.HibernateSpeakerRepositoryImpl;
import be.ltmartin.springdemo.repository.SpeakerRepository;
import be.ltmartin.springdemo.service.SpeakerService;
import be.ltmartin.springdemo.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public static final String SPEAKER_SERVICE_BEAN_NAME = "speakerService";
    public static final String SPEAKER_REPOSITORY_BEAN_NAME = "speakerRepository";
    @Bean(name = SPEAKER_SERVICE_BEAN_NAME)
    public SpeakerService getSpeakerService(){
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
        speakerService.setRepository(getSpeakerRepository());
        return speakerService;
    }

    @Bean(name = SPEAKER_REPOSITORY_BEAN_NAME)
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }
}
