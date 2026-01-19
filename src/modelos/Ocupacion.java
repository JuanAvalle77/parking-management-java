package modelos;

import java.time.LocalDate;

public class Ocupacion {
	
	private int idOcupacion;
	private Lugar lugar;
	private Vehiculo vehiculo;
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	
	public Ocupacion(int idOcupacion, Lugar lugar, Vehiculo vehiculo, LocalDate fechaIngreso, LocalDate fechaSalida) throws Exception {
		super();
		this.idOcupacion = idOcupacion;
		this.lugar = lugar;
		this.vehiculo = vehiculo;
		this.setFechaIngreso(fechaIngreso); 
		this.fechaSalida = fechaSalida;
	}

	@Override
	public String toString() {
	    return "Ocupacion:\n" +
	           "  idOcupacion = " + idOcupacion + "\n" +
	           "  Lugar = [piso " + lugar.getPiso() + ", nro " + lugar.getNumero() + "]\n" +
	           "  Vehiculo = [dominio " + vehiculo.getDominio() + ", tipo " + vehiculo.getTipoVehiculo() + "]\n" +
	           "  fechaIngreso = " + fechaIngreso + "\n" +
	           "  fechaSalida = " + (fechaSalida != null ? fechaSalida : "AÚN ESTACIONADO") + "\n";
	}


	public int getIdOcupacion() {
		return idOcupacion;
	}

	public void setIdOcupacion(int idOcupacion) {
		this.idOcupacion = idOcupacion;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) throws Exception {
		if(fechaIngreso == null) {
			throw new Exception("Error: la fecha de ingreso no puede ser nula");
		}
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	
	

}
