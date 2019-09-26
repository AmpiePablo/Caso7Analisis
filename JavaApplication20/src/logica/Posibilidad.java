package logica;

/**
 *
 * @author Pablo Ampie
 */
public class Posibilidad {
    private int numero;
    private String letra;
    
    Posibilidad(int pNumero, String pLetra){
        numero=pNumero;
        letra=pLetra;
    }

    
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    
    
    
    
}
