import java.util.*;

public class KeithNumber {
    // Keith no
    // n=197 -> 1 9 7 17 33 57 107 197

    public static int length(long n) {
        int len = 0;
        while (n > 0) {
            n = n / 10;
            len++;
        }
        return len;
    }

    static ArrayList<Integer> array(int n, int len) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (n > 0) {
            arr.add(n % 10);
            n /= 10;
        }
        for (int i = 0, j = arr.size() - 1; i < j; i++, j--) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
        return arr;
    }

    static int sum(ArrayList<Integer> a, int i, int len) {
        int res = 0;
        for (int j = i; j < i + len; j++) {
            res += a.get(j);
        }
        return res;
    }

    static boolean isKeithNo(int n) {
        int len = length(n);
        ArrayList<Integer> arr = array(n, len);
        // System.out.println(arr);
        // System.out.println(len);
        int res = sum(arr, 0, len);
        int i = 1;
        while (res < n) {
            // System.out.println(res);
            arr.add(res);
            res = sum(arr, i++, len);
        }
        if (res == n) {
            return true;
        }
        return false;
    }

    // n=6 -> n2->36 ends with 6
    // n=25 -> n2=625 ends with 25

    static boolean isEndsWithN(int n) {
        int square = n * n;
        int itrSize = length(square) / 2 + 1;
        for (int i = 1; i <= itrSize; i++) {
            if (square % Math.pow(10, i) == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("197 is keith no " + isKeithNo(197));
        System.out.println("14 is keith no " + isKeithNo(14));
        System.out.println("123 is keith no " + isKeithNo(123));
        System.out.println("742 is keith no " + isKeithNo(742));
        System.out.println("19 is keith no " + isKeithNo(19));
        System.out.println("11436171 is keith no " + isKeithNo(11436171));
        System.out.println("120284 is keith no " + isKeithNo(
                120284));
        System.out.println();
        System.out.println("square of 25 is ewnds with 25 " + isEndsWithN(25));
        System.out.println("square of 6 is ewnds with 6 " + isEndsWithN(6));
        System.out.println("square of 24is ewnds with 24 " + isEndsWithN(24));
    }
}
