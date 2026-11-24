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
public class GestionJugador 
{
    private Jugador[] Jugadores;
    private int conta;

    public GestionJugador() 
    {
        Jugadores = new Jugador[100];// SUPUESTO: tamaño del arreglo
        conta = 0;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    public Jugador get(int i) 
     { 
         return Jugadores[i];
     }
    
    public void ingresar(Jugador ref)
    {
         boolean rechazado = false;
         if(ref.dni.isEmpty() || ref.telefono.isEmpty() || ref.nombre.isEmpty() || ref.apellido.isEmpty() ||
        ref.correo.isEmpty())
       {
        JOptionPane.showMessageDialog(null, "Todos los datos son obligatorios");
        rechazado = true;
         }

    
        for(int i=0;i<conta;i++)
    {
        if(ref.dni.equals(Jugadores[i].getDni()))
        {
            JOptionPane.showMessageDialog(null, "DNI existente");
            rechazado = true;
        }
      
    }
    
    if (rechazado == false)
    {
        if (conta < Jugadores.length) 
        {
            Jugadores[conta] = ref;
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
      if(Jugadores[i].getDni().equalsIgnoreCase(dni))
       {
          Jugadores[i].setNombre("Eliminado");
          Jugadores[i].setApellido("Eliminado");
          Jugadores[i].setCorreo("Eliminado");
          Jugadores[i].setTelefono("Eliminado");
          noencontrado = false;
          JOptionPane.showMessageDialog(null, "Registro de Jugador eliminado");
        }
    }
     if (noencontrado)
     {
         JOptionPane.showMessageDialog(null, "No se encontro registro");
      }
    }
    public void registrarFinalizada(String dni)
    {
          for(int i=0;i<conta;i++)
          {
            if(Jugadores[i].getDni().equals(dni))
            {
              String antes = Jugadores[i].getTipo();
              Jugadores[i].ReservaFinalizada();
               if(antes.equals("Regular") && Jugadores[i].getTipo().equals("Frecuente"))
              {
                Jugador j = Jugadores[i];
                Jugadores[i] = new JugadorFrecuente(j.getDni(), j.getTelefono(), j.getNombre(),
                j.getApellido(), j.getCorreo());
                Jugadores[i].setReservas(j.getReservas());
              }
           }
         }
    }
     public void BUSCAR(String dni)
    {
        
        boolean encontrar=false;
        for(int i=0;i<conta;i++)
        {
            if(Jugadores[i].getDni().equals(dni))
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
     public Jugador obtenerJugador(String dni)
    {
      for (int i = 0; i < conta; i++) {
        if (Jugadores[i].getDni().equalsIgnoreCase(dni)) {
            return Jugadores[i];
        }
    }
    return null;
    
    }
    

}
    
    
    
    

