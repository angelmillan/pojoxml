/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojomarshallingxml;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angelmillanmiralles
 */
public class Factura {
    private Cliente cliente;
    private Direccion direccion;
    private List<Producto> productos;

    public Factura() {
    }

    public Factura(Cliente cliente, Direccion direccion, List<Producto> productos) {
        this.cliente = cliente;
        this.direccion = direccion;
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
    
}
