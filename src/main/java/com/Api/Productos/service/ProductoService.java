package com.Api.Productos.service;

import com.Api.Productos.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> GetProdctos();
    String DeleteProducto(Long id);
    String PosProductos(Producto producto);
    String PutProducto(Producto producto, Long id);

}
