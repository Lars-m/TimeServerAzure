package timetcp;
// SimpleServer.java: A simple server program.
import java.net.*;
import java.io.*;
import java.util.Date;

public class TimeTcp {
  private static int port = 7777;
  private static String ip = "localhost";

  public static void main(String args[]) throws IOException {

    if(args.length==2){
      ip = args[0];
      port = Integer.parseInt(args[1]);
    }
    ServerSocket serverSocket = new ServerSocket();
    serverSocket.bind(new InetSocketAddress(ip, port));
    System.out.println("Server started listening on port: "+port);
    System.out.println("Bound to : "+ip);
    while (true) {
      Socket s1 = serverSocket.accept(); // Wait and accept a connection
      System.out.println("Client Connected");
      try(PrintWriter pw = new PrintWriter(s1.getOutputStream())){
        pw.println(new Date().toString());
      }
    }
  }
}
