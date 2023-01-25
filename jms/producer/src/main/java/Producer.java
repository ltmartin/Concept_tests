import jakarta.annotation.Resource;
import jakarta.jms.*;

public class Producer {
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/MyQueue")
    private static Queue queue;
    @Resource(lookup = "jms/MyTopic")
    private static Topic topic;

    public static void main(String[] args) {
        try (JMSContext context = connectionFactory.createContext()){
            String messageToQueue = "Message sent to queue";
            context.createProducer().send(queue, messageToQueue);
            System.out.println(messageToQueue);

            String messageToTopic = "Message sent to topic";
            context.createProducer().send(topic, messageToTopic);
            System.out.println(messageToTopic);
        } catch (JMSRuntimeException e){
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }
}
