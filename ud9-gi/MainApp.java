
public class MainApp {
	public static void main(String[] args) {
		// Inicializar
			DAOCoche miGaraje = new DAOCoche();
		// Añadir
			miGaraje.addCoche(new Coche("3307-MZX","Ferrari 555","Rojo",1986));
			miGaraje.addCoche(new Coche("8091-ABS","Asthon Martin GT","Negro",1992));
			miGaraje.addCoche(new Coche("2212-CDT","Coupe Fiat","Amarillo",1988));
		// Actualizar
			miGaraje.updateCoche(miGaraje.findCoche("8091-ABS"), new Coche("8091-ABS","Asthon Martin GT","Gris",1993));
		// Eliminar
			miGaraje.deleteCoche(miGaraje.findCoche("3307-MZX"));
		// Añade más
			miGaraje.addCoche(new Coche("6604-UMC","Ford Mustang","Azul",1984));
			miGaraje.addCoche(new Coche("4032-RTP","Ford Capri","Verde",1965));
		// Listar 
			System.out.println("Lista de coches en garaje");
			System.out.println("-------------------------");
			for (Coche c: miGaraje.getCoches()) {		
				System.out.println(c);
			}
	} //main	
} // AppMAin
