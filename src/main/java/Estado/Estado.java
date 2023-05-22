package Estado;

import Transicion.TransicionMaquina;

//Utilizacion de patron state: Interfaz de clase
public interface Estado {
    boolean esFinal();
    TransicionMaquina getTransicion(char simbolo);

}
