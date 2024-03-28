package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server_2 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(3333);
		System.out.println("Server started!");

		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("New client connected: " + socket);

			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

			String clientRequest = din.readUTF();
			if (clientRequest.equals("time")) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				String currentTime = dateFormat.format(new Date());
				dout.writeUTF(currentTime);
				dout.flush();
			}

			socket.close();
		}
	}
}
