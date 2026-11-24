/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author ZYLIANNE
 */

public class Reserva
{
    private static int correlativo;
    private int numero, horaInicio,horaFin, duracion, numComprobante, fecha;
    private String dniTitular, codCancha, estado, estadoAdelanto;
    private String dniRecepcionista, dniEncargado;
    private double adelanto;
    private String[] dniParticipantes;
    private int contadorParticipantes;
    private DetalleServicio[] servicios;
    private int contadorServicios;
    private DetallePaquete[] paquetes;
    private int contadorPaquetes;
    private String[] historial;
    private int contadorHistorial;
    private String[] descripcionIncidencia;
    private double[] montoIncidencia;
    private int contadorIncidencias;

    public Reserva(String dniTitular, String codCancha, int fecha, int horaInicio, int duracion)
    {
        this.numero=0;
        this.dniTitular = dniTitular;
        this.codCancha = codCancha;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.estado = "Pendiente";
        this.estadoAdelanto = "Sin adelanto";
        this.dniRecepcionista = "";
        this.dniEncargado = "";
        this.dniParticipantes = new String[30];
        this.servicios = new DetalleServicio[10];
        this.paquetes = new DetallePaquete[10];
        this.historial = new String[20];
        this.descripcionIncidencia = new String[10];
        this.montoIncidencia = new double[10];
    }

    public int getHoraFin() {
        return horaInicio + duracion;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

   

    public int getContadorHistorial() {
        return contadorHistorial;
    }

    public void setContadorHistorial(int contadorHistorial) {
        this.contadorHistorial = contadorHistorial;
    }

    public int getContadorIncidencias() {
        return contadorIncidencias;
    }

    public void setContadorIncidencias(int contadorIncidencias) {
        this.contadorIncidencias = contadorIncidencias;
    }

    public int getContadorServicios() {
        return contadorServicios;
    }

    public void setContadorServicios(int contadorServicios) {
        this.contadorServicios = contadorServicios;
    }

    public void asignarNumero()
    {
        correlativo++;
        this.numero = correlativo;
    }

    public static int getCorrelativo() {
        return correlativo;
    }

    public static void setCorrelativo(int correlativo) {
        Reserva.correlativo = correlativo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;

    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(int numComprobante) {
        this.numComprobante = numComprobante;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getDniTitular() {
        return dniTitular;
    }

    public void setDniTitular(String dniTitular) {
        this.dniTitular = dniTitular;
    }

    public String getCodCancha() {
        return codCancha;
    }

    public void setCodCancha(String codCancha) {
        this.codCancha = codCancha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoAdelanto() {
        return estadoAdelanto;
    }

    public void setEstadoAdelanto(String estadoAdelanto) {
        this.estadoAdelanto = estadoAdelanto;
    }

    public String getDniRecepcionista() {
        return dniRecepcionista;
    }

    public void setDniRecepcionista(String dniRecepcionista) {
        this.dniRecepcionista = dniRecepcionista;
    }

    public String getDniEncargado() {
        return dniEncargado;
    }

    public void setDniEncargado(String dniEncargado) {
        this.dniEncargado = dniEncargado;
    }

    public double getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(double adelanto) {
        this.adelanto = adelanto;
    }

    public String[] getDniParticipantes() {
        return dniParticipantes;
    }

    public void setDniParticipantes(String[] dniParticipantes) {
        this.dniParticipantes = dniParticipantes;
    }

    public int getContadorParticipantes() {
        return contadorParticipantes;
    }

    

    public DetalleServicio[] getServicios() {
        return servicios;
    }

    public void setServicios(DetalleServicio[] servicios) {
        this.servicios = servicios;
    }

    public DetallePaquete[] getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(DetallePaquete[] paquetes) {
        this.paquetes = paquetes;
    }

    public String[] getHistorial() {
        return historial;
    }

    public int getContadorPaquetes() {
        return contadorPaquetes;
    }

    public void setContadorPaquetes(int contadorPaquetes) {
        this.contadorPaquetes = contadorPaquetes;
    }

    public void setHistorial(String[] historial) {
        this.historial = historial;
    }

    public String[] getDescripcionIncidencia() {
        return descripcionIncidencia;
    }

    public void setDescripcionIncidencia(String[] descripcionIncidencia) {
        this.descripcionIncidencia = descripcionIncidencia;
    }

    public double[] getMontoIncidencia() {
        return montoIncidencia;
    }

    public void setMontoIncidencia(double[] montoIncidencia) {
        this.montoIncidencia = montoIncidencia;
    }
    public String Participante(int i) 
    { 
        return dniParticipantes[i];
    }
    public DetalleServicio Servicio(int i) 
    { 
        return servicios[i];
    }
    public DetallePaquete Paquete(int i)
    { 
        return paquetes[i]; 
    }
    public String DescripcionIncidencia(int i) 
    { 
        return descripcionIncidencia[i]; 
    }
    public double MontoIncidencia(int i)
    { 
        return montoIncidencia[i]; 
    }
    
    public boolean agregarParticipante(String dni)
    {
        if (contadorParticipantes < dniParticipantes.length)
        {
            dniParticipantes[contadorParticipantes] = dni;
            contadorParticipantes++;
            return true;
        }
        return false;
    }

    public int numParticipantes()
    { 
        return contadorParticipantes; 
    }

    public boolean agregarServicio(ServiciosAdicionales ref, int cantidad)
    {
        if (contadorServicios < servicios.length && cantidad > 0)
        {
            servicios[contadorServicios] = new DetalleServicio(ref, cantidad);
            contadorServicios++;
            return true;
        }
        return false;
    }

   

    public boolean agregarPaquete(PaquetesPromo ref2, int cantidad)
    {
        if (contadorPaquetes < paquetes.length && cantidad > 0)
        {
            paquetes[contadorPaquetes] = new DetallePaquete(ref2, cantidad);
            contadorPaquetes++;
            return true;
        }
        return false;
    }


    public void agregarHistorial(String texto)
    {
        if (contadorHistorial < historial.length)
        {
            historial[contadorHistorial] = texto;
            contadorHistorial++;
        }
    }

    public boolean registrarIncidencia(String descripcion, double monto)
    {
        if (contadorIncidencias < descripcionIncidencia.length)
        {
            descripcionIncidencia[contadorIncidencias] = descripcion;
            montoIncidencia[contadorIncidencias] = monto;
            contadorIncidencias++;
            return true;
        }
        return false;
    }

   

    public double totalIncidencias()
    {
        double total = 0;
        for (int i = 0; i<contadorIncidencias; i++)
        {
            total += montoIncidencia[i];
        }
        return total;
    }

  public double calcularAlquiler(Cancha ref3)
  {
    double alquiler = 0;
    for (int h = horaInicio; h < getHoraFin(); h++)
    {
        alquiler += ref3.tarifa(h);
    }
    return alquiler;
  }

    public boolean validarEstado(String nuevo)
{
    if (estado.equals("Pendiente"))
    {
        if (nuevo.equals("Confirmada") || nuevo.equals("Cancelada"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else if (estado.equals("Confirmada"))
    {
        if (nuevo.equals("En Juego") || nuevo.equals("Cancelada"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else if (estado.equals("En Juego"))
    {
        if (nuevo.equals("Finalizada"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    else
    {
        return false; 
    }
}

   public boolean cambiarEstado(String nuevoestado)
{
    if (validarEstado(nuevoestado))
    {
        estado = nuevoestado;
        if (contadorHistorial < historial.length)
        {
            historial[contadorHistorial] = nuevoestado;
            contadorHistorial++;
        }
        return true;
    }
    else
    {
        return false;
    }
  }
}
