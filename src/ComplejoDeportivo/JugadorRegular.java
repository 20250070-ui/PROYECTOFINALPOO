/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;


/**
 *
 * @author Romina Tarazona
 */
public class JugadorRegular extends Jugador
{
    
    public JugadorRegular(String dni, String telefono, String nombre, String apellido, String correo) {
        super(dni, telefono, nombre, apellido, correo);
        this.tipo = "Regular";
    }

    @Override
    public double Descuento(double monto) {
        return 0;
    }

   
    
}
