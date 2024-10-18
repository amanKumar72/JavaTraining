public class RecursionDemo {

    // *****
    // *****
    // *****
    // *****
    // *****
    static void print12(int j) {
        if (j <= 0) {
            return;
        }
        System.out.print("*");
        print12(j - 1);

    }

    static void print11(int i, int j) {
        if (i <= 0) {
            return;
        }
        print12(j);
        System.out.println();
        print11(i - 1, j);

    }

    // *****
    // * *
    // * *
    // * *
    // *****

    static void print22(int j, int n) {
        if (j <= 0) {
            return;
        }
        if (j == 1 || j == n)
            System.out.print("*");
        else
            System.out.print(" ");
        print22(j - 1, n);

    }

    static void print21(int i, int j, int n) {
        if (i <= 0) {
            return;
        }
        if (i == 1 || i == n)
            print12(j);
        else
            print22(j, n);
        System.out.println();
        print21(i - 1, j, n);

    }

    // *
    // **
    // ***
    static void print31(int i, int j) {
        if (i <= 0) {
            return;
        }
        print31(i - 1, j - 1);
        System.out.println();
        print12(j);
    }

    // ****
    // ***
    // **
    // *

    static void print41(int i, int j) {
        if (i <= 0) {
            return;
        }
        print12(j);
        System.out.println();
        print41(i - 1, j - 1);
    }

    // *****
    // *****
    // *****
    // *****
    // *****

    static void print52(int j) {
        if (j <= 0) {
            return;
        }
        System.out.print(" ");
        print52(j - 1);
    }

    static void print51(int i, int j, int n) {
        if (i <= 0) {
            return;
        }
        print51(i - 1, j - 1, n);
        print52(j - 1);
        print12(n);
        System.out.println();
    }

    // *****
    // *****
    // *****
    // *****
    // *****
    static void print61(int i, int j, int n) {
        if (i <= 0) {
            return;
        }
        print52(j - 1);
        print12(n);
        System.out.println();
        print61(i - 1, j - 1, n);
    }

    public static void main(String[] args) {
        print11(5, 5);
        System.out.println();
        print21(5, 5, 5);
        System.out.println();
        print31(5, 5);
        System.out.println();
        System.out.println();
        print41(5, 5);
        System.out.println();
        print51(5, 5, 5);
        System.out.println();
        print61(5, 5, 5);
        System.out.println();
    }
}