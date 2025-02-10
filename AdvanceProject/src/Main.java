import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AccessLogger logger = new ConsoleLogger();
        AccessControlSystem system = new AccessControlSystem(logger);

        system.createCard("12345", LocalDateTime.now().plusDays(30), "Standard");
        system.modifyCard("12345", true, "Low Floor", "Room 101");
        system.attemptAccess("12345", "Low Floor", "Room 101");
        system.attemptAccess("12345", "High Floor", "Room 201");

        system.createCard("67890", LocalDateTime.now().plusDays(60), "VIP");
        system.attemptAccess("67890", "High Floor", "Room 201");

        system.createCard("54321", LocalDateTime.now().plusDays(1), "Guest");
        system.attemptAccess("54321", "Lobby", "Room 001");
        system.attemptAccess("54321", "Low Floor", "Room 101");
    }
}