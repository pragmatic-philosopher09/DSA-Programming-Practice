import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            int port = 8088;

            // Server Key
            int b = 3;

            // Client's p, g and key

            double cP, cG, cA, B, Bdash;
            String Bstr;

            // Establishing connection betwixt client+server:

            try (ServerSocket ss = new ServerSocket(port)) {
                System.out.println("WAITING FOR CLIENT ON PORT ==> " + ss.getLocalPort() + "...");
                Socket server = ss.accept();

                // Server's Private Key

                System.out.println("SERVER --> PRIVATE KEY = " + b);

                // Accepting Data From Client

                DataInputStream in = new DataInputStream(server.getInputStream());

                cP = Integer.parseInt(in.readUTF());
                System.out.println("CLIENT --> P = " + cP);

                cG = Integer.parseInt(in.readUTF());
                System.out.println("CLIENT --> G = " + cG);

                cA = Double.parseDouble(in.readUTF());
                System.out.println("CLIENT --> PUBLIC KEY = " + cA);

                B = ((Math.pow(cG, b)) % cP);
                Bstr = Double.toString(B);

                // Send Data To Client
                OutputStream os = server.getOutputStream();
                DataOutputStream out = new DataOutputStream(os);

                out.writeUTF(Bstr);

                Bdash = ((Math.pow(cA, b)) % cP);

                System.out.println("SECRET KEY TO PERFORM SYMMETRIC ENCRYPTION = " + Bdash);
                server.close();
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        catch (SocketTimeoutException s) {
            System.out.println("OOPS! LOOKS LIKE SOCKET HAS TIMED OUT!");
        }

        catch (IOException e) {
            System.out.println("WRONG INPUT!");
        }
    }

}
