package br.com.cutrale.logic;

import br.com.cutrale.beans.Components;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Wheslley Nycolas da Silva (SC703450)
 */
public class ConverterClassXML {

    private static ConverterClassXML instance;

    public static synchronized ConverterClassXML getInstance() {
        if (instance == null) {
            instance = new ConverterClassXML();
        }
        return instance;
    }

    /**
     *
     * @param component
     * @return
     */
    public String getComponentsXML(Components component) {

        String xmlString = "";
        
        try {
            JAXBContext context = JAXBContext.newInstance(Components.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            m.marshal(component, sw);
            xmlString = sw.toString();
            
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            return xmlString;
        }
        
    }
}
