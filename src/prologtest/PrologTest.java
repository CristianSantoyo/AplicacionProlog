/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prologtest;

import java.util.Scanner;
import org.jpl7.Query;

/**
 *
 * @author Cristian Santoyo <sant.da97a@gmail.com>
 */
public class PrologTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Programa básico para determinar que estudiantes pasan cierta asignatura");

        
        System.out.print("Digite el número de creditos de la asignatura: ");
        int numCreditos = tomarEntero(reader);
        
        System.out.print("Digite el número de estudiantes a calificar: ");
        int numEstudiantes = tomarEntero(reader);
       

        DatosEstudiante[] notas = new DatosEstudiante[numEstudiantes];

        for (int i = 0; i < numEstudiantes; i++) {
            notas[i] = new DatosEstudiante();
            System.err.println("Notas Estudiante " + Integer.toString(i + 1));
            
            System.out.print("Ingrese el número de fallas del estudiante: ");
            notas[i].setFallas(tomarEntero(reader));
            
            System.out.print("Ingrese Nota 1: ");
            notas[i].setNota1(tomarFlotante(reader));

            System.out.print("Ingrese Nota 2: ");
            notas[i].setNota2(tomarFlotante(reader));

            System.out.print("Ingrese Nota 3: ");
            notas[i].setNota3(tomarFlotante(reader));
        }

        System.err.println("----------------Análisis de Resultados----------------");

        String t1 = "consult('notas.pl')"; // Nombre del archivo de prolog
        Query q1 = new Query(t1);
        System.err.println((q1.hasMoreSolutions() ? "Conexión con prolog establecida" : "error en la conexión")); // Mostrará mensaje si hay o no conexion

        for (int i = 0; i < numEstudiantes; i++) {
            // Consulta para determinar si el estudiante aprobó o no la asignatura
            String consulta = "aprobado("
                    + numCreditos + ","
                    + notas[i].getFallas()+ ","
                    + notas[i].getNota1() + ","
                    + notas[i].getNota2() + ","
                    + notas[i].getNota3()
                    + ").";
            Query ejecutar = new Query(consulta);

            // Consulta para conocer la nota total del estudiante
            String consultaAux = "sumAcumulado("                    
                    + notas[i].getNota1() + ","
                    + notas[i].getNota2() + ","
                    + notas[i].getNota3()
                    + ", S).";
            Query ejecutarAux = new Query(consultaAux);
            String notaTotal = ejecutarAux.oneSolution().get("S").toString();

            if (ejecutar.hasSolution()) {
                System.out.println("El estudiante " + Integer.toString(i + 1) + " ha Aprobado la asignatura con: " + notaTotal);
            } else {
                if (Float.parseFloat(notaTotal) > 3){
                    System.out.println("El estudiante ha Reprobado la asignatura por fallas");
                } else {
                    System.out.println("El estudiante " + Integer.toString(i + 1) + " ha Reprobado la asignatura con: " + notaTotal);
                }                
            }
        }

    }

    private static boolean isInt(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static boolean isFloat(String cadena) {
        try {
            Float.parseFloat(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static int tomarEntero(Scanner r) {
        String cadena = r.next();
        while (!isInt(cadena)) {
            System.out.print("Error, ingrese el número nuevamente: ");
            cadena = r.next();
        }
        return Integer.parseInt(cadena);
    }

    private static float tomarFlotante(Scanner r) {
        String cadena = r.next();
        while (!isFloat(cadena) || Float.parseFloat(cadena) > 5 || Float.parseFloat(cadena) < 0) {
            System.err.print("Error, ingrese el valor de la nota nuevamente: ");
            cadena = r.next();
        }
        return Float.parseFloat(cadena);
    }

}
