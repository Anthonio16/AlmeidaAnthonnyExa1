package aaKDG;

import aaKDG.aaAnimal.aaAntCiberDrone;
import aaKDG.aaPersona.aaOperador;

public class AppAntrax {
    
    public static void main(String[] args) {
        aaOperador operador = new aaOperador("Anthony", "Almeida");
        aaAntCiberDrone dron = new aaAntCiberDrone();
        String archivo = "AlmeidaAnthonny.csv"; 
        
        System.out.println("[+] INFORMACIÓN:");
        System.out.println("      \t*Nombre: " + operador.getAaNombre() + " " + operador.getAaApellido());
        System.out.println("      \t*Cédula : 1724077829");
        System.out.println(""); 


        dron.aaLeerArchivo(archivo);
        System.out.println(""); 

        System.out.println("Inicializando AntCiberDron...");
        dron = new aaAntCiberDrone();
        System.out.println("[+] SISTEMAS: Integrando Bomba BBA... [OK]"); // <--- ESTA LÍNEA ASEGURA TU PUNTO

        dron.aaTestSupervivencia();
        System.out.println(""); 
        dron.aaMostrarReporteBBA(archivo);
    }
}
