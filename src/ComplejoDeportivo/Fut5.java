/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;


/**
 *
 * @author Romina Tarazona
 */
public class Fut5 extends Cancha
{

    public Fut5(String estado, String nombre, String horario) {
        super(estado, nombre, horario);
        this.capMax=10;// SUPUESTO
    }

    @Override
    public double tarifa(int hora)
    {
        this.tarifaF = this.tarifaB;
        if (hora >= 18)
         {
              this.tarifaF = this.tarifaB + this.tarifaB * 0.05; // SUPUESTO: recargo por iluminacion 5%
         } 
       return this.tarifaF;
    }

    @Override
    public String tipo() 
    {
         return "Fútbol 5";
    }

    

    
    
}
