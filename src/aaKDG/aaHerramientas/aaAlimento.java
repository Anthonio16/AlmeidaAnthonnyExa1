package aaKDG.aaHerramientas;

public abstract class aaAlimento {
    
    public aaAlimento() {
    }
    // Refactorización: Según el diagrama, Alimento es abstracto. 
    // Definimos este método como 'abstract' para obligar a las clases hijas (como aaCarnivoro)
    // a implementar su propia descripción, garantizando el polimorfismo correcto.
    @Override
    public abstract String toString();
}
