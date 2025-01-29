import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AccessControlSystem {
    private Map<String, AccessCard> cards = new HashMap<>();
    private AccessLog accessLog = new AccessLog();

    public void createCard(String cardId, LocalDateTime expiration) {
        cards.put(cardId, new AccessCard(cardId, expiration));
        accessLog.logModification("Created", cardId);
    }

    public void modifyCard(String cardId, boolean grant, String floor, String room) {
        AccessCard card = cards.get(cardId);
        if (card != null) {
            if (grant) {
                if (floor != null) card.grantFloorAccess(floor);
                if (room != null) card.grantRoomAccess(room);
            } else {
                if (floor != null) card.revokeFloorAccess(floor);
                if (room != null) card.revokeRoomAccess(room);
            }
            accessLog.logModification("Modified", cardId);
        }
    }

    public void attemptAccess(String cardId, String floor, String room) {
        AccessCard card = cards.get(cardId);
        boolean success = card != null && card.hasAccess(floor, room);
        accessLog.logAttempt(cardId, floor, room, success);
    }

    public void printLogs() {
        accessLog.printLogs();
    }
}