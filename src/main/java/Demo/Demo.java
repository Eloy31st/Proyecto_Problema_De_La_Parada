package Demo;

import Estado.EstadoMaquina;
import MaquinaTuring.MaquinaTuring;
import Observer.ObserverMaquina;
import Transicion.TransicionMaquina;

public class Demo {
    public void demo() {
        EstadoMaquina estadoInicial = new EstadoMaquina(false);
        EstadoMaquina estadoFinal = new EstadoMaquina(true);

        TransicionMaquina transicion1 = new TransicionMaquina('0',
                TransicionMaquina.Direccion.derecha, estadoInicial);
        TransicionMaquina transicion2 = new TransicionMaquina('1',
                TransicionMaquina.Direccion.izquierda, estadoFinal);

        estadoInicial.setTransicion('0',transicion1);
        estadoInicial.setTransicion('1',transicion2);

        MaquinaTuring maquina = new MaquinaTuring();
        maquina.setEstado(estadoInicial);
        maquina.setCadena("0000111");

        ObserverMaquina observador = new ObserverMaquina();
        maquina.añadirObservador(observador);

        maquina.encender();

        if(!observador.esBucleDetectado()){
            System.out.println("No se ha detectado bucle");
        }
    }
}
