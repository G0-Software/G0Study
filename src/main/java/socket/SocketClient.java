package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by hanoseok on 15. 4. 1..
 */

public class SocketClient {
    public static void main(String args[]) throws Exception {
        Socket sock = new Socket("localhost", 17889);
        OutputStreamWriter os = new OutputStreamWriter(sock.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String aLine = in.readLine();
            if(aLine.equalsIgnoreCase("end")) {
                break;
            }
            os.write(aLine + "\n");
        }
        os.close();
    }
}