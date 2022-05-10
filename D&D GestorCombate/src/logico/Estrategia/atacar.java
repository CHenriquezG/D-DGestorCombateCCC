package logico.Estrategia;

public class atacar  implements Estrategia{
    @Override
    public boolean TieneOpcionDaño() {
        return true;
    }

    @Override
    public boolean TieneOpcionReaccion() {
        return true;
    }

    @Override
    public boolean TieneOpcionAyudar() {
        return false;
    }


}
