/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.regex.Pattern;

/**
 *
 * @author 57305
 */
public class Empleado_Ctr {
    private boolean respuesta = false;
    
    
    public boolean validarPassword(String password){
        String valor = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#$%&/()=?¿¡+-|°_:;.,^}{]).*";
        Pattern regex = Pattern.compile(valor);
        if(regex.matcher(password).matches() && password.length() >=8){
            respuesta = true;
        }
        return respuesta;
    }
}
