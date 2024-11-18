public class KAPExample {
    // 3214 3087 8352 6174

    public static int length(long n) {
        int len = 0;
        while (n > 0) {
            n = n / 10;
            len++;
        }
        return len;
    }

    static int max(int n) {
        int m = 0, r = 0;
        while (n > 0) {
            r = n % 10;
            if (r > m) {
                m = r;
            }
            n /= 10;
        }
        return m;
    }

    static int remove(int n, int max) {
        int r = 0, s = 0, c = 0;
        while (n > 0) {
            r = n % 10;
            if (r == max && c == 0) {
                c = 1;
            } else {
                s = s * 10 + r;
            }
            n /= 10;
        }
        return s;
    }

    static int desc(int n) {
        int len = length(n);
        int sum = 0;
        int max = 0;
        while (n > 0) {
            max = max(n);
            sum += max * Math.pow(10, len - 1);
            len--;
            n = remove(n, max);
        }
        return sum;
    }

    static int asc(int x) {
        int n = desc(x);
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    static boolean isKAP(int n) {
        if(n<1000 || n>10000) return false;

        int diff = desc(n) - asc(n);
        
        while (diff != 0) {
            if (diff == 6174) {
                return true;
            }
            System.out.println(diff);
            n = diff;
            diff = desc(n) - asc(n);
        }
        return false;
    }

    // 19 -> 82-> 68->100
    // HAPPY NUMBER
    static int sqSum(int n) {
        int sqSum = 0;
        while (n > 0) {
            int r = n % 10;
            sqSum += r * r;
            n /= 10;
        }
        return sqSum;
    }

    static int doubleSqSum(int n) {
        return sqSum(sqSum(n));
    }

    static boolean isHappyNumber(int n) {
        int sqSum = sqSum(n);
        int doubleSqSum = doubleSqSum(n);
        while (doubleSqSum != 1 && doubleSqSum != sqSum) {
            doubleSqSum=doubleSqSum(doubleSqSum);
            sqSum=sqSum(sqSum);
        }
        if (doubleSqSum == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // System.out.println(isKAP(3214));
        // System.out.println();
        // System.out.println(isKAP(6542));
        System.out.println(isHappyNumber(20));
    }
}
