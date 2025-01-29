import java.time.LocalDateTime;

class StandardAccessCard extends AccessCard {
    public StandardAccessCard(String cardId, LocalDateTime expiration) {
        super(cardId, expiration);
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

    @Override
    public boolean hasAccess(String floor, String room) {
        return LocalDateTime.now().isBefore(expiration) && (permittedFloors.contains(floor) || permittedRooms.contains(room));
    }
}