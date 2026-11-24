/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author ZYLIANNE
 */
public class DetallePaquete implements Facturable
{
    private PaquetesPromo paquete;
    private int cantidad;

    public DetallePaquete(PaquetesPromo paquete, int cantidad) {
        this.paquete = paquete;
        this.cantidad = cantidad;
    }

    public PaquetesPromo getPaquete() {
        return paquete;
    }

    public void setPaquete(PaquetesPromo paquete) {
        this.paquete = paquete;
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
        return paquete.getPrecio() * cantidad; 

    }

}
