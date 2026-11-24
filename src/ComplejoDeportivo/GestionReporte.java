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
    public String[] columnasOcupacion()
    {
        return new String[]{"Codigo", "Cancha", "Tipo", "Horas reservadas", "Horas disponibles", "% Ocupacion"};
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
   public String[] filaOcupacion(int i, int fechaIni, int fechaFin)
  {
    Cancha CANCHA = gCancha.get(i);
    if (CANCHA.getEstado().equalsIgnoreCase("Eliminado"))
    {
        return null;
    }
    int reservadas = horasReservadas(CANCHA.getCodigo(), fechaIni, fechaFin);
    int disponibles = horasDisponibles(fechaIni, fechaFin);

    String[] datos = new String[6];
    datos[0] = CANCHA.getCodigo();
    datos[1] = CANCHA.getNombre();
    datos[2] = CANCHA.tipo();
    datos[3] = "" + reservadas;
    datos[4] = "" + disponibles;
    datos[5] = "" + porcentajeOcupacion(reservadas, disponibles) + " %";
    return datos;
   }
   public String[] filaTotalOcupacion(int fechaIni, int fechaFin)
  {
    int reservadas = 0;
    int disponibles = 0;
    for (int i = 0; i < gCancha.getConta(); i++)
    {
        Cancha CANCHA = gCancha.get(i);
        if (CANCHA.getEstado().equalsIgnoreCase("Eliminado") == false)
        {
            reservadas += horasReservadas(CANCHA.getCodigo(), fechaIni, fechaFin);
            disponibles += horasDisponibles(fechaIni, fechaFin);
        }
    }
    String[] datos = new String[6];
    datos[0] = "TOTAL";
    datos[1] = "";
    datos[2] = "";
    datos[3] = "" + reservadas;
    datos[4] = "" + disponibles;
    datos[5] = "" + porcentajeOcupacion(reservadas, disponibles) + " %";
    return datos;
  }
    public String[] columnasProductividad()
    {
        return new String[]{"DNI", "Empleado", "Rol", "Reservas registradas", "Partidos supervisados"};
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
   public String[] filaProductividad(int i)
  {
    Empleado EMPLEADO = gEmpleado.get(i);
    if (EMPLEADO.getNombre().equalsIgnoreCase("Eliminado") || EMPLEADO.rol().equalsIgnoreCase("Administrador"))
    {
        return null;
    }
    String[] datos = new String[5];
    datos[0] = EMPLEADO.getDni();
    datos[1] = EMPLEADO.getNombre() + " " + EMPLEADO.getApellido();
    datos[2] = EMPLEADO.rol();
    datos[3] = "" + reservasRegistradas(EMPLEADO.getDni());
    datos[4] = "" + partidosSupervisados(EMPLEADO.getDni());
    return datos;
  }
   public String[] filaTotalProductividad()
   {
    int registradas = 0;
    int supervisados = 0;
    for (int i = 0; i < gEmpleado.getConta(); i++)
    {
        Empleado EMPLEADO = gEmpleado.get(i);
        if (EMPLEADO.getNombre().equalsIgnoreCase("Eliminado") == false)
        {
            if (EMPLEADO.rol().equalsIgnoreCase("Administrador") == false)
            {
                registradas += reservasRegistradas(EMPLEADO.getDni());
                supervisados += partidosSupervisados(EMPLEADO.getDni());
            }
        }
    }
    String[] datos = new String[5];
    datos[0] = "TOTAL";
    datos[1] = "";
    datos[2] = "";
    datos[3] = "" + registradas;
    datos[4] = "" + supervisados;
    return datos;
   }
   
   public String[] columnasTopJugadores()
    {
        return new String[]{"Puesto", "DNI", "Jugador", "Tipo", "Reservas finalizadas"};
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
   public String[] filaTopJugadores(int i)
    {
        String[] datos = new String[5];
        datos[0] = "" + (i + 1);
        datos[1] = arreglo[i].getDni();
        datos[2] = arreglo[i].getNombre() + " " + arreglo[i].getApellido();
        datos[3] = arreglo[i].getTipo();
        datos[4] = "" + arreglo[i].getReservas();
        return datos;
    }
   public String[] filaTotalTopJugadores()
    {
        int total = 0;
        for (int i = 0; i < contador; i++)
        {
            total += arreglo[i].getReservas();
        }
        String[] datos = new String[5];
        datos[0] = "TOTAL";
        datos[1] = "";
        datos[2] = "";
        datos[3] = "";
        datos[4] = "" + total;
        return datos;
    }
    public String[] columnasIngresos()
    {
        return new String[]{"N° Comprobante", "Tipo", "Fecha", "Alquiler (S/)", "Servicios (S/)","Paquetes (S/)", "Incidencias (S/)", "Subtotal (S/)", "IGV (S/)", "Total (S/)"};
    }
    private boolean estaDentroDelRango(Comprobante COMPROBANTE, int fechaIni, int fechaFin)
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
    public String[] filaIngresos(int i, int fechaIni, int fechaFin)
    {
    Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
    if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin) == false)
    {
        return null;
    }
    String[] datos = new String[10];
    datos[0] = "" + COMPROBANTE.getNumero();
    datos[1] = COMPROBANTE.tipo();
    datos[2] = Fecha.mostrar(COMPROBANTE.getFecha());
    datos[3] = "" + (COMPROBANTE.getAlquiler() - COMPROBANTE.getDescuento());
    datos[4] = "" + COMPROBANTE.getServicios();
    datos[5] = "" + COMPROBANTE.getPaquetes();
    datos[6] = "" + COMPROBANTE.getIncidencias();
    datos[7] = "" + COMPROBANTE.subtotal();
    datos[8] = "" + COMPROBANTE.IGV();
    datos[9] = "" + COMPROBANTE.total();
    return datos;
    }
    
    public String[] filaTotalIngresos(int fechaIni, int fechaFin)
    {
    double alquiler = 0;
    double servicios = 0;
    double paquetes = 0;
    double incidencias = 0;
    double subtotal = 0;
    double igv = 0;
    double total = 0;
    for (int i = 0; i < gComprobante.getContador(); i++)
    {
        Comprobante COMPROBANTE = gComprobante.obtenerComprobantePorPosicion(i);
        if (estaDentroDelRango(COMPROBANTE, fechaIni, fechaFin))
        {
            alquiler += COMPROBANTE.getAlquiler() - COMPROBANTE.getDescuento();
            servicios += COMPROBANTE.getServicios();
            paquetes += COMPROBANTE.getPaquetes();
            incidencias += COMPROBANTE.getIncidencias();
            subtotal += COMPROBANTE.subtotal();
            igv += COMPROBANTE.IGV();
            total += COMPROBANTE.total();
        }
    }
    String[] datos = new String[10];
    datos[0] = "TOTAL";
    datos[1] = "";
    datos[2] = "";
    datos[3] = "" + alquiler;
    datos[4] = "" + servicios;
    datos[5] = "" + paquetes;
    datos[6] = "" + incidencias;
    datos[7] = "" + subtotal;
    datos[8] = "" + igv;
    datos[9] = "" + total;
    return datos;
    }


    
}
