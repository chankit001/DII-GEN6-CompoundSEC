import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

abstract class AccessCard {
    protected String cardId;
    protected Set<String> permittedFloors;
    protected Set<String> permittedRooms;
    protected LocalDateTime expiration;

    public AccessCard(String cardId, LocalDateTime expiration) {
        this.cardId = cardId;
        this.expiration = expiration;
        this.permittedFloors = new HashSet<>();
        this.permittedRooms = new HashSet<>();
    }

    public abstract boolean hasAccess(String floor, String room);

    public String getCardId() {
        return cardId;
    }
}