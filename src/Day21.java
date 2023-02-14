import java.net.InetAddress;
import java.net.UnknownHostException;

public class Day21 {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("www.inha.ac.kr");
            System.out.println(addr);
        } catch (UnknownHostException e) {
            System.out.println("해당 URL은 존재하지 않습니다. ");
        }
    }
}
