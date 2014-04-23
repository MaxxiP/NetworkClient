// File Name GreetingClient.java

import java.net.*;
import java.io.*;

public class GreetingClient
{
   public static void main(String [] args)
   {
      String serverName = "localhost";
      int port = 6066;//Integer.parseInt(args[1]);
      try
      {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);								//Creating new Socket with servername and port
         
         //System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();						//Create Outputstream on client output
         DataOutputStream out =     new DataOutputStream(outToServer);

         out.writeUTF(args[0] /*+ client.getLocalSocketAddress()*/);
         
         InputStream inFromServer = client.getInputStream();
         
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println("Server says " + in.readUTF());
         
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}