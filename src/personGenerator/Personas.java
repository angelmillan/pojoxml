/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personGenerator;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matinal
 */
@XmlRootElement(name = "personas")
@XmlAccessorType (XmlAccessType.FIELD)
public class Personas {
    @XmlElement(name = "persona")
    private List<Persona> personas = null;

    public Personas() {
        this.personas = new ArrayList<Persona>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    public void addPersona(Persona persona){
        this.personas.add(persona);
    }
    
    public void deletePersona(Persona persona){
        this.personas.remove(persona);
    }
        
}
