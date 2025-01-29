import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccessLog {
    private List<String> logs = new ArrayList<>();

    public void logAttempt(String cardId, String floor, String room, boolean success) {
        logs.add(LocalDateTime.now() + " - Card " + cardId + " attempted access to Floor: " + floor + ", Room: " + room + " - " + (success ? "Granted" : "Denied"));
    }

    public void logModification(String action, String cardId) {
        logs.add(LocalDateTime.now() + " - " + action + " for Card " + cardId);
    }

    public void printLogs() {
        logs.forEach(System.out::println);
    }
}