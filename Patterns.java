public class Patterns {

    // +
    // +
    // +
    // +
    // +++++++++
    // +
    // +
    // +
    // +
    static void jstars(int j) {
        if (j <= 0) {
            return;
        }
        System.out.print("+");
        jstars(j - 1);

    }

    static void jspaces(int j) {
        if (j <= 0) {
            return;
        }
        System.out.print(" ");
        jspaces(j - 1);

    }

    static void print11(int i, int j) {
        if (i <= 0) {
            return;
        }
        jspaces(j);
        System.out.print("+");
        System.out.println();
        print11(i - 1, j);

    }

    public static void plus(int n) {
        print11(n, n);
        jstars(2 * n + 1);
        System.out.println();
        print11(n, n);

    }

    // * *
    // * *
    // * *
    // * *
    // *
    // * *
    // * *
    // * *
    // * *
    static void crossHelper2(int i, int j, int n) {
        if (j <= 0) {
            return;
        }
        crossHelper2(i, j - 1, n);
        if (i == j || (i + j) == n + 1) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }

    static void crossHelper1(int i, int j, int n) {
        if (i <= 0) {
            return;
        }
        crossHelper1(i - 1, j, n);
        crossHelper2(i, j, n);
        System.out.println();

    }

    public static void cross(int n) {
        crossHelper1(2 * n + 1, 2 * n + 1, 2 * n + 1);
    }

    // ****
    // * *
    // * *
    // * *
    // * *
    // ****
    // * *
    // * *
    // * *
    // * *
    // ****

    static void jstarsWithCondition(int i, int j, int n) {
        if (j <= 0) {
            return;
        }
        if (j == 1 || j == n)
            System.out.print(" ");
        else
            System.out.print("*");
        jstarsWithCondition(i, j - 1, n);
    }

    static void print22(int i, int j, int n) {
        if (j <= 0) {
            return;
        }
        if (j == 1 || j == n)
            System.out.print("*");
        else
            System.out.print(" ");
        print22(i, j - 1, n);

    }

    static void print21(int i, int j, int n) {
        if (i <= 0) {
            return;
        }
        if (i == 1 || i == n)
            jstarsWithCondition(i, j, n);
        else
            print22(i, j, n);
        System.out.println();
        print21(i - 1, j, n);

    }

    static void print31(int i, int j, int n) {
        if (i <= 0) {
            return;
        }
        if (i == 1)
            jstarsWithCondition(i, j, n);
        else
            print22(i, j, n);
        System.out.println();
        print31(i - 1, j, n);

    }

    public static void eight(int n) {
        print21(n, n, n);
        print31(n - 1, n, n);
    }

    // ++++++
    // ++ ++
    // + +
    // + +
    // ++ ++
    // ++++++

    static void hollowHelper(int i, int j, int n) {
        if (i <= 0)
            return;
        hollowHelper(i - 1, j - 1, n);
        jstars(n - i + 1);
        jspaces(2 * (i - 1));
        jstars(n - i + 1);
        System.out.println();
    }

    static void hollowHelper2(int i, int j, int n) {
        if (i <= 0)
            return;
        jstars(n - i + 1);
        jspaces(2 * (i - 1));
        jstars(n - i + 1);
        System.out.println();
        hollowHelper2(i - 1, j - 1, n);
    }

    public static void hollow(int n) {
        hollowHelper(n, n, n);
        hollowHelper2(n, n, n);
    }

    public static void main(String[] args) {
        plus(5);
        System.out.println();
        cross(5);
        System.out.println();
        hollow(4);
        System.out.println();
        eight(8);
    }
}
