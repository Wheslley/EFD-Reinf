package br.com.cutrale.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wheslley Nycolas da Silva (SC703450)
 */
@XmlRootElement
public class Component {

    private String componentCd;
    private String componentCompoe;
    private String versao;

    public Component(String nome, String filho, String versao) {
        this.componentCd = nome;
        this.componentCompoe = filho;
        this.versao = versao;
    }

    public Component() {
    }

    public String getComponentCd() {
        return componentCd;
    }
    
    @XmlElement
    public void setComponentCd(String componentCd) {
        this.componentCd = componentCd;
    }

    public String getComponentCompoe() {
        return componentCompoe;
    }
    
    @XmlElement
    public void setComponentCompoe(String componentCompoe) {
        this.componentCompoe = componentCompoe;
    }

    public String getVersao() {
        return versao;
    }
    
    @XmlElement
    public void setVersao(String versao) {
        this.versao = versao;
    }
    
}
