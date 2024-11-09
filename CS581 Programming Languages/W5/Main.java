public class Main {
    public static void main(String[] args) {
        Drivable a = new A();
        Drivable b = new B();

        Navigator navigator = new Navigator();

        navigator.navigate(a);
        navigator.navigate(b);
    }
}
