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
public class GestionReserva 
{
    private Reserva[] arreglo;
    private int contador;
    private GestionCancha gCancha;
    private GestionJugador gJugador;
    public static final int horadeapertura = 8;
    public static final int horadecierre = 23;
    

    public GestionReserva(GestionCancha gCancha, GestionJugador gJugador) 
    {
        this.gCancha = gCancha;
        this.gJugador = gJugador;
        arreglo=new Reserva[200];// SUPUESTO: tamano del arreglo
        contador=0;
    }


    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    public Reserva obtenerreservaPorPosicion(int i) 
    { 
        return arreglo[i];
    }
    
    public void BUSCAR(int numero)
    {
        
        boolean encontrar=false;
        for(int i=0;i<contador;i++)
        {
            if (arreglo[i].getNumero() == numero)

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
    public Reserva obtenerReserva(int numero) 
    {
        for (int i = 0; i < contador; i++) 
        {
            if (arreglo[i].getNumero() == numero) 
            {
                return arreglo[i];
            }
        }
        return null;
    }

    
    private String HORA(int hora)
    {
      if (hora < 10)
      {
         return "0" + hora + ":00";
      }
      else
      {
        return hora + ":00";
      }
    }
    public boolean VALIDAR(Reserva referencia)
    {
        Cancha CANCHA  = gCancha.obtenerCancha(referencia.getCodCancha());
        Jugador titular = gJugador.obtenerJugador(referencia.getDniTitular());

        if (titular == null || titular.getNombre().equals("Eliminado"))
        {
            JOptionPane.showMessageDialog(null, "El jugador titular no esta registrado");
            return false;
        }
        if (CANCHA  == null)
        {
            JOptionPane.showMessageDialog(null, "La cancha " + referencia.getCodCancha() + " no existe");
            return false;
        }
        if (CANCHA.puedeReservarse()==false)
        {
            JOptionPane.showMessageDialog(null, "La cancha " + CANCHA.getCodigo() + " esta " + CANCHA .getEstado() + " y no puede reservarse");
            return false;
        }
        if (Fecha.esValida(referencia.getFecha())==false)
        {
            JOptionPane.showMessageDialog(null, "La fecha ingresada no es valida");
            return false;
        }
        if (referencia.getDuracion() < 1 || referencia.getDuracion() > 3)
        {
            JOptionPane.showMessageDialog(null, "La duracion debe ser de 1 a 3 horas");
            return false;
        }

        if (referencia.getHoraInicio() < horadeapertura || referencia.getHoraFin() > horadecierre)
        {
            JOptionPane.showMessageDialog(null, "El horario debe estar dentro de la atencion (" + HORA(horadeapertura) + " a " + HORA(horadecierre) + ")");
            return false;
        }
        for (int i = 0; i < contador; i++) 
        {
            Reserva otra = arreglo[i];
            if (otra.getCodCancha().equalsIgnoreCase(referencia.getCodCancha())) 
            {
                if (otra.getFecha() == referencia.getFecha()) 
                {
                    if (otra.getEstado().equals("Cancelada") == false) 
                    {
                        if (referencia.getHoraInicio() < otra.getHoraFin()) 
                        {
                            if (otra.getHoraInicio() < referencia.getHoraFin()) 
                            {
                                JOptionPane.showMessageDialog(null, "La cancha " + CANCHA.getCodigo() + " ya esta reservada de "
                                        + HORA(otra.getHoraInicio()) + " a " + HORA(otra.getHoraFin()));
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (referencia.numParticipantes() > CANCHA.getCapMax()) 
        {
            JOptionPane.showMessageDialog(null, "El numero de particpantes (" + referencia.numParticipantes()
                    + ") superan la capacidad de la cancha (" + CANCHA.getCapMax() + ")");
            return false;
        }
        for (int i = 0; i < referencia.getContadorServicios(); i++) 
        {
            if (referencia.Servicio(i).getServicio().hayStock(referencia.Servicio(i).getCantidad()) == false) 
            {
                JOptionPane.showMessageDialog(null, "Stock insuficiente de " + referencia.Servicio(i).getServicio().getNombre()
                        + " (disponible: " + referencia.Servicio(i).getServicio().getStock() + ")");
                return false;
            }
        }
        for (int i = 0; i < referencia.getContadorPaquetes(); i++) 
        {
            int contador2;
            ServiciosAdicionales[] arreglo2 = referencia.Paquete(i).getPaquete().getServicios();
            
            for (contador2 = 0; contador2 < arreglo2.length; contador2++) 
            {
                if (arreglo2[contador2].hayStock(referencia.Paquete(i).getCantidad()) == false) 
                {
                    JOptionPane.showMessageDialog(null, "Stock insuficiente de " + arreglo2[contador2].getNombre()
                            + " para el paquete " + referencia.Paquete(i).getPaquete().getNombre());
                    return false;
                }
            }
        }

    return true;
    }
       
    public boolean REGISTRAR(Reserva referencia, String dniRecepcionista) 
    {
        if (VALIDAR(referencia) == false) 
        {
            return false;
        }
        if (contador >= arreglo.length) 
        {
            JOptionPane.showMessageDialog(null, "Cantidad de registros excedida");
            return false;
        }

        referencia.asignarNumero();
        referencia.setDniRecepcionista(dniRecepcionista);

        for (int i = 0; i < referencia.getContadorServicios(); i++) 
        {
            referencia.Servicio(i).getServicio().descontarStock(referencia.Servicio(i).getCantidad());
        }
        for (int i = 0; i < referencia.getContadorPaquetes(); i++) 
        {
            int contador2;
            ServiciosAdicionales[] arreglo2 = referencia.Paquete(i).getPaquete().getServicios();
            for (contador2 = 0; contador2 < arreglo2.length; contador2++) 
            {
                arreglo2[contador2].descontarStock(referencia.Paquete(i).getCantidad());
            }
        }

        referencia.agregarHistorial("Pendiente");
        arreglo[contador] = referencia;
        contador++;
        JOptionPane.showMessageDialog(null, "Reserva " + referencia.getNumero() + " registrada en estado pendiente");
        return true;
    }
    
    public boolean CONFIRMAR(int numero) 
    {
        Reserva referencia = obtenerReserva(numero);
        if (referencia != null) 
        {
            if (referencia.validarEstado("Confirmada")) 
            {
                Cancha CANCHA = gCancha.obtenerCancha(referencia.getCodCancha());
                referencia.setAdelanto(referencia.calcularAlquiler(CANCHA) * 0.50); // SUPUESTO: 50% del alquiler
                referencia.setEstadoAdelanto("Pagado");
                referencia.cambiarEstado("Confirmada");
                JOptionPane.showMessageDialog(null, "Reserva confirmada. Adelanto registrado: " + referencia.getAdelanto());
                return true;
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "La reserva esta " + referencia.getEstado() + " y no se puede confirmar");
                return false;
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "No existe la reserva");
            return false;
        }
    }
    
    public boolean INICIAR(int numero, String dniEncargado) 
    {
        Reserva referencia = obtenerReserva(numero);
        if (referencia != null) 
        {
            if (referencia.validarEstado("En Juego")) 
            {
                Cancha CANCHA = gCancha.obtenerCancha(referencia.getCodCancha());
                referencia.setDniEncargado(dniEncargado);
                referencia.cambiarEstado("En Juego");
                if (CANCHA.getEstado().equals("Eliminado") == false)
                {
                    CANCHA.setEstado("Ocupada");
                }
                JOptionPane.showMessageDialog(null, "Partido iniciado. La cancha " + CANCHA.getCodigo() + " esta ocupada");
                return true;
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "La reserva esta " + referencia.getEstado() 
                        + " y no se puede iniciar el proceso de reserva");
                return false;
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "No existe la reserva");
            return false;
        }
    }
    
    public boolean FINALIZAR(int numero) 
    {
        Reserva referencia = obtenerReserva(numero);
        if (referencia != null) 
        {
            if (referencia.validarEstado("Finalizada")) 
            {
                Cancha CANCHA = gCancha.obtenerCancha(referencia.getCodCancha());
                referencia.cambiarEstado("Finalizada");
                if (CANCHA.getEstado().equals("Eliminado") == false)
                {
                    CANCHA.setEstado("Disponible");
                }
                gJugador.registrarFinalizada(referencia.getDniTitular()); 
                JOptionPane.showMessageDialog(null, "Partido finalizado. La cancha " + CANCHA.getCodigo() + " esta disponible");
                return true;
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "La reserva esta " + referencia.getEstado() + " y no se puede finalizar");
                return false;
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "No existe la reserva");
            return false;
        }
    }
    
    public boolean CANCELAR(int numero, int fechaActual, int horaActual) 
    {
        Reserva referencia = obtenerReserva(numero);
        if (referencia != null) 
        {
            if (referencia.validarEstado("Cancelada")) 
            {
                String mensaje = "Reserva cancelada.";
                int horasFaltantes = (Fecha.aDias(referencia.getFecha()) - Fecha.aDias(fechaActual)) * 24
                        + (referencia.getHoraInicio() - horaActual);

                if (referencia.getEstado().equals("Confirmada")) 
                {
                    if (horasFaltantes >= 24) 
                    {
                        referencia.setEstadoAdelanto("Devuelto");
                        mensaje = mensaje + " Se devuelve el adelanto.";
                    } 
                    else 
                    {
                        referencia.setEstadoAdelanto("Retenido");
                        mensaje = mensaje + " El adelanto queda retenido porque no se cancelo con 24 horas o mas de anticipacion ";
                    }
                }
                referencia.cambiarEstado("Cancelada");

                for (int i = 0; i < referencia.getContadorServicios(); i++) 
                {
                    referencia.Servicio(i).getServicio().reponerStock(referencia.Servicio(i).getCantidad());
                }
                for (int i = 0; i < referencia.getContadorPaquetes(); i++) 
                {
                    int contador2;
                    ServiciosAdicionales[] arreglo2 = referencia.Paquete(i).getPaquete().getServicios();
                    for (contador2 = 0; contador2 < arreglo2.length; contador2++) 
                    {
                        arreglo2[contador2].reponerStock(referencia.Paquete(i).getCantidad());
                    }
                }

                JOptionPane.showMessageDialog(null, mensaje);
                return true;
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "La reserva esta " + referencia.getEstado() + " y no se puede cancelar");
                return false;
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "No existe la reserva");
            return false;
        }
    }
    
    public boolean OCUPADA(String codCancha, int fecha, int hora) 
    {
        for (int i = 0; i < contador; i++) 
        {
            if (arreglo[i].getCodCancha().equalsIgnoreCase(codCancha)) 
            {
                if (arreglo[i].getFecha() == fecha) 
                {
                    if (arreglo[i].getEstado().equals("Cancelada") == false) 
                    {
                        if (hora >= arreglo[i].getHoraInicio() && hora < arreglo[i].getHoraFin()) 
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
   public boolean INCIDENCIA(int numero, String descripcion, double monto)
   {
    Reserva referencia = obtenerReserva(numero);
    if (referencia == null)
    {
        JOptionPane.showMessageDialog(null, "No existe la reserva");
        return false;
    }
    if (referencia.getEstado().equals("En Juego") == false)
    {
        JOptionPane.showMessageDialog(null, "Solo se registran incidencias en una reserva en juego (estado actual: "
                + referencia.getEstado() + ")");
        return false;
    }
    if (descripcion.equals("") || monto < 0)
    {
        JOptionPane.showMessageDialog(null, "Ingrese una descripcion y un monto valido (0 o mayor)");
        return false;
    }
    if (referencia.registrarIncidencia(descripcion, monto) == false)
    {
        JOptionPane.showMessageDialog(null, "Cantidad de incidencias excedida");
        return false;
    }
    JOptionPane.showMessageDialog(null, "Incidencia registrada");
    return true;
   }

}
