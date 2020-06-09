package conexoes;

import java.util.ResourceBundle;

public class AtributosBanco {

    private static ResourceBundle ATRB_BANCO = ResourceBundle.getBundle("conexoes.atributos_banco");

    public static String getAtributos(String atributo){
        if(ATRB_BANCO.containsKey(atributo)){
            return ATRB_BANCO.getString(atributo);
        }
        return "Não encontrado";
    }

}
