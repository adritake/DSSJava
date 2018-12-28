package test;

import java.util.ArrayList;

import facade.FarmaciaFacade;
import facade.OrderFacade;
import servidor.Farmacia;
import servidor.Order;
import servidor.Producto;
import servidor.Usuario;

public class MainTest {
	
	public static void main(String[] args) {
		
		FarmaciaFacade farmafac = new FarmaciaFacade();
		Farmacia farma = new Farmacia(5,"Farmacia test", 1, 2);
		
		farmafac.newFarmacia(farma);
		
		ArrayList<Farmacia> farmacias = farmafac.getFarmacias();
		
		for(Farmacia f: farmacias)
			System.out.println("Farmacia -> " + f.getID()+ " " +   f.getNombre());
		
		farmafac.deleteFarmacia(farma);
		
		farmacias = farmafac.getFarmacias();
		System.out.println("After delete ---------");
		for(Farmacia f: farmacias)
			System.out.println("Farmacia -> " + f.getID()+ " " +   f.getNombre());
		
		
		Farmacia farmaupdated = new Farmacia(8, "Updated name", 3,4);
		farmafac.updateFarmacia(farmaupdated);
		
		farmacias = farmafac.getFarmacias();
		System.out.println("After update ---------");
		for(Farmacia f: farmacias)
			System.out.println("Farmacia -> " + f.getID()+ " " +   f.getNombre());
		
		farmafac.close();
		
		
		OrderFacade orfac = new OrderFacade();
		
		
		Order order = new Order(1,new Producto(123,"Paracetamol"), new Usuario("Pepe","PepeUser","correo", "contrasena"));
		
		orfac.newOrder(order);
		
		Order orderUpdated = new Order(2,new Producto(111,"Paracetamol"), new Usuario("Pepe","PepeUpdated","correo", "contrasena"));
		orfac.updateOrder(orderUpdated);
		
		Order orderDelete = new Order(3,new Producto(123,"Paracetamol"), new Usuario("Pepe","PepeUser","correo", "contrasena"));

		orfac.deleteOrder(orderDelete);
		
		ArrayList<Order> orders = orfac.getOrders();
		
		System.out.println("All orders ---------");
		for(Order o: orders)
			System.out.println("Order -> " + o.getOrderID() + " " + o.getProducto().getProductoID() + " " +o.getUsuario().getNombreUsuario());
		
		orfac.close();
	}
	
}
