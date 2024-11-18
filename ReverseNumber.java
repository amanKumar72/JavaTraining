import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReverseNumber {
    public static int length(long n) {
        int len = 0;
        while (n > 0) {
            n = n / 10;
            len++;
        }
        return len;
    }

    public static long reverse(long n) {
        long reversed = 0;
        while (n > 0) {
            int digit = (int) (n % 10);
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    public static boolean isPallendrome(long n) {
        if (n == reverse(n)) {
            return true;
        } else {
            return false;
        }
    }

    public static long reverse(long n, int r) {
        int len = length(n);
        if (r == 0)
            return n;
        if (r < 0) {
            r = len - Math.abs(r % len);
        } else {
            r = r % len;
        }

        long pow = (long) (Math.pow(10, r));
        long rem = n % pow;
        n = (long) (n / pow + rem * Math.pow(10, len - r));
        // while (r > 0) {
        // long rem = n % 10;
        // n = n / 10 + (long) Math.pow(10, len - 1) * rem;
        // r--;
        // }
        return n;
    }

    public static boolean checkAbleToBePallendrome(long n) {

        int len = length(n);
        int r = len - 1;
        if (isPallendrome(n)) {
            return true;
        }
        // long pow = (long) (Math.pow(10, r));
        // long rem = n % pow;
        // n = (long) (n / pow + rem * Math.pow(10, len - r));
        while (r > 0) {
            long rem = n % 10;
            n = n / 10 + (long) Math.pow(10, len - 1) * rem;
            if (isPallendrome(n)) {
                return true;
            }
            r--;
        }
        return false;
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char s = a.charAt(i);
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            char s = b.charAt(i);
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) - 1);
            } else {
                return false;
            }
        }
        for (Character c : hm.keySet()) {
            if (hm.get(c) != 0)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        // System.out.println(reverse(12345, 0));
        // System.out.println(reverse(12345, 2));
        // System.out.println(reverse(12345, -21));
        // Scanner sc = new Scanner(System.in);
        // long n = sc.nextLong();
        // System.out.println("can we make it palendrome " +
        // checkAbleToBePallendrome(4321123));
        // System.out.println("can we make it palendrome " +
        // checkAbleToBePallendrome(2112343));
        // System.out.println(isAnagram("aman", "anan"));
        String pattern = "([A-Z])(.+)";
        try{
            Pattern p=Pattern.compile(pattern);
            System.out.println("Valid");   
        }catch(Exception e){
            System.out.println("Invalid");
        }
    }
}
