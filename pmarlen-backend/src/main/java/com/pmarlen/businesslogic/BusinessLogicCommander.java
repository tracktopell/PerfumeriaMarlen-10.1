/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmarlen.businesslogic;

import com.pmarlen.model.beans.Producto;
import com.pmarlen.model.controller.ProductoJPAController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alfredo
 */
public class BusinessLogicCommander {

	private static int printMenuPrincipal() {
		int op = -1;
		clearTerminal();
		System.out.println("=======================PMArlen BusinessLogicCommander ==========================");
		System.out.println("\t1) ADMINISTRACIÓN");
		System.out.println("\t2) CATALOGOS");
		System.out.println("\t3) OPERACIÓN");		
		System.out.println("\t0) SALIR");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.print("\tOPCION:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
			op = Integer.parseInt(line);
		} catch (IOException ioe) {
			op = -1;
		}
		return op;
	}
	
	private static void clearTerminal(){
		try{
			Runtime.getRuntime().exec("/usr/bin/clear");
		}catch(Exception e){
		}
	}

	private static int printMenuOperacion() {
		int op = -1;
		clearTerminal();
		System.out.println("=======================PMArlen BusinessLogicCommander ==========================");
		System.out.println("================================= OPERACIÓN ====================================");
		System.out.println("\t1) LISTAR PEDIDOS VENTAS");
		System.out.println("\t2) ABRIR PEDIDO");		
		System.out.println("\t0) SALIR");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.print("\tOPCION:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
			op = Integer.parseInt(line);
		} catch (IOException ioe) {
			op = -1;
		}
		
		return op;
	}

	private static int printMenuPedidoVenta() {
		int op = -1;
		clearTerminal();
		System.out.println("=======================PMArlen BusinessLogicCommander ==========================");
		System.out.println("================================= OPERACIÓN ====================================");
		System.out.println("============================ EDITAR PEDIDO VENTA ===============================");
		System.out.println("\t1) LISTAR PEDIDO VENTA");
		System.out.println("\t2) AGREGAR PRODUCTO");		
		System.out.println("\t0) SALIR");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.print("\tOPCION:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
			op = Integer.parseInt(line);
		} catch (IOException ioe) {
			op = -1;
		}
		
		return op;
	}

	
	private static int printMenuCatalogos() {
		int op = -1;
		clearTerminal();
		System.out.println("=======================PMArlen BusinessLogicCommander ==========================");
		System.out.println("================================= CATALOGOS ====================================");
		System.out.println("\t1) PRODUCTOS");
		System.out.println("\t0) SALIR");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.print("\tOPCION:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
			op = Integer.parseInt(line);
		} catch (IOException ioe) {
			op = -1;
		}
		
		return op;
	}

	private static int printMenuProductos() {
		int op = -1;
		System.out.println("=======================PMArlen BusinessLogicCommander ==========================");
		System.out.println("================================= CATALOGOS ====================================");
		System.out.println("================================= PRODUCTOS ====================================");
		System.out.println("\t1) LISTAR");
		System.out.println("\t0) SALIR");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.print("\tOPCION:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
			op = Integer.parseInt(line);
		} catch (IOException ioe) {
			op = -1;
		}
		return op;
	}

	private static void printCatalogoProductos(ApplicationContext context) {
		ProductoJPAController productoJPAController = context.getBean("productoJPAController", ProductoJPAController.class);
		final List<Producto> productoList = productoJPAController.findAllEntities();

		for (Producto producto : productoList) {
			System.out.println("->Producto:" + producto.getCodigoBarras() + "|" + producto.getNombre() + "|" + producto.getPresentacion() + "|" + producto.getId());
		}
	}
	
	private static void printPedidosVentas(ApplicationContext context) {
//		PedidoVentaBusinessLogic pedidoVentaBusinessLogic = context.getBean("pedidoVentaBusinessLogic", PedidoVentaBusinessLogic.class);
		
//		final List<PedidoVenta> pedidoVentaList = pedidoVentaBusinessLogic.findPedidoVentaEntities();
//		for(PedidoVenta pv: pedidoVentaList){
//			System.out.println("->PedidoVenta:"+pv.getId());
//		}
		
//		final List<PedidoFastView> pedidosVentasFVList = pedidoVentaBusinessLogic.findPedidoFastViewLimitTo(Integer.MAX_VALUE);
		
//		for(PedidoFastView pvfv: pedidosVentasFVList){
//			System.out.println("->PedidoVentaFV:"+pvfv.getPedidoId()+"|"+pvfv.getEstadoActualDescripcion());
//		}
	}

	private static void printPedidoVenta(ApplicationContext context) {
//		System.out.print("\tABRIR PEDIDO VENTA:");
//		int pedidoVentaId=0;
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String line = null;
//		try {
//			line = br.readLine();
//			pedidoVentaId = Integer.parseInt(line);
//		} catch (IOException ioe) {
//			pedidoVentaId=0;
//		}
//		
//		PedidoVentaBusinessLogic pedidoVentaBusinessLogic = context.getBean("pedidoVentaBusinessLogic", PedidoVentaBusinessLogic.class);
//		final PedidoVenta pedidoVenta = pedidoVentaBusinessLogic.findPedidoVenta(pedidoVentaId);
//		final Collection<PedidoVentaDetalle> pvdList = pedidoVenta.getPedidoVentaDetalleCollection();
//		
//		for(PedidoVentaDetalle pvd: pvdList){
//			System.out.println("->PVD:"+pvd.getProducto().getCodigoBarras()+"|"+pvd.getPrecioVenta()+"|"+pvd.getAlmacen().getId()+"|"+pvd.getCantidad());
//		}
	}
	

	public static void main(String[] args) {
		System.out.println("=======================PMArlen BusinessLogicCommander ==========================");
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");

			int op = -1;
			while (op != 0) {
				op = printMenuPrincipal();
				if (op == 1) {
				} else if (op == 2) {
					int opC = -1;
					while (opC != 0) {
						opC = printMenuCatalogos();
						if (opC == 1) {
							int opCP = -1;
							while (opCP != 0) {
								opCP = printMenuProductos();
								if (opCP == 1) {
									printCatalogoProductos(context);
								}
							}
						}
					}
				}else if (op == 3) {
					int opO = -1;
					while (opO != 0) {
						opO = printMenuOperacion();
						if(opO == 1){
							printPedidosVentas(context);
						} else if(opO == 2){
							printPedidoVenta(context);
							int opPV = -1;
							while (opPV != 0) {
								opPV = printMenuPedidoVenta();
								if(opPV == 1){
									printPedidoVenta(context);
								} else if(opPV == 2){
									
								}
							}
						} 
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
