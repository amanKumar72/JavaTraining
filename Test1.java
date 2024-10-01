
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test1 {
  public static void main(String[] args) throws FileNotFoundException {
    // int a = 5;
    // int b = 6;

    // a=a+b;
    // b=a-b;
    // a=a-b;
    // System.out.println((a+" "+b));

    // a = a * b;
    // b = a / b;
    // a = a / b;
    // System.out.println((a + " " + b));

    // a = a ^ b;
    // b = a ^ b;
    // a = a ^ b;
    // System.out.println((a + " " + b));

    Integer a = Integer.parseInt(args[0]);
    Integer b = Integer.parseInt(args[1]);
    double ans = switch (args[2]) {
      case "+" -> a + b;
      case "-" -> a - b;
      case "x" -> a * b;
      case "/" -> a / b;
      default -> 0;
    };
    @SuppressWarnings("resource")
    PrintStream out = new PrintStream("C:\\Users\\hp\\Documents\\aman\\Info2.jpg");

    out.println(ans);
    out.println("ans");
  }
}