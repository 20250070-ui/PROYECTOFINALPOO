/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

import javax.swing.JOptionPane;

/**
 *
 * @author ZYLIANNE
 */
public class GestionComprobante
{
    private Comprobante[] arreglo;
    private int contador;
    private GestionReserva gReserva;
    private GestionCancha gCancha;
    private GestionJugador gJugador;

    public GestionComprobante(GestionReserva gReserva, GestionCancha gCancha, GestionJugador gJugador) {
        this.gReserva = gReserva;
        this.gCancha = gCancha;
        this.gJugador = gJugador;
        arreglo = new Comprobante[200]; // SUPUESTO: tamano del arreglo
        contador=0;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    public Comprobante obtenerComprobantePorPosicion(int posicion)
    {
     return arreglo[posicion];
    }
    
    public Comprobante GENERAR(int numReserva, String tipo, String ruc, String razonSocial)
    {
        Reserva RESERVA = gReserva.obtenerReserva(numReserva);
        if (RESERVA == null)
        {
            JOptionPane.showMessageDialog(null, "No existe la reserva");
            return null;
        }
        if (RESERVA.getEstado().equalsIgnoreCase("Finalizada") == false)
        {
            JOptionPane.showMessageDialog(null, "Solo se factura una reserva Finalizada (estado actual: " +
                    RESERVA.getEstado() + ")");
            return null;
        }
        if (RESERVA.getNumComprobante() != 0)
        {
            JOptionPane.showMessageDialog(null, "La reserva ya tiene el comprobante N° " +
                    RESERVA.getNumComprobante());
            return null;
        }
        if (contador >= arreglo.length)
        {
            JOptionPane.showMessageDialog(null, "Cantidad de registros excedida");
            return null;
        }
        if (tipo.equalsIgnoreCase("Factura"))
        {
            if (ruc.length() != 11)
            {
                JOptionPane.showMessageDialog(null, "Para la Factura el RUC debe tener 11 digitos");
                return null;
            }
            if (razonSocial.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Para la Factura la razon social es obligatoria");
                return null;
            }
        }
        
        
        Cancha CANCHA = gCancha.obtenerCancha(RESERVA.getCodCancha());
        Jugador JUGADOR = gJugador.obtenerJugador(RESERVA.getDniTitular());

     
        Comprobante nuevoComprobante  = new Boleta(RESERVA, CANCHA, JUGADOR);

        if (tipo.equalsIgnoreCase("Factura"))
        {
            nuevoComprobante = new Factura(ruc, razonSocial, RESERVA, CANCHA, JUGADOR);
        }
        nuevoComprobante.asignarNumero();
        nuevoComprobante.obtenerDatos();
        nuevoComprobante.obtenerAlquiler();
        nuevoComprobante.obtenerDescuento();
        nuevoComprobante.obtenerServicios();
        nuevoComprobante.obtenerPaquetes();
        nuevoComprobante.obtenerIncidencias();
        nuevoComprobante.obtenerAdelanto();
        
        RESERVA.setNumComprobante(nuevoComprobante.getNumero());
        arreglo[contador] = nuevoComprobante;
        contador++;

        return nuevoComprobante;
    }
    
    public Comprobante obtenerPorReserva(int numReserva)
    {
          for (int i = 0; i < contador; i++)
         {
              if (arreglo[i].getNumReserva() == numReserva)
              {
                return arreglo[i];
               }
         }
         return null;
    }




}
