/*
Visual solving of the problem of Tower of Hanoi with Rods and discs.
The use can chose the size of tower of hanoi.
The program starts from rod 1 and asks the user to input the destination (either of 2nd and 3rd rod)
 */

import java.util.Scanner;

public class TowerOfHanoi {

    int pointer;
    int[] lane1;
    int[] lane2;
    int[] lane3;

    Hanoi(int n) {
        lane1 = new int[n];
        lane2 = new int[n];
        lane3 = new int[n];
        for (int i = 0; i < n; i++)
            lane1[i] = n - i;

    }

    public void move(int from, int to) {

        int[] source;
        int[] destination;
        if (from == 1)
            source = lane1;
        else if (from == 2)
            source = lane2;
        else
            source = lane3;
        if (to == 1)
            destination = lane1;
        else if (to == 2)
            destination = lane2;
        else
            destination = lane3;

        int posGrabber1 = 0;
        int posGrabber2 = 0;

        for (int i = source.length - 1; i >= 0; i--) {
            if (source[i] != 0) {
                posGrabber1 = i;
                break;
            }
        }

        for (int i = source.length - 1; i >= 0; i--) {
            if (destination[i] != 0) {
                posGrabber2 = i + 1;
                break;
            }
        }

        if (posGrabber2 != 0) {
            if (source[posGrabber1] > destination[posGrabber2 - 1]) {
                System.out.println("Cant move bigger disc over smaller one");
                return;
            }
        }
        destination[posGrabber2] = source[posGrabber1];
        source[posGrabber1] = 0;
        System.out.println(
                "Disc " + destination[posGrabber2] + " moved from rod " + from + " to " + to);
    }


    public void print() {
        for (int i = lane1.length - 1; i >= 0; i--) {
            System.out.println(lane1[i] + "\t" + lane2[i] + "\t" + lane3[i]);
        }
        System.out.println("------------------------------");
    }

    public void solver(int n, int from, int to, int aux) {

        if (n == 1) {
            move(from, to);
            print();
            return;
        }
        solver(n - 1, from, aux, to);
        move(from, to);
        print();
        solver(n - 1, aux, to, from);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of tower of hanoi");
        int size = sc.nextInt();

        System.out.println("Choose either from rod 2 or 3 to transfer the discs to");
        int dest = 2;
        try {
            dest = sc.nextInt();
            if ((dest != 2 && dest != 3)) {
                throw new ArithmeticException("destination can't be other than 2 and 3");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            main(args);
            System.exit(0);
        }
        Hanoi a = new Hanoi(size);
        a.print();
        a.solver(size, 1, dest, (dest == 2) ? 3 : 2);
        sc.close();
    }
}
