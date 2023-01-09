/**
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        long nextPut = 0;
        long p = 0;
        long inPut = scanner.nextLong();
        while (inPut != 0) {
            if (inPut >= nextPut) {
                nextPut = inPut;
                p = inPut;
            } else {
                p = nextPut;
            }
            inPut = scanner.nextLong();

        }

        /**
         long nextPut = 0;
         long inPut = 0;
         do {
         inPut = scanner.nextLong();
         if (inPut > nextPut) {
         inPut = inPut;
         } else {
         inPut = nextPut;
         }
         //inPut = scanner.nextLong();


         } while (inPut != 0);

       // System.out.println(p);
   // }
// }
//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n = input.nextDouble();
        double sum = 0;
        int count = 0;
        double avg = 0;
        while (n != 0) {
            sum += n;
            count++;
            avg = sum / count;
            n = input.nextDouble();
        }



        System.out.println("%.11d", avg);
    }
}
*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i = scanner.nextInt();

        if (!input.matches("\\d+")) { // it checks if the input line does not contain only digits
            System.out.println("Incorrect number: " + input);
           // int dig = String.valueOf(i).length();
            int dig = (int) (Math.log10(i) +1);
            for (int s = 1; s <= dig; s++) {
                System.out.print(" ");
            }
            System.out.println("Hi");

        } else {
            int number = Integer.parseInt(input);
            System.out.println(number + 1);
        }
    }
}