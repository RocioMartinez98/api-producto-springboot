package com.Api.Productos.service.implement;

import com.Api.Productos.entity.Producto;
import com.Api.Productos.repository.ProductoRepository;
import com.Api.Productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplements implements ProductoService {

    @Autowired //identifica que es una instancia
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> GetProdctos() {
        return productoRepository.findAll();
    }

    @Override
    public String DeleteProducto(Long id) {
        productoRepository.deleteById(id);
        return "Producto eliminado exitosamente";
    }

    @Override
    public String PosProductos(Producto producto) {
        productoRepository.save(producto);
        return "Producto agregado exitosamente";
    }

    @Override
    public String PutProducto(Producto producto, Long id) {
        Producto producto1 = productoRepository.findById(id).get();

        if(producto1 !=null){
            producto1.setNombre(producto.getNombre());
            producto1.setPrecio(producto.getPrecio());

            productoRepository.save(producto1);
            return "Producto actualizzado";
        }
        return "Hubo un error";

    }
}
