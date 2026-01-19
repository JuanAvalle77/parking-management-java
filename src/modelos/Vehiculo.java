package modelos;

public class Vehiculo {
	
	private int idVehiculo;
	private String dominio;
	private String tipoVehiculo;
	private long dniConductor;
	
	public Vehiculo(int idVehiculo, String dominio, String tipoVehiculo, long dniConductor) throws Exception {
		super();
		this.idVehiculo = idVehiculo;
		this.setDominio(dominio);       
		this.setTipoVehiculo(tipoVehiculo); 
		this.dniConductor = dniConductor;
	}
	
	@Override
	public String toString() {
	    return "Vehiculo:\n" +
	           "  idVehiculo = " + idVehiculo + "\n" +
	           "  dominio = " + dominio + "\n" +
	           "  tipoVehiculo = " + tipoVehiculo + "\n" +
	           "  dniConductor = " + dniConductor + "\n";
	}


	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) throws Exception {
		if(dominio == null || dominio.isEmpty()) {
			throw new Exception("Error: el dominio no puede estar vacío");
		}
		this.dominio = dominio;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) throws Exception {
		if(tipoVehiculo == null || tipoVehiculo.isEmpty()) {
			throw new Exception("Error: el tipo de vehículo no puede estar vacío");
		}
		this.tipoVehiculo = tipoVehiculo;
	}

	public long getDniConductor() {
		return dniConductor;
	}

	public void setDniConductor(long dniConductor) {
		this.dniConductor = dniConductor;
	}
	
	
	
	

}
