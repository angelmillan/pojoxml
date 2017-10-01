/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojomarshallingxml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Ángel Millán
 */
public class POJOMarshallingXML {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Direccion direccion = new Direccion("Calle", "Luna", "13", "2ª", "b", "1", "2", "Jaén", 23002, "España", "Jaén");
        Cliente cliente = new Cliente("Angel", "Millán", "angelmillan@me.com", 606643217, "25987663D", 1, direccion);
        Producto p1 = new Producto(1, "Martillo Bellota", "Martillo de tapicero", 12.45);
        Producto p2 = new Producto(2,"Desatascador", "Destascador de chupón", 6.23);
        Producto p3 = new Producto(3,"Barrena 18", "Barrena de madera de 18 cm", 5.30);
        Productos productos = new Productos();
        productos.setProductos(new ArrayList<Producto>());
        productos.getProductos().add(p1);
        productos.getProductos().add(p2);
        productos.getProductos().add(p3);
        System.out.println(productos.toString());

        Factura factura = new Factura(cliente, direccion, productos);
                
        
        
        
        try {
            JAXBContext jbc = JAXBContext.newInstance(factura.getClass());
            Marshaller jbcm = jbc.createMarshaller();
            jbcm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jbcm.marshal(factura, new File("factura.xml"));

        } catch (JAXBException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

}
