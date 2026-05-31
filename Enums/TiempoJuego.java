package AngelYMilton.FMDataAnalisis.Enums;

public enum TiempoJuego {

    JUGADOR_ESTRELLA(10),
    JUGADOR_IMPORTANTE(9),
    TITULAR_HABITUAL(8),
    JUGADOR_PLANTILLA(7),
    JUGADOR_ROTACION(6),
    SUPLENTE(5),
    REVULSILLO_BANQUILLO(4),
    RECAMBIO_EMERGENCIA(3),
    PROMESA_IMPORTANTE(2),
    PROMESA(1);

    private final int prioridad;

    TiempoJuego(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
}