package Transicion;

import Estado.EstadoMaquina;

//Utilizacion de patron strategy: Clase concreta de estrategia de direccion de transicion
public class TransicionMaquina {
    public enum Direccion{
        izquierda, derecha
    }

    private char simbolo;
    private Direccion direccionDeTransicion;
    private EstadoMaquina siguienteEstado;

    public TransicionMaquina(char simbolo, Direccion direccionDeTransicion, EstadoMaquina siguienteEstado) {
        this.simbolo = simbolo;
        this.direccionDeTransicion = direccionDeTransicion;
        this.siguienteEstado = siguienteEstado;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public Direccion getDireccionDeTransicion() {
        return direccionDeTransicion;
    }

    public EstadoMaquina getSiguienteEstado() {
        return siguienteEstado;
    }
}
