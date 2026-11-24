/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;


/**
 *
 * @author Romina Tarazona
 */
public class Fut11 extends Cancha
{

    public Fut11(String estado, String nombre, String horario) {
        super(estado, nombre, horario);
         this.capMax = 22; // SUPUESTO

    }

    @Override
    public double tarifa(int hora)
    {
        this.tarifaF = this.tarifaB;
        if (hora >= 18)
         {
              this.tarifaF = this.tarifaB + this.tarifaB * 0.15; // SUPUESTO: recargo por iluminacion 15%
         } 
       return this.tarifaF;
    }

    @Override
    public String tipo() 
    {
         return "Fútbol 11";
    }
    
}
