package fr.gwallet.tutos.talk;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Slf4j
@ServerEndpoint("/talk")
public class TalkEndPoint {
    @OnMessage
    public void dispatchMessage(String message, Session session) throws IOException {
        log.debug("dispatching message : {} to {} clients", message, session.getOpenSessions().size());
        for (Session peer : session.getOpenSessions()) {
            peer.getBasicRemote().sendText(message);
        }
    }
}
