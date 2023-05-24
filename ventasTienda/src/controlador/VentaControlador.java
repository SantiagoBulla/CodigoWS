/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author 57305
 */
public class VentaControlador {
    
    private int cantidad = 0, unitario = 0;
    private double subtotal = 0.0; 
    private boolean respuesta; 
    
    public double calcularSubtotal(int cantidades, int vunitario){
        try {
            subtotal = cantidades * vunitario;
            respuesta = true;
        } catch (Exception e) {
            System.out.println("error de calculo"+e);
        }
        return subtotal;
    }
   
}
