import java.util.*;

public class pow {
        public static double myPow(double x, int n) {
            int exp = n;
           if(exp == 0) return 1;

           if(exp < 0){
            if (n == Integer.MIN_VALUE) {
                return 1 / (myPow(x, Integer.MAX_VALUE) * x);  // Prevent overflow
            }
                x = 1/x;
                exp = -exp;
           }

           if(exp % 2 == 1){
             return x*myPow(x , exp-1);
           }
            return myPow(x*x , exp/2);
        }
   public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
                System.out.println("Enter base :");
                double x = sc.nextDouble();
                System.out.println("Enter exponent :");
                int n = sc.nextInt();
                double result = myPow(x,n);
            System.out.println("Power of " + x + " is :" + result );
            sc.close();
}
}
