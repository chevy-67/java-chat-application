import src.Options;

import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.io.File;

class SendMessage {
    private InetAddress ip;
    private int port;
    private DatagramPacket pac;

    SendMessage(String ip, int port) throws Exception {
        this.ip = InetAddress.getByName(ip);
        this.port = port;
    }

    void sendMsg(String msg) throws Exception {
        DatagramSocket datSoc = new DatagramSocket();
        pac = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        datSoc.send(pac);
    }
}

public class Sendr {
    public static void main(String[] args) throws Exception {
        Scanner inp = new Scanner(System.in);
        int i = 1;

        Options obj1 = new Options();
        boolean cont = obj1.initialOptions();
        String targetIP = obj1.getIP();
        int port = obj1.getPort();
        if (cont) {
            System.out.println("-----------------------------------");
            System.out.println("Chatting with : " + targetIP + "\n");
            System.out.println("Enter \"~\" to Exit Chat\n");

            FileWriter hist = new FileWriter(new File("history/", targetIP));

            while (i != 0) {
                SendMessage senMsg = new SendMessage(targetIP, port);
                System.out.print("Enter Message : ");
                String msg = inp.nextLine();

                try {
                    Date d = new Date();
                    hist.write(d + " : " + msg + "\n");
                } catch (IOException e) {
                    System.out.println("Unable to Create a file");
                }

                if (msg.equals("~")) {
                    msg = "User was exited";
                    System.out.println("Exiiting");
                    senMsg.sendMsg(msg);
                    i = 0;
                    break;
                }
                senMsg.sendMsg(msg);
            }
            hist.close();
        }
        System.out.println("Come Back Later :)");
    }
}
