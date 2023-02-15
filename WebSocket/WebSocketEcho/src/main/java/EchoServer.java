import jakarta.websocket.OnMessage;
import jakarta.websocket.server.ServerEndpoint;

@SuppressWarnings("unused")
@ServerEndpoint("/echo")
public class EchoServer {

    @SuppressWarnings("unused")
    @OnMessage
    public String echo(String message){
        return "I have received this (" + message + ") message";
    }
}
