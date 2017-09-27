/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojomarshallingxml;

import java.io.File;
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
        Direccion direccion1 = new Direccion("Calle", "Luna", "13", "2ª", "b", "1", "2", "Jaén", 23002, "España", "Jaén");
        Direccion direccion2 = new Direccion("Calle", "llana", "19", "casa","","","3","Jaén",23003,"España", "Jaén");
        Cliente c1 = new Cliente("Angel", "Millán", "angelmillan@me.com", 606643217, "25987663D", 1, direccion1);
        Cliente c2 = new Cliente("Pablo", "Fernandez", "pablofernandezgmil.com", 661140415, "775558963R",2,direccion2);
        
        
        
        
        
        
        try {
            JAXBContext jbc = JAXBContext.newInstance(direccion1.getClass());
            Marshaller jbcm = jbc.createMarshaller();
            jbcm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jbcm.marshal(direccion1, new File("direccion.xml"));

        } catch (JAXBException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

}
