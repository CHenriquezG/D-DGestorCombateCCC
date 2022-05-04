package logico.Estrategia;

public class ayudar implements Estrategia{
    @Override
    public boolean TieneOpcionDaño() {
        return false;
    }

    public boolean TieneOpcionAyudar() {
        return true;
    }

    @Override
    public boolean TieneOpcionReaccion() {
        return false;
    }
}
