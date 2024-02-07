package com.Api.Productos;

import com.Api.Productos.entity.Producto;
import com.Api.Productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class ProductosApplication implements CommandLineRunner {

	private final ProductoService productoService;

	@Autowired
	public ProductosApplication(ProductoService productoService) {
		this.productoService = productoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Generar y agregar 4 productos aleatorios
		for (int i = 0; i < 4; i++) {
			Producto producto = generarProductoAleatorio();
			productoService.PosProductos(producto);
		}
	}

		private Producto generarProductoAleatorio() {
			Random random = new Random();
			String[] nombres = {"Sal", "Pimienta", "Oregano", "Morron"};

			Long id = 1 + random.nextLong(100);
			int precio = 100 + random.nextInt(900); // Precio aleatorio
			int indice = random.nextInt(nombres.length);
			return new Producto(id, nombres[indice], precio);
		}


}
