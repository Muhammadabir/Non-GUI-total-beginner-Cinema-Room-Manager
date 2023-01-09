
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        /**

        // start coding here
        int n = 115;

        int magic = 0;
        while (n > 0) {
            n /= 10;
            magic++;
        }
        System.out.println(magic);

         */

                Scanner scanner = new Scanner(System.in);
                // start coding here
                double m = scanner.nextDouble();
                double n = 1;
                double x = 1;

                while (x <= m) {
                    n++;
                    x *= n;

                }
                System.out.println(n);


    }

}