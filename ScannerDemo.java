import java.util.Scanner;

public class ScannerDemo {
  static int countWords(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ' || s.charAt(i) == '\n' || s.charAt(i) == '\t') {
        count++;
      }
    }
    if (!(s.charAt(s.length() - 1) == '\n' || s.charAt(s.length() - 1) == '\t' || s.charAt(s.length() - 1) == ' ')) {
      count++;
    }

    // int count = 0;
    // Scanner sc=new Scanner(s);
    // while(sc.hasNext()){
    // sc.next();
    // count++;

    // String[] str=s.trim().split(" ");
    // return str.length;

    return count;
  }

  public static void main(String[] args) {
    System.out.println(countWords("h\nhsaj"));
  }
}
