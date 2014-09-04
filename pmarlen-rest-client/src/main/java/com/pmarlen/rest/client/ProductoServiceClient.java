package com.pmarlen.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import com.pmarlen.wscommons.services.dto.Producto;

import com.google.gson.*;

public class ProductoServiceClient {

	public static void main(String[] args) {
		try {

			Client client = Client.create();
			Gson gson=new Gson();

			WebResource webResource = client.resource("http://localhost:8070/pmarlen-rest-services/rs/producto/getAll");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			//System.out.println("Output from Server .... \n");
			//System.out.println(output);

			Producto[] productoRead = new Producto[1];
			productoRead = gson.fromJson(output, productoRead.getClass());

			System.out.println("productoRead:");
			for(Producto pX: productoRead){
				System.out.println("\t->Producto:"+pX.getId()+", ["+pX.getCodigoBarras()+"]");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
