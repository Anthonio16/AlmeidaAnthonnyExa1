package aaKDG.aaAnimal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import aaKDG.aaHerramientas.aaAlimento;
import aaKDG.aaHerramientas.aaBombaBBA;
import aaKDG.aaHerramientas.aaCarnivoro;

// Refactorización: Se integra la lógica de 'HSoldado' directamente en el Dron
public class aaAntCiberDrone implements aaZHormiga, aaIIA, aaBombaBBA {
    
    // --- TEST DE SUPERVIVENCIA ---
    public void aaTestSupervivencia() {
        System.out.println("[+] TEST DE SUPERVIVENCIA :");
        System.out.println("      \t Identidad: Hormiga Soldado "); 
        aaCarnivoro Carne = new aaCarnivoro();
        System.out.println("      \t Entregando alimento: " + Carne.toString());
        boolean vive = this.comer(Carne);
        if (vive) System.out.println("      \t Resultado: VIVE [OK] - El alimento es compatible.");
        else System.out.println("      \t Resultado: MUERE [X] - El alimento es tóxico.");
        System.out.println(""); 
    }

    // ---REPORTE DE DESTRUCCIÓN ---
    // Refactorización: Se añadió el método ('aaMostrarReporteBBA' ) para cumplir
    // con el requerimiento de orden de ejecución (Alimentar -> Reporte).
    public void aaMostrarReporteBBA(String nombreArchivo) {
        System.out.println("------------------------------------------------");
        System.out.println("COORDENADAS UCRANIANAS A DESTRUIR:");
        System.out.printf("%-12s | %-15s | %s%n", "Geoposición", "Tipo Arsenal", "Acción");
        
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                contador++;
                String[] partes = linea.split(";", -1);
                if (contador > 1 && partes.length >= 7) { 
                    String geo = partes[0];
                    String arsenal = partes[6];
                    
                    if (buscar(arsenal)) {
                        System.out.printf("%-12s | %-15s | %s%n", geo, arsenal, "true");
                        explotar();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("------------------------------------------------\n");
    }

    // --- TABLA DE DATOS ---
    public void aaLeerArchivo(String nombreArchivo) {
        System.out.println("[+] INICIANDO CARGA MASIVA DE DATOS...");
        System.out.printf("%-8s| %-12s| %-8s| %-8s| %-10s| %-8s| %-8s| %s%n", 
            "Loading", "Geoposición", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Tipo Arsenal");

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contador = 0;
            char[] spinner = {'|', '/', '-', '\\'}; 
            
            while ((linea = br.readLine()) != null) {
                contador++;
                String[] partes = linea.split(";", -1);
                if (contador > 1 && partes.length >= 1) { 
                    String geo = (partes.length > 0) ? partes[0] : "";
                    String lun = (partes.length > 1) ? partes[1] : "";
                    String mar = (partes.length > 2) ? partes[2] : "";
                    String mie = (partes.length > 3) ? partes[3] : "";
                    String jue = (partes.length > 4) ? partes[4] : "";
                    String vie = (partes.length > 5) ? partes[5] : "";
                    String arsenal = (partes.length > 6) ? partes[6] : "";
                    
                    for (int i = 0; i < 10; i++) { 
                        System.out.print("\r"); 
                        System.out.printf("%-8s| %-12s| %-8s| %-8s| %-10s| %-8s| %-8s| %s", 
                            spinner[i % 4], geo, lun, mar, mie, jue, vie, "");
                        try { Thread.sleep(100); } catch (InterruptedException e) {}
                    }
                    System.out.print("\r"); 
                    System.out.printf("%-8s| %-12s| %-8s| %-8s| %-10s| %-8s| %-8s| %s", 
                        "100%", geo, lun, mar, mie, jue, vie, arsenal);
                    System.out.println(); 
                }
            }
            System.out.println("... 100% CARGA COMPLETA.");
        } catch (IOException e) {}
    }

    public String aaVerificarCoordenadas() { return "Coordenadas Verificadas."; }

    @Override
    public boolean comer(aaAlimento alimento) {
        return alimento.toString().equals("Carne");
    }

    // Refactorización: Implementación del Autómata Finito Determinista (AFD)
    // para reconocer el lenguaje L={ab*} correspondiente a la cédula terminada en 9.
    @Override
    public boolean buscar(String tipoArsenal) {
        if (tipoArsenal == null || tipoArsenal.isEmpty()) return false;
        int estado = 0;
        for (char c : tipoArsenal.toCharArray()) {
            switch (estado) {
                case 0 -> {
                    if (c == 'a') estado = 1; else return false; 
                }
                case 1 -> {
                    if (c == 'b') estado = 1; else return false;
                }
            }
        }
        return estado == 1; 
    }

    @Override
    public void explotar() {}
}