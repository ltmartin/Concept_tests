import be.ltmartin.springdemo.repository.HibernateSpeakerRepositoryImpl;
import be.ltmartin.springdemo.repository.SpeakerRepository;
import be.ltmartin.springdemo.service.SpeakerService;
import be.ltmartin.springdemo.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"be.ltmartin.springdemo"})
public class AppConfig {

}
