package logico.Combatiente;

public class CombatienteInstancia extends Combatiente{

    String estado;
    int iniciativa;


    public CombatienteInstancia(String nombre,String nombreJugador, String clase,String imagen,String estado, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car,int sab, int id) {
        super(nombre,nombreJugador, clase,imagen, bini, PG, arm, fue, inte, des, cons, car, sab,id);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

}
