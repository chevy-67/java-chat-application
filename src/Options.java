package src;

import java.util.*;

public class Options {
    public String targetIP = "192.168.210.206";
    public int port = 2929;
    Scanner inp = new Scanner(System.in);
    int i = 1;

    public boolean initialOptions() {
        while (i != 0) {
            System.out.println("-----------------------------------------");
            System.out.println("Using Port \t\t: " + port);
            System.out.println("Using IP Address \t: " + targetIP);
            System.out.println("-----------------------------------------");
            System.out.println("1.Change Port");
            System.out.println("2.Change Target IP");
            System.out.println("3.Continue");
            System.out.println("4.Exit\n");
            System.out.print("Enter Choice : ");
            int ch = inp.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Port Number : ");
                    port = inp.nextInt();
                    break;
                case 2:
                    System.out.print("Enter IP Address : ");
                    inp.nextLine();
                    targetIP = inp.nextLine();
                    break;
                case 3:
                    System.out.println("Alright!");
                    i = 0;
                    break;
                case 4:
                    i = 0;
                    return false;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
        return true;
    }

    public int getPort() {
        return port;
    }

    public String getIP() {
        return targetIP;
    }
}
