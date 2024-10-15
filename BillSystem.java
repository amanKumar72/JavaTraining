import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

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
    Locale locale = Locale.of("hi", "IN");
    printBill("shoes", 250, 2, (float) 1.8, locale);

  }
}
