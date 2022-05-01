package logico.Combatiente;

public class Combatiente {
    String nombre,clase, imagen;
    int Bini,PG,Arm,fue,inte,des,cons,car;

    public Combatiente(String nombre,String nombreJugador, String clase,String imagen, int bini, int PG, int arm, int fue, int inte, int des, int cons, int car) {
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
    }
}
