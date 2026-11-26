/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

import javax.swing.JOptionPane;

/**
 *
 * @author romina
 */
public class GestionServicio 
{
    private ServiciosAdicionales[] Servicio;
    private int conta;

    public GestionServicio() {
       Servicio = new ServiciosAdicionales[30]; // SUPUESTO: tamaño del arreglo
       conta =0; 
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    public ServiciosAdicionales get(int i) 
     { 
         return Servicio[i];
     }

     public void ingresar(ServiciosAdicionales ref)
 {
    
       boolean rechazado = false;

    if (ref.getCodigo() == null || ref.getCodigo().isEmpty() || ref.getNombre().isEmpty() || ref.getPrecioU() <= 0 || ref.getStock() < 0)
    {
        JOptionPane.showMessageDialog(null, "Codigo, nombre, precio (mayor a 0) y stock " +
                "son obligatorios");
        rechazado = true;
    }

    if (rechazado == false)
    {
        for(int i=0;i<conta;i++)
        {
            if(ref.getCodigo().equalsIgnoreCase(Servicio[i].getCodigo()))
            {
                JOptionPane.showMessageDialog(null, "Codigo de servicio existente");
                rechazado = true;
            }
        }
    }

    if (rechazado == false)
    {
        if (conta < Servicio.length)
        {
            Servicio[conta] = ref;
            conta++;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cantidad de registros excedida");
        }
    }
 }
     
      public void eliminar(String codigo)
    {
        boolean noencontrado = true;
        for(int i=0;i<conta;i++)
        {
           if(Servicio[i].getCodigo().equalsIgnoreCase(codigo))
          {
          Servicio[i].setNombre("Eliminado");
          Servicio[i].setStock(0);
          noencontrado = false;
          JOptionPane.showMessageDialog(null, "Registro de Servicio eliminado");
        }
    }
     if (noencontrado)
     {
         JOptionPane.showMessageDialog(null, "No se encontro registro");
      }
    }
      
    public boolean Modificar(String codigo, String nombre, double precioU, int stock) {
        int pos = buscarPosPorCodigo(codigo);
        if (pos == -1) {
            return false;
        }

        ServiciosAdicionales ser = Servicio[pos];
        ser.setNombre(nombre);
        ser.setPrecioU((float) precioU);
        ser.setStock(stock);
        return true;
    }

    public int buscarPosPorCodigo(String codigo) {
        for (int i = 0; i < conta; i++) {
            if (Servicio[i].getCodigo().equalsIgnoreCase(codigo)) {
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
            if(Servicio[i].getCodigo().equals(codigo))
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
    public ServiciosAdicionales obtenerServicio(String codigo)
    {
    for (int i = 0; i < conta; i++) 
    {
        if (Servicio[i].getCodigo().equalsIgnoreCase(codigo)) 
        {
            return Servicio[i];
        }
            
    }
    return null;
   }
    
     

}
