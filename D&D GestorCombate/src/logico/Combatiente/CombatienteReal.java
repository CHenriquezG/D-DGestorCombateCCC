package logico.Combatiente;

public class CombatienteReal extends Combatiente {

    CombatienteInstancia ParaCombate;

    public CombatienteReal(String nombre,String nombreJugador,String imagen, String clase, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car,int sab, int id) {
        super(nombre,nombreJugador, clase,imagen, bini, PG, arm, fue, inte, des, cons, car, sab , id);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getBini() {
        return Bini;
    }

    public void setBini(int bini) {
        Bini = bini;
    }

    public int getPG() {
        return PG;
    }

    public void setPG(int PG) {
        this.PG = PG;
    }

    public int getArm() {
        return Arm;
    }

    public void setArm(int arm) {
        Arm = arm;
    }

    public int getFue() {
        return fue;
    }

    public void setFue(int fue) {
        this.fue = fue;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public int getCons() {
        return cons;
    }

    public void setCons(int cons) {
        this.cons = cons;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

}
