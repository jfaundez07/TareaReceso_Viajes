import java.util.Scanner;

public class TestSimularViaje {

	private Vehículo vehículo1;
	private Persona persona1;

	public void SimularViaje() {

		String destino = "";
		double distancia = 0;

		do {

			try{
				System.out.print("Ingrese el nombre de su destino: ");
				destino = leerString();
				System.out.print("Ingrese la distancia en kilometros, a la cual se encuentra su destino: ");
				String input = leerString();
				distancia = Double.parseDouble(input);
			} catch (NumberFormatException e) { System.out.println("Error: Valor invalido."); }

		}while (!isMayorCero(distancia) );

		vehículo1 = crearVehículo();
		persona1 = crearPersona();

		imprimirMensaje(persona1, distancia,vehículo1, destino);

	}

	private Vehículo crearVehículo(){

		String tipo = "";
		int velocidad = 0;

		do {

			System.out.print("\nSeleccione su vehiculo:\n[1] Auto. Veclocidad: 50 [km/h]\n[2] Motocicleta. Velocidad [40km/h]\n[3] Bicicleta. Velocidad: 20 [km/h]\nSeleccion: ");
			String seleccion = leerString();

			switch (seleccion) {
				case "1" -> { tipo = "Auto"; velocidad = 50 ; }
				case "2" -> { tipo = "Motocicleta"; velocidad = 40; }
				case "3"-> { tipo = "Bicicleta"; velocidad = 20; }
				default -> System.out.println("Valor invalido.Intente nuevamente\n");
			}

		} while (!isMayorCero(velocidad));

		return new Vehículo(tipo, velocidad);

	}

	private Persona crearPersona(){

		System.out.print("\nIngrese su nombre: ");
		String nombre = leerString();

		return new Persona(nombre);

	}

	private boolean isMayorCero(double num1) {
		return num1 > 0;
	}

	private void imprimirMensaje(Persona valorPersona, double valorDistancia, Vehículo valorVehiculo, String destino){

		String nombre = valorPersona.getNombre();
		String tipoVehiculo = valorVehiculo.getTipo();
		double velocidadVehiculo = valorVehiculo.getVelocidad();
		double tiempoLlegada = valorVehiculo.tiempoLlegada(valorDistancia);

		System.out.println("\nHola " + nombre + "!, el tiempo de viaje aproximado para llegar a: " + destino +
				"que se encuentra a " + valorDistancia + " [km] de distancia en " + tipoVehiculo + " a " + velocidadVehiculo +
				" [km/h] es de: " + tiempoLlegada + " horas.");
	}

	private String leerString() {
		Scanner leer = new Scanner(System.in);
		return leer.next();
	}



}