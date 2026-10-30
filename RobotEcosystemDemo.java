public class RobotEcosystemDemo {
    public static void main(String[] args) {
        // Constructing robot instances
        FlyingRobot drone = new FlyingRobot("SkyHawk-01", 85);
        MovingRobot rover = new MovingRobot("RoverX-02", 90);
        WalkingRobot android = new WalkingRobot("TitanMech-03", 12); // Low battery test case

        // Instantiate Controller
        RobotController controller = new RobotController();
        controller.addRobot(drone);
        controller.addRobot(rover);
        controller.addRobot(android);

        // Control via automation controller
        controller.bootUpFleet();
        controller.checkFleetStatus();

        System.out.println("\n--- Testing Specific Behaviors ---");
        drone.fly(250);
        drone.move(60);
        drone.move(80, "North-West");

        rover.drive();
        rover.move(45, "Muddy / Off-road");

        // Exceptional handling test (TitanMech-03 battery is under 15%)
        android.walk(); 
        android.negotiateObstacle();

        controller.checkFleetStatus();
        controller.shutDownFleet();
    }
}
