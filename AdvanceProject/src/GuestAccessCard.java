import java.time.LocalDateTime;

class GuestAccessCard extends AccessCard {
    public GuestAccessCard(String cardId, LocalDateTime expiration) {
        super(cardId, expiration);
        permittedFloors.add("Lobby");
    }

    @Override
    public boolean hasAccess(String floor, String room) {
        return LocalDateTime.now().isBefore(expiration) && permittedFloors.contains(floor);
    }
}