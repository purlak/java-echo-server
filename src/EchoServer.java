import java.net.*;
import java.io.*;

public class EchoServer {
	ServerSocket serverSocket;
	ClientSocket clientSocket;

	public EchoServer(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void start() throws IOException {
		serverAcceptsConnection();
		echoMessage();
	}

	private void serverAcceptsConnection() throws IOException {
		clientSocket = new ClientSocket(serverSocket.accept());
	}

	private void echoMessage() throws IOException {
		String input = clientSocket.getInput();
		if (input != null) {
			clientSocket.sendOutput(input);
			echoMessage();
		}
	}
}
