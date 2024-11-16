import java.net.*;

public class Receve {
    public static void main(String[] args) throws Exception {
        int port = 2929;
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
