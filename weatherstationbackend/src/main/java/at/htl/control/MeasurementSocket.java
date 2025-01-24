package at.htl.control;

import at.htl.model.Measurement;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/measurement/{sensorId}/socket")
@ApplicationScoped
public class MeasurementSocket {

    private Map<Session, Long> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("sensorId") Long sensorId) {
        sessions.put(session, sensorId);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // Handle incoming messages if needed
    }

    public void broadcastMeasurement(Measurement measurement) {
        sessions.forEach((session, sensorId) -> {
            if (sensorId.equals(measurement.sensor.id)) {
                session.getAsyncRemote().sendObject(measurement);
            }
        });
    }
}