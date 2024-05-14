package staticdemo;

public class Client {
    public static void main(String[] args) {
        BMW bmw = new BMW();
        bmw.start();
        Car car = new BMW();
        car.start();
    }
}
