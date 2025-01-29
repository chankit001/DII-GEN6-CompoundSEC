interface AccessLogger {
    void logAttempt(String cardId, String floor, String room, boolean success);
    void logModification(String action, String cardId);
}