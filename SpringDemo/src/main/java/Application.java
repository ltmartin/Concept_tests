import be.ltmartin.springdemo.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SpeakerService speakerService = applicationContext.getBean(SpeakerService.SPEAKER_SERVICE_BEAN_NAME, SpeakerService.class);

        System.out.println("speakerService.findAll().get(0).getFirstName() = " + speakerService.findAll().get(0).getFirstName());
    }
}
