package servidor;


public class Farmacia {

	private String nombre;
	private float latitud;
	private float longitud;
	private int ID;
	
	
	public Farmacia(int ID, String nombre, float latitud, float longitud) {
		this.ID       = ID;
		this.nombre   = nombre;
		this.latitud  = latitud;
		this.longitud = longitud;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public float getLatitud() {
		return latitud;
	}
	
	public float getLongitud() {
		return longitud;
	}
	
	public int getID() {
		return ID;
	}

}
