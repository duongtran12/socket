package Socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_1 {
	public Server_1() throws Exception {
		ServerSocket serverSocket = new ServerSocket(1234);
		System.out.println("Server is running on port 1234");

		Socket socket = serverSocket.accept();
		System.out.println("Client connected");

		BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(System.in));

		String clientMessage;
		String serverMessage;

		while (true) {

			clientMessage = fromClient.readLine();
			if (clientMessage != null) {
				System.out.println("Received: " + clientMessage);
			}

			System.out.println("Server: ");
			serverMessage = fromServer.readLine();
			toClient.writeBytes(serverMessage + "\n");
		}
	}

	public static void main(String[] args) throws Exception {
		new Server_1();
	}
}
