//ClientArea.java

import java.io.*;
import java.net.*;


public class SimpleClient {
	
	
	public static void main(String[] args) throws IOException{

		String ip="127.0.0.1";
		int port=1254;
		Socket s = new Socket(ip, port);
		for(int i = 0; i < 5; i++) {
		DataInputStream inputFromClient = new DataInputStream(s.getInputStream());
	
		String help = "";
		while(!help.contains("finish")) {
			help = inputFromClient.readUTF();
			System.out.println(help);
		}
		
		
		inputFromClient.close();
		s.close();
		
		}
	}
}
