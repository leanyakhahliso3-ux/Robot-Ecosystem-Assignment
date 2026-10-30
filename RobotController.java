import java.util.ArrayList;
import java.util.List;

public class RobotController {
    private final List<Robot> fleet = new ArrayList<>();

    public void addRobot(Robot robot) {
        fleet.add(robot);
    }

    public void bootUpFleet() {
        System.out.println("\n--- Initiating Polymorphic Mass Boot-up ---");
        for (Robot r : fleet) { r.start(); }
    }

    public void checkFleetStatus() {
        System.out.println("\n--- Fleet Status Report ---");
        for (Robot r : fleet) { r.status(); }
    }

    public void shutDownFleet() {
        System.out.println("\n--- Initiating Polymorphic Mass Shutdown ---");
        for (Robot r : fleet) { r.stop(); }
    }
}
