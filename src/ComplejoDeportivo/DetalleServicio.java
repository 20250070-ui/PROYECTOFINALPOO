/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author ZYLIANNE
 */
public class DetalleServicio implements Facturable
{
    private ServiciosAdicionales servicio;
    private int cantidad;

    public DetalleServicio(ServiciosAdicionales servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    public ServiciosAdicionales getServicio() {
        return servicio;
    }

    public void setServicio(ServiciosAdicionales servicio) {
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public double subtotal() 
    {
        return servicio.getPrecioU() * cantidad; 
    }

}
    

   


