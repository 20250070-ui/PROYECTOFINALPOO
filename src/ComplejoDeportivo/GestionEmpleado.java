/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

import javax.swing.JOptionPane;

/**
 *
 * @author Romina Tarazona
 */
public class GestionEmpleado 
{
    private Empleado[] Contratados;
    private int conta;

    public GestionEmpleado() 
    {
        Contratados = new Empleado[20]; // SUPUESTO: tamaño del arreglo
        conta = 0;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
     public Empleado get(int i) 
     { 
         return Contratados[i];
     }
    
    public void ingresar(Empleado ref)
    {
        boolean rechazado = false;
        if(ref.dni.isEmpty() || ref.apellido.isEmpty() || ref.nombre.isEmpty() || ref.contra.isEmpty() ||
         ref.usuario.isEmpty())
           {
           JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
          rechazado = true;
          }

    
        for(int i=0;i<conta;i++)
    {
        if(ref.dni.equals(Contratados[i].getDni()))
        {
            JOptionPane.showMessageDialog(null, "DNI existente");
            rechazado = true;
        }
        else if (ref.usuario.equals(Contratados[i].getUsuario()))
        {
            JOptionPane.showMessageDialog(null, "Usuario existente");
            rechazado = true;
        }
    }
    
    if (rechazado == false)
    {
        if (conta < Contratados.length) 
        {
            Contratados[conta] = ref;
            conta++;
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Cantidad de registros excedida");
        }
    }
        
    }
    
    public void eliminar(String dni)
    {
        boolean noencontrado = true;
        for(int i=0;i<conta;i++)
        {
            if(Contratados[i].getDni().equalsIgnoreCase(dni))
            {
                Contratados[i].setNombre("Eliminado");
                Contratados[i].setApellido("Eliminado");
                Contratados[i].setUsuario("Eliminado");
                Contratados[i].setContra("Eliminado");
                noencontrado = false;
                JOptionPane.showMessageDialog(null, "Empleado eliminado");
            }
        }
        
        if (noencontrado)
        {
            JOptionPane.showMessageDialog(null, "No se encontro");
        }
    }
    
    public void modificar()
    {
     //falta pq no se   
    }
   
    public void BUSCAR(String dni)
    {
        
        boolean encontrar=false;
        for(int i=0;i<conta;i++)
        {
            if(Contratados[i].getDni().equals(dni))
            {
                encontrar=true;
                break;
            }
        }
         if(encontrar)
        {
          JOptionPane.showMessageDialog(null, "Si esta ingresado.");
        }
       
        else
        {
         JOptionPane.showMessageDialog(null, "No existe");
        }
    }
     public Empleado obtenerEmpleado(String dni)
    {
    for (int i = 0; i < conta; i++) 
    {
        if (Contratados[i].getDni().equalsIgnoreCase(dni)) 
        {
            return Contratados[i];
        }
            
    }
    return null;
   }
    
    

}

