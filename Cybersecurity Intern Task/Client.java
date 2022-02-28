import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            String pstr, gstr, Astr;
            String serverName = "localhost";
            int port = 8088;

            // Declare p, g and key of client

            int p = 23;
            int g = 9;
            int a = 4;

            double Adash, sB;

            // Establishing connection

            System.out.println("CONNECTING TO ==> " + serverName + " ON PORT " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("JUST CONNECTED TO " + client.getRemoteSocketAddress());

            // Sending Data To Client

            OutputStream ot = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(ot);

            pstr = Integer.toString(p);
            out.writeUTF(pstr);

            gstr = Integer.toString(g);
            out.writeUTF(gstr);

            double A = ((Math.pow(g, a)) % p);
            Astr = Double.toString(A);
            out.writeUTF(Astr);

            // Client's Private Key
            System.out.println("CLIENT --> PRIVATE KEY = " + a);

            // Accepting Data
            DataInputStream in = new DataInputStream(client.getInputStream());

            sB = Double.parseDouble(in.readUTF());
            System.out.println("SERVER --> PUBLIC KEY = " + sB);

            Adash = ((Math.pow(sB, a)) % p);

            System.out.println("SECRET KEY TO PERFORM SYMMETRIC ENCRYPTION = " + Adash);

            client.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
