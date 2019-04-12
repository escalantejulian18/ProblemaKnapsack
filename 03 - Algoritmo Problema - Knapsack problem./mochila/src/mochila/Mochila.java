
package mochila;

/**
 *
 * @author julian
 */
public class Mochila {

    private int pesoMaximo;
    private Elemento[] elementos;
    private int peso; //total
    private int beneficio; //total

    public Mochila(int pesoMaximo, int numElementos) {
        this.pesoMaximo = pesoMaximo;
        this.elementos = new Elemento[numElementos];
        this.beneficio = 0;
        this.peso = 0;
    }

    public Elemento[] getElementos() {
        return elementos;
    }

     public int getPeso() {
       return peso;
    }
    
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    /**
     * Añade un elemento a la mochila
     * @param e 
     */
    public void agregarElemento(Elemento e) {

        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e; //lo añade
                this.beneficio+=e.getBeneficio(); // aumenta el beneficio
                this.peso+=e.getPeso(); // Aumenta el piso
                break;
            }
        }

    }

    /**
     * Vacia la mochila
     */
    public void limpiar() {
        this.peso=0;
        this.beneficio=0;
        for (int i = 0; i < this.elementos.length; i++) {
            this.elementos[i] = null;
        }
    }

    /**
     * Elimina el elemento 
     * @param e 
     */
    public void eliminarElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i].equals(e)) {
                this.elementos[i] = null; //el elemento fuera
                this.peso-=e.getPeso(); //reduce el peso
                this.beneficio-=e.getBeneficio(); // reduce el beneficio
                break;
            }
        }
    }
    
    /**
     * Indica si existe el elemento
     * @param e
     * @return 
     */
    public boolean existeElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null && this.elementos[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra el contenido de la mochila
     * @return 
     */
    public String toString() {
        String cadena="";
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null) {
                cadena+=elementos[i]+"\n";
            }
        }
        
        cadena+="Peso de mochila: "+ getPeso()+" Kg"+"\n";
        cadena+="Beneficio de mochila: $" + getBeneficio()+"\n";
        return cadena;
    }

}