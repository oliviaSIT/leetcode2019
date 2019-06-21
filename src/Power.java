public class Power {
    double myPow(double x, int n) {
        System.out.println(n);
        if (n < 0) return 1 / power(x, -n);
        return power(x, n);
    }
    double power(double x, int n) {
        System.out.println(n);
        if (n == 0) return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0) return half * half;
        return x * half * half;
    }

    /*
    public double myPow(double x, int n) {
        System.out.println(n);
        if (x == 0 || x == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / myPow(x, -1 * n);
        }

        if (n == 0) {
            return 1;
        }


        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }

    }
*/

}
