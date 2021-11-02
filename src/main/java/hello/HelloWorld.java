package hello;

public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello world \n");

    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
  }
}
