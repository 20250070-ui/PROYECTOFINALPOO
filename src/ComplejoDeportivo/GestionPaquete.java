/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

import javax.swing.JOptionPane;

/**
 *
 * @author Romina
 */
public class GestionPaquete 
{
    private PaquetesPromo[] Paquete;
    private int conta;

    public GestionPaquete() {
        Paquete = new PaquetesPromo[20];// SUPUESTO: tamaño del arreglo
        conta = 0;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
      public PaquetesPromo get(int i) 
    { 
    return Paquete[i]; 
    }
    
    public void INGRESAR(PaquetesPromo ref)
    {
        
        boolean rechazado = false;
        if(ref.getNombre().isEmpty() || ref.getPrecio() <= 0 || ref.getServicios() == null ||
            ref.getServicios().length == 0)
         {
            JOptionPane.showMessageDialog(null, "Nombre, precio promocional (mayor a 0) y " +
            "al menos un servicio son datos obligatorios");
             rechazado = true;
         }

    
        for(int i=0;i<conta;i++)
    {
        if(ref.getNombre().equals(Paquete[i].getNombre()))
        {
            JOptionPane.showMessageDialog(null, "Paquete existente");
            rechazado = true;
        }
    }
    
    if (rechazado == false)
    {
        if (conta < Paquete.length) 
        {
            Paquete[conta] = ref;
            conta++;
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Cantidad de registros excedida");
        }
    }
        
    
    }
     public void eliminar(String nombre)
     {
        boolean noencontrado = true;
        for(int i=0;i<conta;i++)
        {
          if(Paquete[i].getNombre().equalsIgnoreCase(nombre))
             {
               Paquete[i].setNombre("Eliminado");
                noencontrado = false;
                JOptionPane.showMessageDialog(null, "Paquete eliminado");
             }
       }

       if (noencontrado)
        {
          JOptionPane.showMessageDialog(null, "No se encontro registro");
         }
     } 
     public void modificar()
    {
     //falta pq no se   
    }
   
      public void BUSCAR(String nombre)
    {
        
        boolean encontrar=false;
        for(int i=0;i<conta;i++)
        {
            if(Paquete[i].getNombre().equals(nombre))
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
      
      public PaquetesPromo obtenerPaquete(String nombre) 
      {
        for (int i = 0; i < conta; i++) 
        {
           if (Paquete[i].getNombre().equalsIgnoreCase(nombre)) 
           {
            return Paquete[i];
           }
        }
      return null;
      }

  

    
}
