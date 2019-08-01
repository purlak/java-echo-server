import java.net.*;
import java.io.*;

public class EchoServer {
	ServerSocket serverSocket;
	Socket clientSocket;

	public EchoServer(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void start() throws IOException {
		serverAcceptsConnection();
		echoMessage();
	}

	private void serverAcceptsConnection() throws IOException {
		clientSocket = serverSocket.accept();
	}

	private void echoMessage() throws IOException {
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String input = in.readLine();
		if (input != null) {
			out.println(input);
			echoMessage();
		}
	}
}
