import java.time.LocalDateTime;

class VIPAccessCard extends AccessCard {
    public VIPAccessCard(String cardId, LocalDateTime expiration) {
        super(cardId, expiration);
    }

    @Override
    public boolean hasAccess(String floor, String room) {
        return LocalDateTime.now().isBefore(expiration); // VIP has access to all areas if the card is valid
    }
}