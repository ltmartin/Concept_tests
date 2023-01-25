import jakarta.annotation.Resource;
import jakarta.jms.*;

public class SyncConsumer {
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/MyTopic")
    private static Topic topic;
    @Resource(lookup = "jms/MyQueue")
    private static Queue queue;
    public static void main(String[] args){
        try (JMSContext context = connectionFactory.createContext()){
            JMSConsumer topicConsumer = context.createConsumer(topic);
            JMSConsumer queueConsumer = context.createConsumer(queue);

            while (true) {
                Message messageFromTopic = topicConsumer.receive(5000);
                if (null != messageFromTopic)
                    System.out.println(messageFromTopic.getBody(String.class));
                Message messageFromQueue = queueConsumer.receive(5000);
                if (null != messageFromQueue)
                    System.out.println(messageFromQueue.getBody(String.class));
            }
        } catch (JMSException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }
}
