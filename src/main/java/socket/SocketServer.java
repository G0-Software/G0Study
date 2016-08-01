package socket;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hanoseok on 15. 4. 1..
 */

public class SocketServer {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(17889, 50);
        while(true) {
            System.out.println("Listening...");
            Socket sock = server.accept();
            Thread.sleep(100);
            Reader in = new InputStreamReader(sock.getInputStream());
            char[] buf = new char[1000];
            while(true) {
                int count = in.read(buf);
                if(count == -1) break;			// Client socket is closed, so the matching established server socket should also be closed
                System.out.println(new String(buf, 0, count));
            }

            //	Should close, otherwise FIN_WAIT(Client this case) and CLOSE_WAIT(Server this case) will be remained and never been cleared
			sock.close();
            // 디벨롭커밋1
        }
    }
}
