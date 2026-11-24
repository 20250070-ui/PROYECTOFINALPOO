/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;


/**
 *
 * @author Romina Tarazona
 */
public abstract class Cancha 
{
    protected int capMax;
    protected String estado, nombre, horario, codigo;
    protected double tarifaB, tarifaF;

    public Cancha(String estado, String nombre, String horario) {
        this.estado = estado;
        this.nombre = nombre;
        this.horario = horario;
        this.capMax = 11;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getTarifaF() {
        return tarifaF;
    }

    public void setTarifaF(double tarifaF) {
        this.tarifaF = tarifaF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }

    public double getTarifaB() {
        return tarifaB;
    }

    public void setTarifaB(double tarifaB) {
        this.tarifaB = tarifaB;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public abstract double tarifa(int hora);
    public abstract String tipo();
    
    public boolean puedeReservarse()
    {
        return this.estado.equals("Disponible") || this.estado.equals("Ocupada");

        
    }
    public void Mantenimiento()
    {
       this.estado = "En Mantenimiento"; 
    }
   

}
