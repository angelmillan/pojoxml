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
    List<Producto> pp = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Producto> pp = new ArrayList<>();
        Direccion direccion1 = new Direccion("Calle", "Luna", "13", "2ª", "b", "1", "2", "Jaén", 23002, "España", "Jaén");
        Cliente c1 = new Cliente("Angel", "Millán", "angelmillan@me.com", 606643217, "25987663D", 1, direccion1);
        Producto p1 = new Producto(1, "Martillo Bellota", "Martillo de tapicero", 12.45);
        Producto p2 = new Producto(2,"Desatascador", "Destascador de chupón", 6.23);
        Producto p3 = new Producto(3,"Barrena 18", "Barrena de madera de 18 cm", 5.30);
        //Productos pp = new Productos();
        pp.add(p1);
        pp.add(p2);
        pp.add(p3);
        
        
        Factura factura = new Factura(c1, direccion1, pp);
                
        
        
        
        try {
            JAXBContext jbc = JAXBContext.newInstance(direccion1.getClass());
            Marshaller jbcm = jbc.createMarshaller();
            jbcm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jbcm.marshal(factura, new File("factura.xml"));

        } catch (JAXBException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

}
