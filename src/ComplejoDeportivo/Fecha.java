/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComplejoDeportivo;

/**
 *
 * @author ZYLIANNE
 */


public class Fecha
{
    public static int armar(int dia, int mes, int year)
    {
        return year * 10000 + mes * 100 + dia;
    }

    public static int dia(int fecha)
    {
        int dia = fecha % 100;
        return dia;
    }

    public static int mes(int fecha)
    {
        int mes = (fecha / 100) % 100;
        return mes;
    }

    public static int year(int fecha)
    {
        int year = fecha / 10000;
        return year;
    }

    public static boolean esBisiesto(int year)
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean esValida(int fecha)
    {
        int d = dia(fecha);
        int m = mes(fecha);
        int y = year(fecha);

        if (y < 2026) return false;
        if (m < 1 || m > 12) return false;
        if (d < 1 || d > 31) return false;

        if (m == 2)
        {
            if (esBisiesto(y))
            {
                if (d > 29) return false;
            }
            else
            {
                if (d > 28) return false;
            }
        }

        if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) return false;

        return true;
    }

    public static int aDias(int fecha)
    {
        int d = dia(fecha);
        int m = mes(fecha);
        int y = year(fecha);
        int total = 0;

        for (int i = 2026; i < y; i++)
        {
            if (esBisiesto(i))
            {
                total += 366;
            }
            else
            {
                total += 365;
            }
        }

        for (int i = 1; i < m; i++)
        {
            if (i == 2)
            {
                if (esBisiesto(y))
                {
                    total += 29;
                }
                else
                {
                    total += 28;
                }
            }
            else if (i == 4 || i == 6 || i == 9 || i == 11)
            {
                total += 30;
            }
            else
            {
                total += 31;
            }
        }

        return total + d;
    }

    public static String mostrar(int fecha)
    {
        return dia(fecha) + "/" + mes(fecha) + "/" + year(fecha);
    }
}




