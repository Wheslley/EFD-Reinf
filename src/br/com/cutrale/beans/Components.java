package br.com.cutrale.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wheslley Nycolas da Silva (SC703450)
 */
@XmlRootElement
public class Components {
    
    private List<Component> objectComponent;
    
    public Components(){
        this.objectComponent = new ArrayList<>();
    }

    public List<Component> getObjectComponent() {
        return objectComponent;
    }
    
    @XmlElement
    public void setObjectComponent(List<Component> listComponents) {
        this.objectComponent = listComponents;
    }
    
    public void addObjectComponent(Component component){
        this.objectComponent.add(component);
    }
    
}
