/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools,Templates
 * and open the template in the editor.
 */
package com.pmarlen.migration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;

/**
 *
 * @author alfredo
 */
public class ImportData {

	private static Connection oldDBConnection = null;

	private static Connection newDBConnection = null;

	private static boolean debug = false;

	private static String usrOldDB = null;
	private static String pwdOldDB = null;
	private static String urlOldDB = null;

	private static String usrNewDB = null;
	private static String pwdNewDB = null;
	private static String urlNewDB = null;

	public static void main(String[] args) {
		System.out.println("---------------------- ImportData -----------------------");

		usrOldDB = args[0];
		pwdOldDB = args[1];
		urlOldDB = args[2];

		usrNewDB = args[3];
		pwdNewDB = args[4];
		urlNewDB = args[5];

		connectToOldDB();

		connectToNewDB();

		try {
			
			//executeQuery(newDBConnection, "SELECT * FROM PEDIDO_VENTA");
			
			List<Object[]> resultLineas = executeQuery(oldDBConnection, "SELECT ID,NOMBRE FROM LINEA");
			for(Object[] arrXM: resultLineas){
				arrXM[1]=((String)arrXM[1]).toUpperCase();
			}
			executeMultipleUpdates("INSERT INTO LINEA(ID,NOMBRE) VALUES(?,?)", resultLineas);
			resultLineas = null;

			List<Object[]> resultIndustrias = executeQuery(oldDBConnection, "SELECT ID,NOMBRE FROM INDUSTRIA");
			for(Object[] arrXM: resultIndustrias){
				arrXM[1]=((String)arrXM[1]).toUpperCase();
			}
			executeMultipleUpdates("INSERT INTO INDUSTRIA(ID,NOMBRE) VALUES(?,?)", resultIndustrias);
			resultIndustrias = null;

			List<Object[]> resultMarcas = executeQuery(oldDBConnection, "SELECT ID,LINEA_ID,INDUSTRIA_ID,NOMBRE FROM MARCA");
			for(Object[] arrXM: resultMarcas){
				arrXM[3]=((String)arrXM[3]).toUpperCase();
			}
			executeMultipleUpdates("INSERT INTO MARCA(ID,LINEA_ID,INDUSTRIA_ID,NOMBRE) VALUES(?,?,?,?)", resultMarcas);
			resultMarcas = null;

			List<Object[]> resultProducto = executeQuery(oldDBConnection, "SELECT ID,CODIGO_BARRAS,MARCA_ID,NOMBRE,PRESENTACION,UNIDADES_POR_CAJA,UNIDAD_MEDIDA,COSTO,COSTO_VENTA,CONTENIDO,ABREBIATURA FROM PRODUCTO");
			for(Object[] arrXM: resultProducto){
				arrXM[1 ]=((String)arrXM[1]).toUpperCase();
				arrXM[3 ]=((String)arrXM[3]).toUpperCase();
				arrXM[4 ]=((String)arrXM[4]).toUpperCase();				
				arrXM[6 ]=((String)arrXM[6]).toUpperCase();
				arrXM[10]=arrXM[10]!=null?((String)arrXM[10]).toUpperCase():null;
			}
			executeMultipleUpdates("INSERT INTO PRODUCTO(ID,CODIGO_BARRAS,MARCA_ID,NOMBRE,PRESENTACION,UNIDADES_POR_CAJA,UNIDAD_MEDIDA,COSTO,COSTO_VENTA,CONTENIDO,ABREBIATURA) VALUES(?,?,?,?,?,?,?,?,?,?,?)", resultProducto);
			resultProducto = null;

			List<Object[]> resultFDP = executeQuery(oldDBConnection, "SELECT ID,DESCRIPCION FROM FORMA_DE_PAGO");
			for(Object[] arrXM: resultFDP){
				arrXM[1]=((String)arrXM[1]).toUpperCase();
			}
			executeMultipleUpdates("INSERT INTO FORMA_DE_PAGO(ID,DESCRIPCION) VALUES(?,?)", resultFDP);
			resultFDP = null;

			List<Object[]> resultMDP = executeQuery(oldDBConnection, "SELECT ID,DESCRIPCION FROM METODO_DE_PAGO");
			for(Object[] arrXM: resultMDP){
				arrXM[1]=((String)arrXM[1]).toUpperCase();
			}
			executeMultipleUpdates("INSERT INTO METODO_DE_PAGO(ID,DESCRIPCION) VALUES(?,?)", resultMDP);
			resultMDP = null;

			List<Object[]> resultSucursal = executeQuery(oldDBConnection, "SELECT S.ID,S.ID_PADRE,S.NOMBRE,CONCAT(S.CALLE,', ',S.NUM_INTERIOR,', ',S.NUM_EXTERIOR,', ',P.NOMBRE,', ',P.MUNICIPIO_O_DELEGACION,', ',P.ENTIDAD_FEDERATIVA,', C.P. ',P.CODIGO_POSTAL) AS DIRECCION,S.TELEFONOS,S.USUARIO_SICOFI,S.PASSWORD_SICOFI,S.SERIE_SICOFI,S.COMENTARIOS,S.DESCUENTO_MAYOREO_HABILITADO FROM SUCURSAL S,POBLACION P WHERE S.POBLACION_ID=P.ID");
			for(Object[] arrXM: resultSucursal){				
				arrXM[2]=((String)arrXM[2]).toUpperCase();
				arrXM[3]=((String)arrXM[2]).toUpperCase();
				arrXM[4]=((String)arrXM[4]).toUpperCase();
			}
			executeMultipleUpdates("INSERT INTO SUCURSAL(ID,ID_PADRE,NOMBRE,DIRECCION,TELEFONOS,USUARIO_SICOFI,PASSWORD_SICOFI,SERIE_SICOFI,COMENTARIOS,DESCUENTO_MAYOREO_HABILITADO) VALUES(?,?,?,?,?,?,?,?,?,?)", resultSucursal);
			resultSucursal = null;

			List<Object[]> resultCliente = executeQuery(oldDBConnection, "SELECT C.ID,C.RFC,C.RAZON_SOCIAL,C.NOMBRE_ESTABLECIMIENTO,C.CONTACTO,C.TELEFONOS,C.EMAIL,C.OBSERVACIONES,CONCAT(C.CALLE,', #INT.',C.NUM_INTERIOR,', #EXT.',C.NUM_EXTERIOR,', ',P.NOMBRE,', ',P.MUNICIPIO_O_DELEGACION,', ',P.ENTIDAD_FEDERATIVA,', C.P. ',P.CODIGO_POSTAL) AS DIRECCION FROM CLIENTE C,POBLACION P WHERE C.POBLACION_ID=P.ID");
			for(Object[] arrXC: resultCliente){
				arrXC[2]=((String)arrXC[2]).toUpperCase();
				arrXC[3]=arrXC[3]!=null?((String)arrXC[3]).toUpperCase():null;
				arrXC[4]=arrXC[4]!=null?((String)arrXC[4]).toUpperCase():null;
				arrXC[5]=arrXC[5]!=null?((String)arrXC[5]).toUpperCase():null;
				arrXC[8]=((String)arrXC[8]).toUpperCase().replace(", #INT., ", ", ");
			}
			executeMultipleUpdates("INSERT INTO CLIENTE(ID,RFC,RAZON_SOCIAL,NOMBRE_ESTABLECIMIENTO,CONTACTO,TELEFONOS,EMAIL,OBSERVACIONES,DIRECCION) VALUES(?,?,?,?,?,?,?,?,?)", resultCliente);
			resultCliente = null;

			List<Object[]> resultPerfil = executeQuery(oldDBConnection, "SELECT ID,DESCRIPCION FROM PERFIL");
			executeMultipleUpdates("INSERT INTO PERFIL(ID,DESCRIPCION) VALUES(?,?)", resultPerfil);
			resultPerfil = null;

			List<Object[]> resultUsuario = executeQuery(oldDBConnection, "SELECT USUARIO_ID,HABILITADO,NOMBRE_COMPLETO,PASSWORD,EMAIL,SUCURSAL_ID FROM USUARIO");
			executeMultipleUpdates("INSERT INTO USUARIO(ID,HABILITADO,NOMBRE_COMPLETO,PASSWORD,EMAIL,SUCURSAL_ID) VALUES(?,?,?,?,?,?)", resultUsuario);
			resultUsuario = null;

			List<Object[]> resultUsuarioPerfil = executeQuery(oldDBConnection, "SELECT USUARIO_ID,PERFIL_ID FROM USUARIO_PERFIL");
			executeMultipleUpdates("INSERT INTO USUARIO_PERFIL(USUARIO_ID,PERFIL_ID) VALUES(?,?)", resultUsuarioPerfil);
			resultUsuarioPerfil = null;

			List<Object[]> resultAlmacen = executeQuery(oldDBConnection, "SELECT ID,SUCURSAL_ID,TIPO_ALMACEN FROM ALMACEN");
			executeMultipleUpdates("INSERT INTO ALMACEN(ID,SUCURSAL_ID,TIPO_ALMACEN) VALUES(?,?,?)", resultAlmacen);
			resultAlmacen = null;

			List<Object[]> resultAlmacenProducto = executeQuery(oldDBConnection, "SELECT ID,ALMACEN_ID,PRODUCTO_ID,CANTIDAD_ACTUAL,PRECIO_VENTA,PRECIO_MAYOREO,COSTO FROM ALMACEN_PRODUCTO");
			executeMultipleUpdates("INSERT INTO ALMACEN_PRODUCTO(ID,ALMACEN_ID,PRODUCTO_ID,CANTIDAD_ACTUAL,PRECIO_VENTA,PRECIO_MAYOREO,COSTO) VALUES(?,?,?,?,?,?,?)", resultAlmacenProducto);
			resultAlmacenProducto = null;
			
			List<Object[]> resultCFD = executeQuery(oldDBConnection, "SELECT ID,ULTIMA_ACTUALIZACION,CONTENIDO_ORIGINAL_XML,CALLING_ERROR_RESULT FROM CFD_VENTA");
			executeMultipleUpdates("INSERT INTO CFD_VENTA (ID,ULTIMA_ACTUALIZACION,CONTENIDO_ORIGINAL_XML,CALLING_ERROR_RESULT) VALUES(?,?,?,?)", resultCFD);
			resultCFD = null;
			
			List<Object[]> resultPedidoVenta = executeQuery(oldDBConnection, "SELECT PV.ID,MAX(PVE.ESTADO_ID) AS ESTADO,PVE.FECHA,PV.USUARIO_ID,PV.CLIENTE_ID,PV.FORMA_DE_PAGO_ID,PV.CFD_VENTA_ID,PV.METODO_DE_PAGO_ID,PV.FACTORIVA,PV.COMENTARIOS,PV.DESCUENTO_APLICADO,PV.FACTURABLE,PV.NUMERO_TICKET,PV.CAJA,PV.IMPORTE_RECIBIDO,PV.APROBACION_BANCARIA_TC,PV.MAYOREO,PV.PORCENTAJE_DESCUENTO_CALCULADO,PV.PORCENTAJE_DESCUENTO_EXTRA,PV.CONDICIONES_DE_PAGO,PV.NUM_DE_CUENTA,PV.MOTIVO_DESCUENTO FROM PEDIDO_VENTA_ESTADO PVE,PEDIDO_VENTA PV WHERE PVE.PEDIDO_VENTA_ID=PV.ID GROUP BY PVE.PEDIDO_VENTA_ID");
			executeMultipleUpdates("INSERT INTO PEDIDO_VENTA(ID,ESTADO,FECHA_ACTUALIZACION,USUARIO_ID,CLIENTE_ID,FORMA_DE_PAGO_ID,CFD_VENTA_ID,METODO_DE_PAGO_ID,FACTORIVA,COMENTARIOS,DESCUENTO_APLICADO,FACTURABLE,NUMERO_TICKET,CAJA,IMPORTE_RECIBIDO,APROBACION_VISA_MASTERCARD,MAYOREO,PORCENTAJE_DESCUENTO_CALCULADO,PORCENTAJE_DESCUENTO_EXTRA,CONDICIONES_DE_PAGO,NUM_DE_CUENTA,MOTIVO_DESCUENTO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", resultPedidoVenta);
			resultPedidoVenta = null;
			
			List<Object[]> resultPedidoVentaDetalle = executeQuery(oldDBConnection, "SELECT PVD.ID,PVD.PEDIDO_VENTA_ID,PV.ALMACEN_ID,PVD.PRODUCTO_ID,PVD.CANTIDAD,PVD.PRECIO_VENTA FROM PEDIDO_VENTA_DETALLE PVD,PEDIDO_VENTA PV WHERE PVD.PEDIDO_VENTA_ID=PV.ID");
			executeMultipleUpdates("INSERT INTO PEDIDO_VENTA_DETALLE(ID,PEDIDO_VENTA_ID,ALMACEN_ID,PRODUCTO_ID,CANTIDAD,PRECIO_VENTA) VALUES(?,?,?,?,?,?)", resultPedidoVentaDetalle);
			resultPedidoVentaDetalle = null;
			
			List<Object[]> resultMHP = executeQuery(oldDBConnection, "SELECT ID,ALMACEN_ID,PRODUCTO_ID,FECHA,TIPO_MOVIMIENTO_ID,CANTIDAD,COSTO,PRECIO,USUARIO_ID FROM MOVIMIENTO_HISTORICO_PRODUCTO");
			executeMultipleUpdates("INSERT INTO MOVIMIENTO_HISTORICO_PRODUCTO(ID,ALMACEN_ID,PRODUCTO_ID,FECHA,TIPO_MOVIMIENTO,CANTIDAD,COSTO,PRECIO,USUARIO_ID) VALUES(?,?,?,?,?,?,?,?,?)", resultMHP);
			resultMHP = null;			
			String queryAjustes = 
			"SELECT   AP.ALMACEN_ID,AP.PRODUCTO_ID,NOW(),0,(AP.CANTIDAD_ACTUAL-R1.SUM_CANT_AFECTADA) AS CANT_AJUSTE,AP.COSTO,AP.PRECIO_VENTA,'root'\n" +
			"FROM     ALMACEN_PRODUCTO AP, PRODUCTO P,(\n" +
			"    SELECT   MHP.ALMACEN_ID ,P.CODIGO_BARRAS,SUM(MHP.CANTIDAD*TM.FACTOR_AFECTA_CANTIDAD_INV) AS SUM_CANT_AFECTADA\n" +
			"    FROM     MOVIMIENTO_HISTORICO_PRODUCTO MHP, PRODUCTO P , TIPO_MOVIMIENTO TM\n" +
			"    WHERE    1=1\n" +
			"    AND      MHP.PRODUCTO_ID = P.ID\n" +
			"    AND      MHP.TIPO_MOVIMIENTO_ID = TM.ID\n" +
			"    AND      MHP.TIPO_MOVIMIENTO_ID BETWEEN 20 AND 40\n" +
			"    GROUP BY MHP.ALMACEN_ID ,MHP.PRODUCTO_ID\n" +
			") R1\n" +
			"WHERE    1=1\n" +
			"AND      AP.PRODUCTO_ID = P.ID\n" +
			"AND      AP.ALMACEN_ID = R1.ALMACEN_ID\n" +
			"AND      P.CODIGO_BARRAS = R1.CODIGO_BARRAS\n" +
			"AND      (AP.CANTIDAD_ACTUAL-R1.SUM_CANT_AFECTADA) <> 0\n" +
			"ORDER BY AP.ALMACEN_ID,CANT_AJUSTE,AP.PRODUCTO_ID\n" +
			"";
			
			List<Object[]> resultMHPAj = executeQuery(oldDBConnection, queryAjustes);
			int cantAfect = 0;
			for(Object[] arrX: resultMHPAj){
				cantAfect=((BigDecimal)arrX[4]).intValue();
				if(cantAfect>0){
					arrX[3]=21;
				} else {
					arrX[3]=31;
					arrX[4]=new BigDecimal(cantAfect*-1);
				}
			}
			executeMultipleUpdates("INSERT INTO MOVIMIENTO_HISTORICO_PRODUCTO(ALMACEN_ID,PRODUCTO_ID,FECHA,TIPO_MOVIMIENTO,CANTIDAD,COSTO,PRECIO,USUARIO_ID) VALUES(?,?,?,?,?,?,?,?)", resultMHPAj);
			
			System.out.println("=================================== END IMPORT OK =================================");	
			System.exit(0);	
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			System.exit(3);
		}
	}

	private static void executeMultipleUpdates(String sql, List<Object[]> resultLineas) throws SQLException {
		System.out.println("-> executeMultipleUpdates: SQL:"+sql);
		final PreparedStatement ps = newDBConnection.prepareStatement(sql);
		int cm = 0;
        int tm = resultLineas.size();
		for (Object[] row : resultLineas) {
			if (debug) {
				System.out.println("SQL:" + sql + " <= " + Arrays.asList(row));
			}
			executeUpdate(newDBConnection, ps, row);
			cm++;
			System.out.print("\rAv:\t"+((cm*100)/tm)+"%");
		}
		System.out.println("\t Total Affected: " + cm);
		
		ps.close();
	}

	private static void connectToOldDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			System.exit(1);
		}

		try {
			oldDBConnection = DriverManager.getConnection(urlOldDB, usrOldDB, pwdOldDB);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			System.exit(2);
		}

	}

	private static void connectToNewDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			System.exit(1);
		}

		try {
			newDBConnection = DriverManager.getConnection(urlNewDB, usrNewDB, pwdNewDB);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			System.exit(2);
		}
	}

	private static List<Object[]> executeQuery(Connection conn, String sql) throws SQLException {		
		System.out.println("-> executeQuery: SQL:"+sql);
		List<Object[]> result = new ArrayList<Object[]>();
		final Statement st = conn.createStatement();

		final ResultSet rs = st.executeQuery(sql);
		final ResultSetMetaData rsMD = rs.getMetaData();
		if (debug) {
			for (int i = 1; i <= rsMD.getColumnCount(); i++) {
				if (i > 1) {
					System.out.print(",");
				}
				System.out.print(rsMD.getColumnName(i));
			}
			System.out.println("");
		}
		int c = 0;
		for (c = 0; rs.next(); c++) {
			Object[] row = new Object[rsMD.getColumnCount()];
			for (int i = 1; i <= rsMD.getColumnCount(); i++) {
				row[i - 1] = rs.getObject(rsMD.getColumnName(i));

				if (debug) {
					if (i > 1) {
						System.out.print(",");
					}
					System.out.print(row[i - 1]);
				}

			}
			result.add(row);
			if (debug) {
				System.out.println("");
			}
		}
		System.out.println("Count: " + c);
		
		rs.close();
		return result;
	}

	private static void executeUpdate(Connection conn, PreparedStatement st, Object[] row) throws SQLException {
		st.clearParameters();
		st.clearWarnings();

		for (int j = 1; j <= row.length; j++) {
			st.setObject(j, row[j - 1]);
		}

		int r = st.executeUpdate();
		if (debug) {
			System.out.println("Affected: " + r);
		}
	}

}
