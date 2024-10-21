package bill;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BillSystem {
  public static void printBill(String pName, int price, int quantity, float GST, Locale locale) {
    NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
    Date date = new Date();
    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
    System.out.println("Today's date " + df.format(date));
    System.out.printf("%-20s %10s %10s %10s %20s\n ", "Item", "Price", "Quantity", "GST", "Total Price");
    float totalGst = GST * price * quantity;
    float total = totalGst + price;
    System.out.printf("%-20s %10s %10s %10s %20s\n ", pName, price, quantity, totalGst, nf.format(total));
  }

  public static void main(String[] args) {
    Locale locale;
    ResourceBundle resourceBundle;
    Scanner scanner = new Scanner(System.in);
    System.out.println("choose your language");
    System.out.println("1.For English\n" +
        "2.For Hindi\n" +
        "3.For Japanese");
    int ch = scanner.nextInt();
  scanner.nextLine();
    locale = switch (ch) {
      case 1 -> Locale.US;
      case 2 -> Locale.of("hi", "IN");
      case 3 -> Locale.JAPAN;
      default -> Locale.US;
    };

    resourceBundle = ResourceBundle.getBundle("bill\\ResourceBundle", locale);
    System.out.println(resourceBundle.getString("GET_NAME"));
    String name = scanner.nextLine();
    System.out.println(resourceBundle.getString("GET_PRICE"));
    int price = scanner.nextInt();
    scanner.nextLine();
    System.out.println(resourceBundle.getString("GET_QUANTITY"));
    int quantity = scanner.nextInt();
    scanner.nextLine();
    System.out.println(resourceBundle.getString("GET_GST"));
    float gst = scanner.nextFloat();
    scanner.nextLine();
    printBill(name, price, quantity, gst, locale);

  }
}
