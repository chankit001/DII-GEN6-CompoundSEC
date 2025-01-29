import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class AccessControlSystem {
    private Map<String, AccessCard> cards = new HashMap<>();
    private AccessLogger logger;

    public AccessControlSystem(AccessLogger logger) {
        this.logger = logger;
    }

    public void createCard(String cardId, LocalDateTime expiration) {
        cards.put(cardId, new StandardAccessCard(cardId, expiration));
        logger.logModification("Created", cardId);
    }

    public void modifyCard(String cardId, boolean grant, String floor, String room) {
        AccessCard card = cards.get(cardId);
        if (card instanceof StandardAccessCard) {
            StandardAccessCard standardCard = (StandardAccessCard) card;
            if (grant) {
                if (floor != null) standardCard.grantFloorAccess(floor);
                if (room != null) standardCard.grantRoomAccess(room);
            } else {
                if (floor != null) standardCard.revokeFloorAccess(floor);
                if (room != null) standardCard.revokeRoomAccess(room);
            }
            logger.logModification("Modified", cardId);
        }
    }

    public void attemptAccess(String cardId, String floor, String room) {
        AccessCard card = cards.get(cardId);
        boolean success = card != null && card.hasAccess(floor, room);
        logger.logAttempt(cardId, floor, room, success);
    }
}
