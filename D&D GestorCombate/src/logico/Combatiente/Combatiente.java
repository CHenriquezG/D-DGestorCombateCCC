package logico.Combatiente;
import java.util.ArrayList;


public class Combatiente {
    // poner máximo de combatientes
    String nombre,clase, imagen;
    int Bini,PG,Arm,fue,inte,des,cons,car, id;

    public Combatiente(String nombre,String nombreJugador, String clase,String imagen, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car, int id) {
        this.nombre = nombre;
        this.clase = clase;
        this.imagen = imagen;
        Bini = bini;
        this.PG = PG;
        Arm = arm;
        this.fue = fue;
        this.inte = inte;
        this.des = des;
        this.cons = cons;
        this.car = car;
        this.id = id;
        // validar jugador
        Jugador e = new Jugador(nombreJugador); // puede haber un jugador repetido
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
