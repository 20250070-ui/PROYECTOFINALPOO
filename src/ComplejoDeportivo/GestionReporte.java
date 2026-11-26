/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author ZYLIANNE
 */
public class GestionReporte 
{
    private GestionReserva gReserva;
    private GestionCancha gCancha;
    private GestionEmpleado gEmpleado;
    private GestionJugador gJugador;
    private GestionComprobante gComprobante;
    private Jugador[] arreglo;  
    private int contador;

    public GestionReporte(GestionReserva gReserva, GestionCancha gCancha, GestionEmpleado gEmpleado, GestionJugador gJugador, GestionComprobante gComprobante) {
        this.gReserva = gReserva;
        this.gCancha = gCancha;
        this.gEmpleado = gEmpleado;
        this.gJugador = gJugador;
        this.gComprobante = gComprobante;
        

    }

    public GestionReserva getgReserva() {
        return gReserva;
    }

    public void setgReserva(GestionReserva gReserva) {
        this.gReserva = gReserva;
    }

    public GestionCancha getgCancha() {
        return gCancha;
    }

    public void setgCancha(GestionCancha gCancha) {
        this.gCancha = gCancha;
    }

    public GestionEmpleado getgEmpleado() {
        return gEmpleado;
    }

    public void setgEmpleado(GestionEmpleado gEmpleado) {
        this.gEmpleado = gEmpleado;
    }

    public GestionJugador getgJugador() {
        return gJugador;
    }

    public void setgJugador(GestionJugador gJugador) {
        this.gJugador = gJugador;
    }

    public GestionComprobante getgComprobante() {
        return gComprobante;
    }

    public void setgComprobante(GestionComprobante gComprobante) {
        this.gComprobante = gComprobante;
    }

    public Jugador[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Jugador[] arreglo) {
        this.arreglo = arreglo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    public boolean estaDentroDelRango(Comprobante COMPROBANTE, int fechaIni, int fechaFin)
    {
    if (COMPROBANTE.getFecha() >= fechaIni)
    {
        if (COMPROBANTE.getFecha() <= fechaFin)
        {
            return true;
        }
    } 
    return false;
   }
    
    public int horasReservadas(String codCancha, int fechaIni, int fechaFin)
   {
    int horas = 0;
    for (int i = 0; i < gReserva.getContador(); i++)
    {
        Reserva RESERVA = gReserva.obtenerreservaPorPosicion(i);
        
        if (RESERVA.getCodCancha().equalsIgnoreCase(codCancha))
        {
            if (RESERVA.getEstado().equalsIgnoreCase("Cancelada") == false)
            {
                if (RESERVA.getFecha() >= fechaIni)
                {
                    if (RESERVA.getFecha() <= fechaFin)
                    {
                        horas += RESERVA.getDuracion();
                    }
                }
            }
        }
    }
       return horas;
    }
    public int horasDisponibles(int fechaIni, int fechaFin)
    {
        int dias = Fecha.aDias(fechaFin) - Fecha.aDias(fechaIni) + 1;
        return dias * (GestionReserva.horadecierre - GestionReserva.horadeapertura);
    }
    
    public double porcentajeOcupacion(int reservadas, int disponibles)
    {
        if (disponibles == 0)
        {
            return 0;
        }
        return reservadas * 100.0 / disponibles;
    }
   
 
    public int reservasRegistradas(String dniRecepcionista)
   {
    int total = 0;
    for (int i = 0; i < gReserva.getContador(); i++)
    {
        if (gReserva.obtenerreservaPorPosicion(i).getDniRecepcionista().equals(dniRecepcionista))
        {
            total++;
        }
    }
    return total;
   }
    
    public int partidosSupervisados(String dniEncargado)
    {
        int total = 0;
        for (int i = 0; i < gReserva.getContador(); i++)
        {
            if (gReserva.obtenerreservaPorPosicion(i).getDniEncargado().equals(dniEncargado))
            {
                total++;
            }
        }
        return total;
    }
  
  
   
   public void Ordenar()
  {
      arreglo = new Jugador[gJugador.getConta()];
      contador=0;
   
    for (int i = 0; i < gJugador.getConta(); i++)
    {
        Jugador JUGADOR = gJugador.get(i);
        if (JUGADOR.getNombre().equalsIgnoreCase("Eliminado") == false)
        {
            arreglo[contador] = JUGADOR;
            contador++;
        }
    }

    Jugador aux;
    for (int i = 0; i < contador - 1; i++)
    {
     for (int j = i + 1; j < contador; j++)
     {
         if (arreglo[j].getReservas() > arreglo[i].getReservas())
         {
            aux = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = aux;
         }
     }
    }
      
    
   }
    public int totalHorasReservadas(int fechaIni, int fechaFin)
    {
        int total = 0;
        for (int i = 0; i < gCancha.getConta(); i++)
        {
            Cancha CANCHA = gCancha.get(i);
            if (CANCHA.getEstado().equalsIgnoreCase("Eliminado") == false)
            {
                total += horasReservadas(CANCHA.getCodigo(), fechaIni, fechaFin);
            }
        }
        return total;
    }

    public int totalHorasDisponibles(int fechaIni, int fechaFin)
    {
        int total = 0;
        for (int i = 0; i < gCancha.getConta(); i++)
        {
            if (gCancha.get(i).getEstado().equalsIgnoreCase("Eliminado") == false)
            {
                total += horasDisponibles(fechaIni, fechaFin);
            }
        }
        return total;
    }

    public int totalReservasRegistradas()
    {
        int total = 0;
        for (int i = 0; i < gEmpleado.getConta(); i++)
        {
            Empleado EMPLEADO = gEmpleado.get(i);
            if (EMPLEADO.getNombre().equalsIgnoreCase("Eliminado") == false)
            {
                if (EMPLEADO.rol().equalsIgnoreCase("Administrador") == false)
                {
                    total += reservasRegistradas(EMPLEADO.getDni());
                }
            }
        }
        return total;
    }

    public int totalPartidosSupervisados()
    {
        int total = 0;
        for (int i = 0; i < gEmpleado.getConta(); i++)
        {
            Empleado EMPLEADO = gEmpleado.get(i);
            if (EMPLEADO.getNombre().equalsIgnoreCase("Eliminado") == false)
            {
                if (EMPLEADO.rol().equalsIgnoreCase("Administrador") == false)
                {
                    total += partidosSupervisados(EMPLEADO.getDni());
                }
            }
        }
        return total;
    }
    public int totalReservasFinalizadas()
    {
        int total = 0;
        for (int i = 0; i < contador; i++)
        {
            total += arreglo[i].getReservas();
        }
        return total;
    }
    public double totalAlquiler(int fechaIni, int fechaFin)
    {
        double total = 0;
        for (int i = 0; i < gComprobante.getContador(); i++)
        {
            Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
            if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin))
            {
                total += COMPROBANTE.getAlquiler() - COMPROBANTE.getDescuento();
            }
        }
        return total;
    }
    public double totalServicios(int fechaIni, int fechaFin)
    {
        double total = 0;
        for (int i = 0; i < gComprobante.getContador(); i++)
        {
            Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
            if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin))
            {
                total += COMPROBANTE.getServicios();
            }
        }
        return total;
    }
    public double totalPaquetes(int fechaIni, int fechaFin)
    {
        double total = 0;
        for (int i = 0; i < gComprobante.getContador(); i++)
        {
            Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
            if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin))
            {
                total += COMPROBANTE.getPaquetes();
            }
        }
        return total;
    }

    public double totalIncidencias(int fechaIni, int fechaFin)
    {
        double total = 0;
        for (int i = 0; i < gComprobante.getContador(); i++)
        {
            Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
            if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin))
            {
                total += COMPROBANTE.getIncidencias();
            }
        }
        return total;
    }

    public double totalSubtotal(int fechaIni, int fechaFin)
    {
        double total = 0;
        for (int i = 0; i < gComprobante.getContador(); i++)
        {
            Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
            if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin))
            {
                total += COMPROBANTE.subtotal();
            }
        }
        return total;
    }

    public double totalIGV(int fechaIni, int fechaFin)
    {
        double total = 0;
        for (int i = 0; i < gComprobante.getContador(); i++)
        {
            Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
            if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin))
            {
                total += COMPROBANTE.IGV();
            }
        }
        return total;
    }
    public double totalGeneral(int fechaIni, int fechaFin)
    {
        double total = 0;
        for (int i = 0; i < gComprobante.getContador(); i++)
        {
            Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
            if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin))
            {
                total += COMPROBANTE.total();
            }
        }
        return total;
    }
  
  
    
    
    
    


    
}
