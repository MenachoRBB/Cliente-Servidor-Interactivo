import java.net.*;
import java.io.*;

public class ClienteTCP {

	private String IP = "";
	private int puerto = 0;

	public ClienteTCP(String IP, int puerto) {
		this.IP = IP;
		this.puerto = puerto;
	}

	public void run() {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;

		//Creación del SocketTCP y los objetos con los que nos comunicaremos con el servidor
		try {
			socket = new Socket(IP, puerto);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(UnknownHostException e) {
			System.err.println("Don't know about host: "+IP);
			System.exit(1);
		}catch(IOException e) {
			System.err.println("Couldn't get I/O for the connection to: "+IP);
			System.exit(1);
		}
		//Lee la entrada por teclado del usuario
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		String fromServer;
		String fromUser;
		//Comunicación entre cliente y servidor
		try {
			//Recibimos del server esperando bloqueados y es un bucle hasta que recibimos un Bye!
			while((fromServer = stdIn.readLine()) != null) {
				System.out.println("Server: "+fromServer);
				if(fromServer.equals("Bye!"))
					break;
				
				//Obtenemos por teclado el mensaje del cliente
				fromUser = stdIn.readLine();
				if(fromUser != null) {
					System.out.println("Client: "+fromUser);
					//Después de mostrar por pantalla, enviamos al servidor
					out.println(fromUser);
				}
			}
		}catch(IOException e) {
			System.err.println(e.getCause());
			System.exit(1);
		}
		
		//Cerramos la conexión cliente-servidor
		try {
			out.close();
			in.close();
			stdIn.close();
			socket.close();
		}catch(IOException e) {
			System.err.println("Close failed");
			System.exit(1);
		}
	}
}
