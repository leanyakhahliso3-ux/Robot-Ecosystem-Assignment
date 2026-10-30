public abstract class BaseRobot implements Robot {
    private final String id;
    protected int batteryLevel; 
    private boolean isRunning;

    public BaseRobot(String id, int batteryLevel) {
        this.id = id;
        this.batteryLevel = batteryLevel;
        this.isRunning = false;
    }

    protected void checkBattery() throws BatteryLowException {
        if (batteryLevel < 15) {
            throw new BatteryLowException(" Warning: Robot [" + id + "] operation failed. Battery critically low: " + batteryLevel + "%.");
        }
    }

    @Override
    public void start() {
        this.isRunning = true;
        System.out.println(" Robot [" + id + "] powered ON.");
    }

    @Override
    public void stop() {
        this.isRunning = false;
        System.out.println(" Robot [" + id + "] powered OFF.");
    }

    @Override
    public void status() {
        System.out.println(" [ID: " + id + " | Type: " + this.getClass().getSimpleName() + " | Battery: " + batteryLevel + "% | Running: " + isRunning + "]");
    }

    public String getId() { return id; }
    public boolean isRunning() { return isRunning; }
}
