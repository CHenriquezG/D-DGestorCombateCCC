package logico.Combatiente;

public class CreadoraReal implements Creadora {


    @Override
    public Combatiente CrearCombatiente(String nombre,String nombreJugador, String clase, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car) {
        return new CombatienteReal(nombre,nombreJugador, clase, bini, PG, arm, fue, inte, des, cons, car);
    }
}
