import java.util.Scanner;

public class TestSimularViaje {

	public static void main(String[] args){
		TestSimularViaje viaje = new TestSimularViaje();
		viaje.SimularViaje();

	}

	public void SimularViaje() {

		Vehículo vehículo1 = crearVehículo();
		Persona persona1 = crearPersona();
		double distancia = 0;

		Scanner leer = new Scanner(System.in);

		do {

			try{
				System.out.println("Ingrese la distancia en kilometros, a la cual se encuentra su destino ");
				String input = leer.next();
				distancia = Double.parseDouble(input);

			} catch (NumberFormatException e) {
				System.out.println("Error: Valor invalido.");
			}

		}while (!isMayorCero(distancia) );

		System.out.println("Hola " + persona1.getNombre() + "!, el tiempo de viaje aproximado para llegar a " + distancia+ "kilometros en " + vehículo1.getTipo() + " a " + vehículo1.getVelocidad() + " es de: " + vehículo1.tiempoLlegada(distancia));
	}

	public Vehículo crearVehículo(){

		Scanner leer = new Scanner(System.in);

		String tipo;
		int velocidad;

		System.out.println("Seleccione su vehiculo:\n[1] Auto\n[2] Motocicleta\n[3] Bicicleta\nSeleccion: ");
		int seleccion = leer.nextInt();

		switch (seleccion) {
			case 1 -> {
				tipo = "Auto";
				velocidad = 50 ;
			}
			case 2 -> {
				tipo = "Motocicleta";
				velocidad = 30;
			}
			case 3 -> {
				tipo = "Bcicleta";
				velocidad = 10;
			}
			default -> throw new IllegalStateException("Unexpected value: " + seleccion);
		}

		return new Vehículo(tipo, velocidad);

	}

	public Persona crearPersona(){

		Scanner leer = new Scanner(System.in);

		System.out.println("Ingrese el nombre de la persona: ");
		String nombre = leer.next();

		return new Persona(nombre);

	}

	public boolean isMayorCero(double num1) {
		return num1 > 0;
	}



}