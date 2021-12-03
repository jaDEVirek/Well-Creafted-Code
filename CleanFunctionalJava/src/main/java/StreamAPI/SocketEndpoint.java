package StreamAPI;


import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;

@ServerEndpoint(value = "/chat/{username}")
public class SocketEndpoint {

    private Session session;

    @OnOpen
    void onCreateSession(Session session) {
        this.session = session;
    }

    @OnMessage
    void onTextMessage(String message) throws IOException {
        System.out.println("Msg: " + message);
        if (Objects.nonNull(session) && this.session.isOpen()) {
            this.session.getBasicRemote()
                    .sendText("From server" + message);
        }
    }
    @OnError
    public void onError (Session session, Throwable throwable){
        // Do error handling here
    }

    @OnClose
    public void onClose(Session session) throws IOException {
//
//        chatEndpoints.remove(this);
//        Message message = new Message();
//        message.setFrom(users.get(session.getId()));
//        message.setContent("Disconnected!");
//        broadcast(message);
    }
}
