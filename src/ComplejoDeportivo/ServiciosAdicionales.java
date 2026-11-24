package ComplejoDeportivo;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Romina Tarazona
 */
public class ServiciosAdicionales 
{
    protected String codigo, nombre;
    protected float precioU;
    protected int stock;

    public ServiciosAdicionales(String codigo, String nombre, float precioU, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioU = precioU;
        this.stock = stock;
    }

   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioU() {
        return precioU;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

   
    
   
    
    public boolean hayStock(int cantidad)
    {
      return this.stock >= cantidad;
    }
    public void descontarStock(int cantidad)
    {
      this.stock = this.stock - cantidad;
    }

     public void reponerStock(int cantidad)
    {
      this.stock = this.stock + cantidad;
    }

   
}
