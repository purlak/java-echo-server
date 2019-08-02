import java.io.*;
import java.net.Socket;

public class ClientSocket {
	private BufferedReader in;
	private PrintWriter out;

	public ClientSocket(Socket clientSocket) throws IOException {
		inputStream(clientSocket.getInputStream());
		outputStream(clientSocket.getOutputStream());
	}

	private void inputStream(InputStream in) {
		this.in = new BufferedReader(new InputStreamReader(in));
	}

	private void outputStream(OutputStream out) {
		this.out = new PrintWriter(out, true);
	}

	public String getInput() throws IOException {
		return in.readLine();
	}

	public void sendOutput(String input) {
		out.println(input);
	}
}
