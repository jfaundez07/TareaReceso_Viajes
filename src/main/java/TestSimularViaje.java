import java.util.Scanner;

public class TestSimularViaje {

	public static void main(String[] args){
		TestSimularViaje viaje = new TestSimularViaje();
		viaje.SimularViaje();

	}

	public void SimularViaje() {

		double distancia = 0;

		Scanner leer = new Scanner(System.in);

		do {

			try{
				System.out.print("Ingrese la distancia en kilometros, a la cual se encuentra su destino: ");
				String input = leer.next();
				distancia = Double.parseDouble(input);
			} catch (NumberFormatException e) { System.out.println("Error: Valor invalido."); }

		}while (!isMayorCero(distancia) );

		Vehículo vehículo1 = crearVehículo();
		Persona persona1 = crearPersona();

		imprimirMensaje(persona1, distancia,vehículo1);

	}

	public Vehículo crearVehículo(){

		Scanner leer = new Scanner(System.in);

		String tipo = "";
		int velocidad = 0;

		do {

			System.out.print("\nSeleccione su vehiculo:\n[1] Auto. Veclocidad: 50 [km/h]\n[2] Motocicleta. Velocidad [40km/h]\n[3] Bicicleta. Velocidad: 20 [km/h]\nSeleccion: ");
			String seleccion = leer.next();

			switch (seleccion) {
				case "1" -> { tipo = "Auto"; velocidad = 50 ; }
				case "2" -> { tipo = "Motocicleta"; velocidad = 40; }
				case "3"-> { tipo = "Bicicleta"; velocidad = 20; }
				default -> System.out.println("Valor invalido.Intente nuevamente\n");
			}

		} while (!isMayorCero(velocidad));

		return new Vehículo(tipo, velocidad);

	}

	public Persona crearPersona(){

		Scanner leer = new Scanner(System.in);

		System.out.print("\nIngrese su nombre: ");
		String nombre = leer.next();

		return new Persona(nombre);

	}

	public boolean isMayorCero(double num1) {
		return num1 > 0;
	}

	public void imprimirMensaje(Persona valorPersona, double valorDistancia, Vehículo valorVehiculo){

		String nombre = valorPersona.getNombre();
		String tipoVehiculo = valorVehiculo.getTipo();
		double velocidadVehiculo = valorVehiculo.getVelocidad();
		double tiempoLlegada = valorVehiculo.tiempoLlegada(valorDistancia);

		System.out.println("\nHola " + nombre + "!, el tiempo de viaje aproximado para llegar a " + valorDistancia +
				" [km] de distancia en " + tipoVehiculo + " a " + velocidadVehiculo + " [km/h] es de: " + tiempoLlegada + " horas.");
	}

}