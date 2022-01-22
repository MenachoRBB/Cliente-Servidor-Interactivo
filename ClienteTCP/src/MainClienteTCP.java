
public class MainClienteTCP {
	public static void main(String[] args) {
		//Creamos el objeto del cliente con los parametros de IP y puerto y ejecutamos
		ClienteTCP objetoCliente = new ClienteTCP("127.0.0.1", 4444);
		objetoCliente.run();
	}
}
