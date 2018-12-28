package servidor;

public class Order {
	
	private int orderID;
	private Producto producto;
	private Usuario usuario;
	
	public Order(int orderID, Producto producto, Usuario usuario) {
		this.orderID  = orderID;
		this.producto = producto;
		this.usuario  = usuario;
	}
	
	public int getorderID() {
		return orderID;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
