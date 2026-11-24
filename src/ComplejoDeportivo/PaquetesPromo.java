package ComplejoDeportivo;


import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Romina Tarazona
 */
public class PaquetesPromo 
{
    private String nombre;
    private double precio;
    private ServiciosAdicionales[] servicios;
    Random rand = new Random();

    public PaquetesPromo(String nombre, double precio, ServiciosAdicionales[] servicios) {
        this.nombre = nombre;
        this.precio = precio;
        this.servicios = servicios;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ServiciosAdicionales[] getServicios() {
        return servicios;
    }

    public void setServicios(ServiciosAdicionales[] servicios) {
        this.servicios = servicios;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }
   
  
   
}
