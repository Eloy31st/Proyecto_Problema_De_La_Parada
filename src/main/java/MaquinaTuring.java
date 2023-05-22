import java.util.ArrayList;
import java.util.List;

public class MaquinaTuring {
    private ArrayList<Observer> observadores;
    private String cadena;
    private int posicion;
    private EstadoMaquina estado;

    public MaquinaTuring() {
        this.observadores = new ArrayList<>();
        this.cadena = "";
        this.posicion = 0;
        this.estado = null;
    }

    public void añadirObservador(Observer observador) {
        this.observadores.add(observador);
    }

    public void eliminarObservador(Observer observador) {
        this.observadores.remove(observador);
    }

    public void setEstado(EstadoMaquina estado) {
        this.estado = estado;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public void encender(){
        if(estado == null) {
            System.out.println("No se ha establecido un estado");
            return;
        }
        while (!estado.esFinal()){
            char simboloActual = cadena.charAt(posicion);
            TransicionMaquina transicion = estado.getTransicion(simboloActual);

            if(transicion == null){
                System.out.println("No se ha encontrado una transición para el símbolo " + simboloActual);
                return;
            }

            cadena = cadena.substring(0, posicion) + transicion.getSimbolo()
                    + cadena.substring(posicion + 1);

            if(transicion.getDireccionDeTransicion() == TransicionMaquina.Direccion.izquierda){
                posicion--;
            } else if(transicion.getDireccionDeTransicion() == TransicionMaquina.Direccion.derecha){
                posicion++;
            }

            estado = transicion.getSiguienteEstado();
            notificarObservadores();
        }

        System.out.println("La máquina ha terminado de ejecutarse en su estado final");
    }

    private void notificarObservadores() {
        for(Observer observador : observadores){
            observador.actualizar(cadena, posicion);
        }
    }
}
