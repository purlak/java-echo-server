import java.io.IOException;
import java.net.ServerSocket;

public class StartServer {
	public static void main(String[] args) throws IOException {
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			EchoServer echoServer = new EchoServer(serverSocket);
			echoServer.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
