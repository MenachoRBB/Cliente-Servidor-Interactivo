
public class MainServerTCPInteractivo {

	public static void main(String[] args) {
		//Creamos el objeto del servidor pasandole por parámetro el puerto donde escuchará
		//las peticiones de los clientes
		SimpleServerTCPInteractivo objetoServer = new SimpleServerTCPInteractivo(4444);
		objetoServer.run();

	}

}
