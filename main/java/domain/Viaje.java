package domain;

import java.time.LocalDateTime;
import java.util.List;

public class Viaje {
    private Persona transeunte;
    private Direccion lugarComienzo;
    private Direccion lugarDestino;
    private List<Direccion> direccionesMultiples;
    private List<Float> tiempoEstimadoMultiplesDestinos;
    private List<Persona> cuidadores;
    private LocalDateTime horaDeComienzo;
    private GestorNotificaciones gestorNotificaciones;


    // Métodos para calcular tiempos estimados
    public void tiempoEstimadoUnDestino() {
        TiempoEstimado estimacion = new TiempoEstimado();
        float tiempoEstimado = estimacion.tiempoDemora(lugarComienzo, lugarDestino);
        System.out.println("Tiempo estimado de llegada al destino único: " + tiempoEstimado + " minutos");
    }

    public void tiempoEstimadoMultiplesDestinos() {
        TiempoEstimado estimacion = new TiempoEstimado();
        float tiempoEstimadoTotal = 0;

        for (int i = 0; i < direccionesMultiples.size() - 1; i++) {
            Direccion origen = direccionesMultiples.get(i);
            Direccion destino = direccionesMultiples.get(i + 1);
            tiempoEstimadoTotal += estimacion.tiempoDemora(lugarComienzo, lugarDestino);
            if(tiempoEstimadoMultiplesDestinos.get(i) == 0){
                self.enviarNotificacion("Llegue bien!");
            }else {
                tiempoEstimadoTotal += tiempoEstimadoMultiplesDestinos.get(i);
            }
        }

        System.out.println("Tiempo estimado de llegada a destinos múltiples: " + tiempoEstimadoTotal + " minutos");
    }


}