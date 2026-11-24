/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author ZYLIANE
 */
public class Factura extends Comprobante
{
    private String ruc, razonSocial;

    public Factura(String ruc, String razonSocial, Reserva reservas, Cancha canchas, Jugador jugadores) {
        super(reservas, canchas, jugadores);
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }

   

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String tipo() 
    {
        return "Factura";
        
    }

    @Override
    public String datosCliente() 
    {
        return "Razon social: " + razonSocial + "   RUC: " + ruc;
        
    }
    
    //prueba
    
}
