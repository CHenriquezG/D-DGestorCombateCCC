package logico.Combatiente;

public class CreadoraReal implements Creadora{
    @Override
    public Combatiente CrearCombatiente(String nombre,String nombreJugador, String clase,String imagen, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car, int sab ,int id) {
        return new CombatienteReal(nombre,nombreJugador, clase,imagen, bini, PG, arm, fue, inte, des, cons, car, sab, id);
    }
}
