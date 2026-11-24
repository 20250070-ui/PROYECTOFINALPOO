/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author Romina Tarazona
 */
public class JugadorFrecuente extends Jugador 
{

    public JugadorFrecuente(String dni, String telefono, String nombre, String apellido, String correo) {
        super(dni, telefono, nombre, apellido, correo);
        this.tipo = "Frecuente";
    }

    @Override
    public double Descuento(double monto) {
        return monto * 0.10; // SUPUESTO: 10% de descuento
    }

    
    
   
   
    
}
