package br.com.cutrale.reinf;

import br.com.cutrale.beans.Component;
import br.com.cutrale.beans.Components;
import br.com.cutrale.framework.util.Crypto;
import br.com.cutrale.logic.ConverterClassXML;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wheslley Nycolas da Silva (SC703450)
 *
 */
public class EDFReinf {

    public static void main(String[] args) {

        String user = "SC703450";
        String pass = "ySkDD21BR0KH/bxJY%2B6ieQ==";

        try {

            getJDBC(user, pass);

        } catch (SQLException | ClassNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EDFReinf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void getJDBC(String user, String pass) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.0.102:1521:tst", user, Crypto.decrypt(java.net.URLDecoder.decode(pass, "UTF-8")));
        PreparedStatement ps = conn.prepareStatement("select comp_cd, comp_cd_compoe, id from componente_compoe_componente where comp_cd like '%tab.CPTI0040%' order by id");
        
        Components components = new Components();
        ResultSet rs = ps.executeQuery();


        while (rs.next()) {

            String componente = rs.getString("comp_cd");
            String componenteFilho = rs.getString("comp_cd_compoe");
            String versao = rs.getString("id");
            Component c = new Component(componente, componenteFilho, versao);
            components.addObjectComponent(c);
            
        }
        
        String lineXML = ConverterClassXML.getInstance().getComponentsXML(components);
        
        System.out.println(lineXML);
        
        ps.close();
        conn.close();

    }

}
