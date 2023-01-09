package cinema;


import java.util.Scanner;

public class Cinema {

    public static int totalSeats(int row, int seat) {
        return row * seat;
    }
    public static int row() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        String rowStrInput = input.next();
        //Note: Out of Heap Space error/Exception when large numbers are given
        //need to add further checking in the future
        if (!rowStrInput.matches("\\d+") || Integer.parseInt(rowStrInput) <= 0) {
            System.out.println("Wrong input!");
            rowStrInput = String.valueOf(row());
        }
        //int row = Integer.parseInt(rowStrInput);
        //return row;
        return Integer.parseInt(rowStrInput);
    }

    public static int seat() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of seats in each row:");
        String seatStrInput = input.next();
        if (!seatStrInput.matches("\\d+") || Integer.parseInt(seatStrInput) <= 0) {
            System.out.println("Wrong input!");
            seatStrInput = String.valueOf(row());
        }
        //int seat = Integer.parseInt(seatStrInput);
        //return seat;
        return Integer.parseInt(seatStrInput);
    }


    public static String manu() {

        String s = """
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """;
        return s;
    }

    public static String[][] makeSeats(int row, int seat) {
        String[][] cinema = new String[row + 1][seat + 1];
        //System.out.println("Cinema:");
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (i == 0 && j == 0) {
                    cinema[i][j] = " ";
                } else if (j == 0) {
                    cinema[i][j] = Integer.toString(i);
                } else if (i == 0) {
                    cinema[i][j] = Integer.toString(j);
                } else {
                    cinema[i][j] = "S";
                }
            }
        }
        return cinema;
    }

    public static void showSeats(String[][] cinema, int row, int seat) {
        System.out.println("Cinema:");
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }

    }

// Try to work on this below code to make the alignment of the seats and numbers : problem - as the digits increase
// from one to two and so on, each increase adds an extra space and misaligned the entire output
    /**public static void showSeats(String[][] cinema, int row, int seat) {
        System.out.println("Cinema:");
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(cinema[i][j]);
                int finalRowLength = cinema.length - 1;
                int dig = (int) (Math.log10(finalRowLength) + 1); // using log gives us the digits of the int i N j
                for (int o = 1; o <= dig; o++) {
                    System.out.println(" ");
                }


            }
            System.out.println();
        }

    }*/


    public static int rNum(int row) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a row number:");
        String rStrNum = input.next();
        if (!rStrNum.matches("\\d+") || Integer.parseInt(rStrNum) <= 0 || Integer.parseInt(rStrNum) > row) {
            System.out.println("Wrong input!");
            rStrNum = String.valueOf(rNum(row));
        }
        return Integer.parseInt(rStrNum);
    }

    public static int sNum(int seat) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a seat number in that row:");
        String sStrNum = input.next();
        if (!sStrNum.matches("\\d+") || Integer.parseInt(sStrNum) <= 0 || Integer.parseInt(sStrNum) > seat) {
            System.out.println("Wrong input!");
            sStrNum = String.valueOf(sNum(seat));
        }
        return Integer.parseInt(sStrNum);
    }

    //this method does two things, but it should do one thing only
    public static int bookIn(String[][] cinema, int row, int seat, int rNum, int sNum) {
        boolean t = true;
        int cIncome = 0;
        while (t) {
            if ("S".equals(cinema[rNum][sNum])) {
                cinema[rNum][sNum] = "B";
                System.out.println();
                cIncome = price(row, seat, rNum);
                System.out.printf("Ticket price: $%d", cIncome);
                System.out.println();
                t = false;
            } else {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
                System.out.println();
                rNum = rNum(row);
                sNum = sNum(seat);

            }
        }

    return cIncome;

    }

    public static int purchasedTickets(String[][] cinema) {
        int count = 0;
        for (String[] val1 : cinema) {
            for (String val2 : val1) {
                if ("B".equals(val2)) {
                    count++;
                }
            }
        }
       return count;
    }

    public static String percentageSold(double purchSeatCount, double row, double seat) {

        double percent = (purchSeatCount / (row * seat)) * 100;
        //use % sign to times to acutally use the percentage literal while using the % formatting
        return "Percentage: %.2f%%".formatted(percent);
    }

    public static String totalIncome(int row, int seat) {
        int totalIn;
        int frontR;
        int backR;
        int totalF;
        int totalB;

        if (totalSeats(row, seat) <= 60) {
            totalIn = 10 * totalSeats(row, seat);

        } else {
            frontR = row / 2;
            backR = row - frontR;
            totalF = frontR * seat * 10;
            totalB = backR * seat * 8;
            totalIn = totalF + totalB;
        }
        return String.format(String.format("Total income: $%d", totalIn));
    }

    public static int price(int row, int seat, int rNum) {
        int total;
        int frontR;

        if (totalSeats(row, seat) <= 60) {
            total = 10 * 1;

        } else {
            frontR = row / 2;
            if (rNum <= frontR) {
                total = 10 * 1;
            } else {
                total = 8 * 1;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner input = new Scanner(System.in);
        int row = row();
        int seat = seat();
        int currentInNum = 0;
        int currentIn = 0;
        int purchSeatCount;
        String[][] cinema = makeSeats(row, seat);


        boolean bool = true;
        while (bool) {

            System.out.println();
            System.out.print(manu());
            int manU = input.nextInt();
            if (manU >= 0 && manU <= 3) {
                System.out.println();
                switch (manU) {
                    case 1:
                        showSeats(cinema, row, seat);
                        break;
                    case 2:
                        int rNum = rNum(row);
                        int sNum = sNum(seat);
                        currentInNum = bookIn(cinema, row, seat, rNum, sNum);
                        currentIn += currentInNum;
                        break;
                    case 3:
                        purchSeatCount = purchasedTickets(cinema);
                        System.out.println(String.format("Number of purchased tickets: %d", purchSeatCount));
                        System.out.println(percentageSold(purchSeatCount, row, seat));
                        System.out.println(String.format("Current income: $%d", currentIn));
                        System.out.println(totalIncome(row, seat));
                        break;

                    case 0:
                        bool = false;
                        break;
                }
            } else {
                System.out.println("Wrong input!");
            }
        }

    }
}