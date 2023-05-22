public interface Estado {
    boolean esFinal();
    TransicionMaquina getTransicion(char simbolo);

}
