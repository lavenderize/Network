import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

public class Day22 {
    public static void main(String args[]) {
        System.out.println("Multicast Time Server");
        DatagramSocket serverSocket = null;     // UDP
        try {
            serverSocket = new DatagramSocket();
            while (true) {
                String dateText = new Date().toString();
                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();
                InetAddress group =
                        InetAddress.getByName("224.0.0.117");
                DatagramPacket packet;
                packet = new DatagramPacket(buffer, buffer.length, group, 10000);
                serverSocket.send(packet);
                System.out.println("Time sent: " + dateText);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    // Handle exception
                }
            }
        } catch (SocketException ex) {
            // Handle exception
        } catch (IOException ex) {
            // Handle exception
        }
    }
}
