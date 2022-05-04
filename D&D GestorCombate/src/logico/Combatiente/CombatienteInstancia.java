package logico.Combatiente;

public class CombatienteInstancia extends Combatiente{

    String estado;

    public CombatienteInstancia(String nombre,String nombreJugador, String clase,String imagen,String estado, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car, int id) {
        super(nombre,nombreJugador, clase,imagen, bini, PG, arm, fue, inte, des, cons, car, id);
        this.estado = estado;
    }
}
