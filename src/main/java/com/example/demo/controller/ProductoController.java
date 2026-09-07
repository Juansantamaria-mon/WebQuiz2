package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.registrarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @GetMapping("/buscar/{categoria}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(@PathVariable String categoria) {
        List<Producto> productos = productoService.buscarPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }
}