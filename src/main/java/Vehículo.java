public class Vehículo {

	private String tipo;

	private double velocidad;

	public Vehículo(String tipo, int velocidad) {
		this.tipo = tipo;
		this.velocidad = velocidad;
	}

	public double tiempoLlegada(double distancia) {
		return distancia / this.velocidad;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}