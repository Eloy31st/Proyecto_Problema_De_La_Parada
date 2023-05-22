public class ObserverMaquina implements Observer{

    @Override
    public void actualizar(String cadena, int posicion) {
        System.out.println("Cadena: " + cadena);
        System.out.println("Posición: " + posicion);
    }
}
