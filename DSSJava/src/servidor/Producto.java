package servidor;

public class Producto {

	private int productoID;
	private String nombre;
	
	public Producto( int productoID, String nombre) {
		this.productoID = productoID;
		this.nombre = nombre;
	}
	
	public int getProductoID() {
		return productoID;
	}
	
	public String getNombre() {
		return nombre;
	}
}
