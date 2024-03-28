package Socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client_1 {
	public Client_1() throws Exception {
		Socket socket = new Socket("localhost", 1234);
		Scanner sc = new Scanner(System.in);

		DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));

		String serverMessage;
		String clientMessage;

		while (true) {
			System.out.print("Client: ");
			clientMessage = fromUser.readLine();
			toServer.writeBytes(clientMessage + "\n");

			serverMessage = fromServer.readLine();
			if (serverMessage != null) {
				System.out.println("Server: " + serverMessage);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Client_1();
	}
}
