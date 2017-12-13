/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personGenerator;

import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Ángel Millán
 */
public class PersonsGenerator {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SecureRandom rand = new SecureRandom();
        Personas personas = new Personas();
        Persona persona = new Persona();
        Integer dniInt = 0;
        String nif = "";
        int contadorHombres = 0;
        int contadorMujeres = 0;

        for (int i = 0; i < 1000; i++) {
            dniInt = 1000000 + rand.nextInt(98999999);
            nif = "" + dniInt + calculaLetra(dniInt);

            while (nif.length() != 9) {
                nif = "0" + nif;
            }

            if (rand.nextInt(2) == 1) {
                persona = new Persona(Masculino.MALE[rand.nextInt(4999)], Apellidos.APELLIDOS[rand.nextInt(4999)], Apellidos.APELLIDOS[rand.nextInt(4999)], "Hombre", nif);
                contadorHombres++;
            } else {
                persona = new Persona(Femenino.FEMALE[rand.nextInt(4999)], Apellidos.APELLIDOS[rand.nextInt(4999)], Apellidos.APELLIDOS[rand.nextInt(4999)], "Mujer", nif);
                contadorMujeres++;
            }
            System.out.println("" + persona.toString());
            personas.addPersona(persona);

        }
        
        System.out.println("Total Mujeres " + contadorMujeres);
        System.out.println("Total Hombres " + contadorHombres);

        try {
            JAXBContext jbc = JAXBContext.newInstance(personas.getClass());
            Marshaller jbcm = jbc.createMarshaller();
            jbcm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jbcm.marshal(personas, new File("personas.xml"));
            System.out.println("Fichero XML generado con éxito en carpeta raiz del proyecto personas.xml");

        } catch (JAXBException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

    public static char calculaLetra(int dni) {
        String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo = dni % 23;
        char letra = juegoCaracteres.charAt(modulo);
        return letra;
    }

}
