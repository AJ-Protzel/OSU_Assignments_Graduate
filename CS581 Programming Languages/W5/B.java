public class B implements Drivable {
    @Override
    public void start() {
        System.out.println("B is starting");
    }

    @Override
    public void accelerate() {
        System.out.println("B is accelerating");
    }

    @Override
    public void stop() {
        System.out.println("B is stopping");
    }

    @Override
    public void turnLeft() {
        System.out.println("B is turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("B is turning right");
    }
}