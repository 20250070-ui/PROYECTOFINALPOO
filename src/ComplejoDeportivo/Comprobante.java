/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author MARTIN
 */
public abstract class Comprobante 
{
    protected int numero, numReserva, fecha;
    protected String dniTitular, nombreCliente, nombreCancha,detalleServicios, detallePaquetes, detalleIncidencias;
    protected double alquiler, descuento, servicios, paquetes, incidencias, adelanto;
    private static int correlativo;
    public static final double IGV = 0.18;
    protected Reserva reservas;
    protected Cancha canchas;
    protected Jugador jugadores;

    public Comprobante(Reserva reservas, Cancha canchas, Jugador jugadores) {
        this.reservas = reservas;
        this.canchas = canchas;
        this.jugadores = jugadores;
    }

    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCancha() {
        return nombreCancha;
    }

    public void setNombreCancha(String nombreCancha) {
        this.nombreCancha = nombreCancha;
    }

    public String getDetalleServicios() {
        return detalleServicios;
    }

    public void setDetalleServicios(String detalleServicios) {
        this.detalleServicios = detalleServicios;
    }

    public String getDetallePaquetes() {
        return detallePaquetes;
    }

    public void setDetallePaquetes(String detallePaquetes) {
        this.detallePaquetes = detallePaquetes;
    }

    public String getDetalleIncidencias() {
        return detalleIncidencias;
    }

    public void setDetalleIncidencias(String detalleIncidencias) {
        this.detalleIncidencias = detalleIncidencias;
    }

    public double getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(double alquiler) {
        this.alquiler = alquiler;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getServicios() {
        return servicios;
    }

    public void setServicios(double servicios) {
        this.servicios = servicios;
    }

    public double getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(double paquetes) {
        this.paquetes = paquetes;
    }

    public double getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(double incidencias) {
        this.incidencias = incidencias;
    }

    public double getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(double adelanto) {
        this.adelanto = adelanto;
    }

    public static int getCorrelativo() {
        return correlativo;
    }

    public static void setCorrelativo(int correlativo) {
        Comprobante.correlativo = correlativo;
    }

    public Reserva getReservas() {
        return reservas;
    }

    public void setReservas(Reserva reservas) {
        this.reservas = reservas;
    }

    public Cancha getCanchas() {
        return canchas;
    }

    public void setCanchas(Cancha canchas) {
        this.canchas = canchas;
    }

    public Jugador getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador jugadores) {
        this.jugadores = jugadores;
    }
    
    public void obtenerAlquiler()
    {
        this.alquiler = reservas.calcularAlquiler(canchas);
    }
    
    public void obtenerDescuento()
    {
        this.descuento = jugadores.Descuento(this.alquiler);
    }
    protected String dinero(double valor)
    {
        return String.format("%.2f", valor);
    }
    
    public void obtenerServicios()
    {
        this.servicios = 0;
        this.detalleServicios = "";
        for (int i = 0; i < reservas.getContadorServicios(); i++)
        {
            Facturable itemServicio = reservas.Servicio(i);
            this.servicios += itemServicio.subtotal();
            this.detalleServicios += "  " + reservas.Servicio(i).getServicio().getNombre() + " (cantidad: "
                    + reservas.Servicio(i).getCantidad() + ") = S/ " + itemServicio.subtotal() + "\n";
        }
    }
    
    public void obtenerPaquetes()
    {
        this.paquetes = 0;
        this.detallePaquetes = "";
        for (int i = 0; i < reservas.getContadorPaquetes(); i++)
        {
            Facturable itemPaquete = reservas.Paquete(i);
            this.paquetes += itemPaquete.subtotal();
            this.detallePaquetes += "  " + reservas.Paquete(i).getPaquete().getNombre() + " (cantidad: "
                    + reservas.Paquete(i).getCantidad() + ") = S/ " + itemPaquete.subtotal() + "\n";
        }
    }
    public void obtenerIncidencias()
    {
        this.incidencias = reservas.totalIncidencias();
        this.detalleIncidencias = "";
        for (int i = 0; i < reservas.getContadorIncidencias(); i++)
        {
            this.detalleIncidencias += "  " + reservas.DescripcionIncidencia(i) + " = S/ "
                    + reservas.MontoIncidencia(i) + "\n";
        }
    }
    public void obtenerAdelanto()
    {
        if (reservas.getEstadoAdelanto().equals("Pagado"))
        {
            this.adelanto = reservas.getAdelanto();
        }
        else
        {
            this.adelanto = 0;
        }
    }
     public void asignarNumero()
    {
        correlativo++;
        this.numero = correlativo;
    }
     public double subtotal()
    {
        return alquiler - descuento + servicios + paquetes + incidencias;
    }
      public double IGV()
    {
        return subtotal() * IGV;
    }

    public double total()
    {
        return subtotal() + IGV();
    }

    public double saldo()
    {
        return total() - adelanto;
    }
    
    public abstract String tipo();
    public abstract String datosCliente();
    public void obtenerDatos()
   {
    this.numReserva = reservas.getNumero();
    this.fecha = reservas.getFecha();
    this.dniTitular = jugadores.getDni();
    this.nombreCliente = jugadores.getNombre() + " " + jugadores.getApellido();
    this.nombreCancha = canchas.getCodigo() + " - " + canchas.getNombre();
   }

    public String VERINFO() {
        return  "Numero:" + numero + 
                "\n" + datosCliente() +
                "\n Alquiler de cancha:" + alquiler + 
                "\n Descuento=" + descuento +
                "\n Servicios(S/):" + servicios +
                "\n detalleServicios=" + detalleServicios + 
                "\n Paquetes(S/):" + paquetes +
                "\n detallePaquetes=" + detallePaquetes +                 
                "\n Incidencias(S/):" + incidencias +
                "\n detalleIncidencias=" + detalleIncidencias +                
                "\n Adelanto=" + adelanto +
                "\nSubtotal: S/ " + subtotal() +
                "\nIGV (18%): S/ " + IGV()+
                "\nTOTAL: S/ " + total()+
                "\nSaldo a pagar:"    + saldo();           
    }
    
    




}
