public class StrngTest {
  public static void main(String[] args) {

    long st, end;
    st = System.nanoTime();
    for (int i = 0; i < 100; i++) {
      System.err.println("Aman");
    }
    end = System.nanoTime();
    System.err.println("Time for String = " + (end - st));//slow

    st = System.nanoTime();
    StringBuilder sb = new StringBuilder("aman");
    for (int i = 0; i < 100; i++) {
      System.err.println(sb);
    }
    end = System.nanoTime();
    System.err.println("Time for StringBuilder = " + (end - st));//fastest

    st = System.nanoTime();
    StringBuffer sbuf = new StringBuffer("aman");
    for (int i = 0; i < 100; i++) {
      System.err.println(sbuf);
    }
    end = System.nanoTime();
    System.err.println("Time for StringBuffer = " + (end - st));//faster

  }
}
