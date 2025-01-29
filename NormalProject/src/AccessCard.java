import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AccessCard {
    private String cardId;
    private Set<String> permittedFloors;
    private Set<String> permittedRooms;
    private LocalDateTime expiration;

    public AccessCard(String cardId, LocalDateTime expiration) {
        this.cardId = cardId;
        this.expiration = expiration;
        this.permittedFloors = new HashSet<>();
        this.permittedRooms = new HashSet<>();
    }

    public void grantFloorAccess(String floor) {
        permittedFloors.add(floor);
    }

    public void grantRoomAccess(String room) {
        permittedRooms.add(room);
    }

    public void revokeFloorAccess(String floor) {
        permittedFloors.remove(floor);
    }

    public void revokeRoomAccess(String room) {
        permittedRooms.remove(room);
    }

    public boolean hasAccess(String floor, String room) {
        return LocalDateTime.now().isBefore(expiration) && (permittedFloors.contains(floor) || permittedRooms.contains(room));
    }

    public String getCardId() {
        return cardId;
    }
}