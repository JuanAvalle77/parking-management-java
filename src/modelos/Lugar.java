package modelos;

public class Lugar {
	
	private int idLugar;
	private int piso;
	private int numero;
	
	public Lugar(int idLugar, int piso, int numero) throws Exception {
		super();
		this.idLugar = idLugar;
		this.setPiso(piso);     
		this.setNumero(numero); 
	}
	
	@Override
	public String toString() {
	    return "Lugar:\n" +
	           "  idLugar = " + idLugar + "\n" +
	           "  piso = " + piso + "\n" +
	           "  numero = " + numero + "\n";
	}

	
	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) throws Exception {
		if(piso < 0) {
			throw new Exception("Error: el piso no puede ser negativo");
		}
		this.piso = piso;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) throws Exception {
		if(numero <= 0) {
			throw new Exception("Error: el número de lugar debe ser mayor a 0");
		}
		this.numero = numero;
	}
	
	
	
	

}
