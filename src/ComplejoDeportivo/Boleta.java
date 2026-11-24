/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author ZYLIANNE
 */
public class Boleta extends Comprobante
{

    public Boleta(Reserva reservas, Cancha canchas, Jugador jugadores) {
        super(reservas, canchas, jugadores);
    }

    

    @Override
    public String tipo() 
    {
        return "Boleta";

    }

    @Override
    public String datosCliente()
    {
        return "Cliente: " + nombreCliente + "   DNI: " + dniTitular;
        
    }
    
    
}
