import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AccessControlSystem system = new AccessControlSystem();

        system.createCard("12345", LocalDateTime.now().plusDays(30));
        system.modifyCard("12345", true, "Low Floor", "Room 101");
        system.attemptAccess("12345", "Low Floor", "Room 101");
        system.attemptAccess("12345", "High Floor", "Room 201");

        system.printLogs();
    }
}
