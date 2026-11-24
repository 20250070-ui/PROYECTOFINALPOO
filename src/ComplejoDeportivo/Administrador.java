/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author Romina Tarazona
 */
public class Administrador extends Empleado
{

    public Administrador(String dni, String apellido, String nombre, String contra, String usuario) {
        super(dni, apellido, nombre, contra, usuario);
    }

   

    @Override
    public String rol() 
    {
        return "Administrador";

    }
    
}
