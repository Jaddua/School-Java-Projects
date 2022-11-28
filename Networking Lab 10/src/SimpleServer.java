//ServerArea.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleServer {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
			int port=1254;
			ServerSocket s = new ServerSocket(port);
			for(int i = 0; i < 5; i++) {
			Socket sCli = s.accept();

			DataOutputStream outputToClient = new DataOutputStream(sCli.getOutputStream());
			String help = "";
			while(!help.contains("finish")) {
				help = input.nextLine();
				outputToClient.writeUTF(String.format("%s%n", help));
			}
			

			outputToClient.close();
			sCli.close();	
			}
	}
}
