import exceptions.*;

import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Receve {
    public static void main(String[] args) throws Exception {
        Scanner inp = new Scanner(System.in);
        int port;
        System.out.print("Enter Incoming Port : ");
        try {
            port = inp.nextInt();
        } catch (InputMismatchException e) {
            inp.nextLine();
            throw new InvalidPort("Please Enter valid port number");
        }

        System.out.println("Waiting for message...");
        DatagramSocket datSoc = new DatagramSocket(port);
        while (true) {
            byte[] msg = new byte[1024];
            DatagramPacket datPac = new DatagramPacket(msg, msg.length);
            datSoc.receive(datPac);
            String message = new String(datPac.getData(), 0, datPac.getLength());
            if (message.equals("User was exited")) {
                System.out.println("Exiting Session...");
                break;
            }
            System.out.println("User : " + message);
        }
        datSoc.close();
    }
}
