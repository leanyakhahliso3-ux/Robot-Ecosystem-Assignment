class FlyingRobot extends BaseRobot 
{
    private int altitude = 0;

    public FlyingRobot(String id, int batteryLevel) { super(id, batteryLevel); }

    public void fly(int targetAltitude) 
    {
        try {
            checkBattery();
            if (!isRunning()) 
                {
                System.out.println("Cannot fly. Start the robot first.");
                return;
            }
            this.altitude = targetAltitude;
            this.batteryLevel -= 10;
            System.out.println(" FlyingRobot [" + getId() + "] soared to " + altitude + " meters.");
        } catch (BatteryLowException e) {
            System.err.println(e.getMessage());
        }
    }

    public void move(int speed) {
        System.out.println(" FlyingRobot cruising forward at " + speed + " km/h.");
    }

    public void move(int speed, String direction) {
        System.out.println(" FlyingRobot cruising " + direction + " at " + speed + " km/h.");
    }
}

class MovingRobot extends BaseRobot 
{
    private int wheelSpeed = 0;

    public MovingRobot(String id, int batteryLevel) { super(id, batteryLevel); }

    public void drive() 
    {
        try {
            checkBattery();
            if (!isRunning()) return;
            this.batteryLevel -= 5;
            System.out.println(" MovingRobot [" + getId() + "] is driving across the terrain.");
        } catch (BatteryLowException e) {
            System.err.println(e.getMessage());
        }
    }

    public void move(int speed) 
    {
        this.wheelSpeed = speed;
        System.out.println(" MovingRobot wheeled speed set to " + wheelSpeed + " mph.");
    }

    public void move(int speed, String terrain) 
    {
        this.wheelSpeed = speed;
        System.out.println(" MovingRobot navigating through " + terrain + " terrain at " + speed + " mph.");
    }
}

class WalkingRobot extends BaseRobot 
{
    public WalkingRobot(String id, int batteryLevel) { super(id, batteryLevel); }

    public void walk() 
    {
        try {
            checkBattery();
            if (!isRunning()) return;
            this.batteryLevel -= 4;
            System.out.println(" WalkingRobot [" + getId() + "] engaging bipedal joints to walk.");
        } catch (BatteryLowException e) {
            System.err.println(e.getMessage());
        }
    }

    public void negotiateObstacle() 
    {
        System.out.println(" WalkingRobot [" + getId() + "] successfully climbed over an obstacle.");
    }

    public void move(int speed) 
    {
        System.out.println(" WalkingRobot taking steps at a pace of " + speed + " steps/min.");
    }

    public void move(int speed, String gaitPattern) 
    {
        System.out.println(" WalkingRobot performing a " + gaitPattern + " gait at " + speed + " steps/min.");
    }
}
