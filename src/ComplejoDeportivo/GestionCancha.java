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
public class GestionCancha 
{
    private Cancha[] Canchas;
    private int conta;

    public GestionCancha() {
        Canchas = new Cancha[20];// SUPUESTO: tamaño del arreglo
        conta = 0;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
    public Cancha get(int i) 
    { 
     return Canchas[i]; 
    }
    
    public void ingresar(Cancha ref)
    {
        if (ref.getCodigo() == null || ref.getCodigo().isEmpty() || ref.getNombre().isEmpty() || ref.getTarifaB() <= 0)
       {
        JOptionPane.showMessageDialog(null, "Codigo, nombre y tarifa base (mayor a 0) son datos obligatorios");
        return;
       }
        for(int i=0;i<conta;i++)
       {
           if(ref.getCodigo().equalsIgnoreCase(Canchas[i].getCodigo()))
          {
            JOptionPane.showMessageDialog(null, "Codigo de cancha existente");
            return;
          }
       }
    
 
        
        if (conta < Canchas.length) 
        {
            Canchas[conta] = ref;
            conta++;
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Cantidad de registros excedida");
        }
    }
 
 
    public void eliminar(String codigo)
    {
        boolean noencontrado = true;
        for(int i=0;i<conta;i++)
        {
            if(Canchas[i].getCodigo().equalsIgnoreCase(codigo))
            {
                Canchas[i].setNombre("Eliminado");
                Canchas[i].setEstado("Eliminado");
                noencontrado = false;
                JOptionPane.showMessageDialog(null, "Registro de cancha eliminado");
            }
        }
        
        if (noencontrado)
        {
            JOptionPane.showMessageDialog(null, "No se encontro registro");
        }
    }
    
    public boolean Modificar(String codigo, String nombre, double tarifaB, String estado) {
        int pos = buscarPosPorCodigo(codigo);
        if (pos == -1) {
            return false;
        }

        Cancha can = Canchas[pos];
        can.setNombre(nombre);
        can.setTarifaB(tarifaB);
        can.setEstado(estado);
        return true;
    }

    public int buscarPosPorCodigo(String codigo) {
        for (int i = 0; i < conta; i++) {
            if (Canchas[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }
    
    public void BUSCAR(String codigo)
    {
        
        boolean encontrar=false;
        for(int i=0;i<conta;i++)
        {
            if(Canchas[i].getCodigo().equals(codigo))
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
    public Cancha obtenerCancha(String codigo) 
    {
    for (int i = 0; i < conta; i++)
    {
        if (Canchas[i].getCodigo().equalsIgnoreCase(codigo))
        {
            return Canchas[i];
        }
    }
    return null;
    }

}

    

