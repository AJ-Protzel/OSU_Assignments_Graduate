public class A implements Drivable {
    @Override
    public void start() {
        System.out.println("A is starting");
    }

    @Override
    public void accelerate() {
        System.out.println("A is accelerating");
    }

    @Override
    public void stop() {
        System.out.println("A is stopping");
    }

    @Override
    public void turnLeft() {
        System.out.println("A is turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("A is turning right");
    }
}
