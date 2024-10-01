public class ODDEVEN {
  public static void main(String[] args) {
    int n = 5;

    //using xor
    if ((n ^ 1) == (n - 1)) {
    System.err.println("odd"); // 7^6=1 i.e. odd and 10^11=1
    } else {
    System.out.println("even");
    }

    //using and
    if ((n & 1) == 1) {
    System.err.println("odd"); // 7^6=1 i.e. odd and 10^11=1
    } else {
    System.out.println("even");
    }



  }

}
