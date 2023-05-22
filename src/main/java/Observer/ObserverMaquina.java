package Observer;

//Utilizacion de patron observer: Clase observadora
public class ObserverMaquina implements Observer{
    private boolean bucleDetectado = false;

    @Override
    public void actualizar(String cadena, int posicion) {
        System.out.println("Cadena: " + cadena);
        System.out.println("Posición: " + posicion);
        //se comprueba si se ha detectado un bucle
        if(cadena.length() > 1 && cadena.equals(cadena.substring(0, cadena.length()-1))){
            System.out.println("Bucle detectado");
            bucleDetectado = true;
        }
    }

    public boolean esBucleDetectado() {
        return bucleDetectado;
    }
}
