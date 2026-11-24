/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

import java.util.Random;

/**
 *
 * @author Romina Tarazona
 */
public abstract class Jugador 
{
    protected int reservas;
    protected String dni, telefono, nombre, apellido, correo, tipo; 
    Random rand = new Random();

    public Jugador(String dni, String telefono, String nombre, String apellido, String correo) {
        this.dni = dni;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
    
    public int getReservas() {
        return reservas;
    }

    public void setReservas(int reservas) {
        this.reservas = reservas;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public void ReservaFinalizada()
    {
        this.reservas++;
        if(this.reservas >= 5)
        {
            this.tipo = "Frecuente";
        }
        else
        {
            this.tipo = "Regular";
        }
    }
    
    public abstract double Descuento(double monto);
    
}
