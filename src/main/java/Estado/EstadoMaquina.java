package Estado;

import Transicion.TransicionMaquina;

//Utilizacion de patron state: Clase concreta
public class EstadoMaquina implements Estado{
    private boolean esFinal;
    private TransicionMaquina[] transiciones;

    public EstadoMaquina(boolean esFinal) {
        this.esFinal = esFinal;
        this.transiciones = new TransicionMaquina[256];
    }

    @Override
    public boolean esFinal() {
        return false;
    }

    public void setTransicion(char simbolo, TransicionMaquina transicion){
        transiciones[simbolo] = transicion;
    }

    @Override
    public TransicionMaquina getTransicion(char simbolo) {
        return transiciones[simbolo];
    }
}
