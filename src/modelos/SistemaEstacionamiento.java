package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaEstacionamiento {
	
	private List<Vehiculo> lstVehiculos;
	private List<Lugar> lstLugares;
	private List<Ocupacion> lstOcupacion;
	
	public SistemaEstacionamiento() {
		super();
		this.lstVehiculos = new ArrayList<Vehiculo>();
		this.lstLugares = new ArrayList<Lugar>();
		this.lstOcupacion = new ArrayList<Ocupacion>();
	}
	
	public Vehiculo traerVehiculo(String dominio) {
	    Vehiculo vehiculoBuscado = null;
	    int i = 0;
	    boolean encontrado = false;

	    while (i < lstVehiculos.size() && !encontrado) {
	        if (lstVehiculos.get(i).getDominio().equalsIgnoreCase(dominio)) {
	            vehiculoBuscado = lstVehiculos.get(i);
	            encontrado = true;
	        }
	        i++;
	    }
	    return vehiculoBuscado; 
	}
	
	public boolean agregarVehiculo(String dominio, String tipo, long dniConductor) throws Exception {

	    Vehiculo vehiculoExistente = traerVehiculo(dominio);
	    if (vehiculoExistente != null) {
	        throw new Exception("Error: El vehículo con dominio " + dominio + " ya existe");
	    }

	    
	    int id = 0;
	    if (!lstVehiculos.isEmpty()) {
	        Vehiculo ultimoVehiculo = lstVehiculos.get(lstVehiculos.size() - 1);
	        id = ultimoVehiculo.getIdVehiculo();
	    }

	    
	    Vehiculo nuevoVehiculo = new Vehiculo(id + 1, dominio, tipo, dniConductor);
	    return lstVehiculos.add(nuevoVehiculo);
	}
	
	public Lugar traerLugar(int piso, int numero) {
	    Lugar lugarBuscado = null;
	    int i = 0;
	    boolean encontrado = false;

	    while (i < lstLugares.size() && !encontrado) {
	        Lugar actual = lstLugares.get(i);
	        if (actual.getPiso() == piso && actual.getNumero() == numero) {
	            lugarBuscado = actual;
	            encontrado = true;
	        }
	        i++;
	    }
	    return lugarBuscado; 
	}

	
	public boolean agregarLugar(int piso, int numero) throws Exception {
	    
	    Lugar lugarExistente = traerLugar(piso, numero);
	    if (lugarExistente != null) {
	        throw new Exception("Error: El lugar en piso " + piso + " número " + numero + " ya existe");
	    }

	    
	    int id = 0;
	    if (!lstLugares.isEmpty()) {
	        Lugar ultimoLugar = lstLugares.get(lstLugares.size() - 1);
	        id = ultimoLugar.getIdLugar();
	    }

	   
	    Lugar nuevoLugar = new Lugar(id + 1, piso, numero);
	    return lstLugares.add(nuevoLugar);
	}
	
	public boolean estaLibre(LocalDate fecha, Lugar lugar) {
	    boolean libre = true;

	    for (Ocupacion ocup : lstOcupacion) {
	        if (ocup.getLugar().equals(lugar)) {
	            
	            if ((ocup.getFechaIngreso().isBefore(fecha) || ocup.getFechaIngreso().isEqual(fecha))
	                    && ocup.getFechaSalida() == null) {
	                libre = false;
	            }

	            
	            else if ((ocup.getFechaIngreso().isBefore(fecha) || ocup.getFechaIngreso().isEqual(fecha))
	                    && ocup.getFechaSalida() != null
	                    && (ocup.getFechaSalida().isAfter(fecha) || ocup.getFechaSalida().isEqual(fecha))) {
	                libre = false;
	            }
	        }
	    }

	    return libre;
	}
	
	public boolean agregarOcupacion(Lugar lugar, Vehiculo vehiculo, LocalDate fechaIngreso) throws Exception {
	    
	    if (!estaLibre(fechaIngreso, lugar)) {
	        throw new Exception("Error: El lugar no está libre para la fecha " + fechaIngreso);
	    }

	    
	    int id = 0;
	    if (!lstOcupacion.isEmpty()) {
	        Ocupacion ultima = lstOcupacion.get(lstOcupacion.size() - 1);
	        id = ultima.getIdOcupacion();
	    }

	    
	    Ocupacion nuevaOcupacion = new Ocupacion(id + 1, lugar, vehiculo, fechaIngreso, null);
	    return lstOcupacion.add(nuevaOcupacion);
	}
	
	public boolean marcarSalida(Vehiculo vehiculo, LocalDate fechaSalida) {
	    for (Ocupacion ocup : lstOcupacion) {
	        if (ocup.getVehiculo().equals(vehiculo) && ocup.getFechaSalida() == null) {
	            ocup.setFechaSalida(fechaSalida);
	            return true;
	        }
	    }
	    return false;
	}
	
	public List<Ocupacion> traerOcupacionesPorFechaIngreso(LocalDate fechaDesde, LocalDate fechaHasta) {
	    List<Ocupacion> resultado = new ArrayList<>();
	    for (Ocupacion ocup : lstOcupacion) {
	        if ((ocup.getFechaIngreso().isAfter(fechaDesde) || ocup.getFechaIngreso().isEqual(fechaDesde)) &&
	            (ocup.getFechaIngreso().isBefore(fechaHasta) || ocup.getFechaIngreso().isEqual(fechaHasta))) {
	            resultado.add(ocup);
	        }
	    }
	    return resultado;
	}
	
	public List<Vehiculo> traerVehiculosEstacionadosActuales() {
	    List<Vehiculo> resultado = new ArrayList<>();
	    for (Ocupacion ocup : lstOcupacion) {
	        if (ocup.getFechaSalida() == null) {
	            resultado.add(ocup.getVehiculo());
	        }
	    }
	    return resultado;
	}

	public List<Ocupacion> traerOcupacionesPorTipoVehiculo(String tipoVehiculo) {
	    List<Ocupacion> resultado = new ArrayList<>();
	    for (Ocupacion ocup : lstOcupacion) {
	        if (ocup.getVehiculo().getTipoVehiculo().equalsIgnoreCase(tipoVehiculo)) {
	            resultado.add(ocup);
	        }
	    }
	    return resultado;
	}
	
	



	
	@Override
	public String toString() {
		return "SistemaEstacionamiento [lstVehiculos=" + lstVehiculos + ", lstLugares=" + lstLugares + ", lstOcupacion="
				+ lstOcupacion + "]";
	}

	public List<Vehiculo> getLstVehiculos() {
		return lstVehiculos;
	}

	public void setLstVehiculos(List<Vehiculo> lstVehiculos) {
		this.lstVehiculos = lstVehiculos;
	}

	public List<Lugar> getLstLugares() {
		return lstLugares;
	}

	public void setLstLugares(List<Lugar> lstLugares) {
		this.lstLugares = lstLugares;
	}

	public List<Ocupacion> getLstOcupacion() {
		return lstOcupacion;
	}

	public void setLstOcupacion(List<Ocupacion> lstOcupacion) {
		this.lstOcupacion = lstOcupacion;
	}
	
	
}

