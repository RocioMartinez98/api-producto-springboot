package com.Api.Productos.controller;

import com.Api.Productos.entity.Producto;
import com.Api.Productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Producto")
@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<?> PostProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.PosProductos(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> GetProducto(){
        return ResponseEntity.ok(productoService.GetProdctos());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteProducto(@PathVariable Long id){
        return ResponseEntity.ok(productoService.DeleteProducto(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> PutProducto(@RequestBody Producto producto, @PathVariable Long id){
        return ResponseEntity.ok(productoService.PutProducto(producto, id));
    }
}
