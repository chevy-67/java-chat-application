import java.net.*;
import java.util.Scanner;

class Options {
    public String targetIP = "192.168.210.206";
    public int port = 2929;
    Scanner inp = new Scanner(System.in);
    int i = 1;

    void initialOptions() {
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
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    int getPort() {
        return port;
    }

    String getIP() {
        return targetIP;
    }
}

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
        obj1.initialOptions();
        String targetIP = obj1.getIP();
        int port = obj1.getPort();

        System.out.println("-----------------------------------");
        System.out.println("Chatting with : " + targetIP + "\n");
        System.out.println("Enter \"~\" to Exit Chat\n");

        while (i != 0) {
            SendMessage senMsg = new SendMessage(targetIP, port);
            System.out.print("Enter Message : ");
            String msg = inp.nextLine();
            if (msg.equals("~")) {
                msg = "User was exited";
                System.out.println("Exiiting");
                senMsg.sendMsg(msg);
                i = 0;
                break;
            }
            senMsg.sendMsg(msg);
        }
    }
}
