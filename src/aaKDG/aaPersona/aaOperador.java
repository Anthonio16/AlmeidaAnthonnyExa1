package aaKDG.aaPersona;

public class aaOperador {

    private String aaNombre;
    private String aaApellido;

    public aaOperador(String aaNombre, String aaApellido) {
        this.aaNombre = aaNombre;
        this.aaApellido = aaApellido;
    }

    public String mostrarCredencial(String aaNombre, String aaApellido) {
        return "Operador: " + aaNombre + " " + aaApellido;
    }
    
    public String getAaNombre() { return aaNombre; }
    public String getAaApellido() { return aaApellido; }
}
