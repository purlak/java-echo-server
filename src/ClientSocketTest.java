import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

public class ClientSocketTest {
	private Socket mockSocket;
	private ByteArrayOutputStream output;
	private final String input = "fakeInput";

	@Before
	public void setup() throws IOException {
		output = new ByteArrayOutputStream();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		mockSocket = new MockSocket(inputStream, output);
	}

	@Test
	public void getInput() throws IOException {
		ClientSocket clientSocket = new ClientSocket(mockSocket);
		String output = clientSocket.getInput();

		assertEquals(input, output);
	}

	@Test
	public void sendOutput() throws IOException {
		ClientSocket clientSocket = new ClientSocket(mockSocket);
		clientSocket.sendOutput(input);

		assertEquals(input, output.toString().trim());
	}
}