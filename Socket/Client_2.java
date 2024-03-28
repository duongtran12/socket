package Socket;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client_2 extends JFrame {
	private JLabel clockLabel;

	public Client_2() {
		setTitle("Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setLayout(new FlowLayout());

		clockLabel = new JLabel();
		add(clockLabel);

		setVisible(true);

		try {
			Socket socket = new Socket("localhost", 3333);
			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

			dout.writeUTF("time");
			dout.flush();

			String serverTime = din.readUTF();
			clockLabel.setText(serverTime);

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Client_2::new);
	}
}
