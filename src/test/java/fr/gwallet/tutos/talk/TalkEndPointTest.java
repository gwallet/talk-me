package fr.gwallet.tutos.talk;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TalkEndPointTest {
    private TalkEndPoint server;
    @Mock private Session session;
    @Mock private Session firstOpenSession;
    @Mock private Session secondOpenSession;
    @Mock private RemoteEndpoint.Basic basicRemote;

    @Before
    public void setUp() throws Exception {
        server = new TalkEndPoint();
        when(firstOpenSession.getBasicRemote()).thenReturn(basicRemote);
        when(secondOpenSession.getBasicRemote()).thenReturn(basicRemote);
        Set<Session> sessions = new LinkedHashSet<>();
        sessions.add(firstOpenSession);
        sessions.add(secondOpenSession);
        when(session.getOpenSessions()).thenReturn(sessions);
    }

    @Test
    public void server_can_dispatch_message() throws Exception {
        //  Given
        String message = "message";

        //  When
        server.dispatchMessage(message, session);

        //  Then
        verify(basicRemote, times(2)).sendText(message);
    }
}
