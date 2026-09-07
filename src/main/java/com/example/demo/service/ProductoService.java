package com.example.demo.service;

import com.example.demo.entity.Producto;
import java.util.List;

public interface ProductoService {

    Producto registrarProducto(Producto producto);

    List<Producto> buscarPorCategoria(String categoria);
}