import java.time.LocalDateTime;

class ConsoleLogger implements AccessLogger {
    @Override
    public void logAttempt(String cardId, String floor, String room, boolean success) {
        System.out.println(LocalDateTime.now() + " - Card " + cardId + " attempted access to Floor: " + floor + ", Room: " + room + " - " + (success ? "Granted" : "Denied"));
    }

    @Override
    public void logModification(String action, String cardId) {
        System.out.println(LocalDateTime.now() + " - " + action + " for Card " + cardId);
    }
}