/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author Romina Tarazona
 */
public class EncargadodeCancha extends Empleado
{

    public EncargadodeCancha(String dni, String apellido, String nombre, String contra, String usuario) {
        super(dni, apellido, nombre, contra, usuario);
    }

    

    @Override
    public String rol() 
    {
        return "Encargado de Cancha";    
    }
    
}
