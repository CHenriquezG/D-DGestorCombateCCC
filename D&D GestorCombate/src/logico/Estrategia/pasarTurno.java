package logico.Estrategia;

public class pasarTurno implements Estrategia{
    @Override
    public boolean TieneOpcionDaño() {
        return false;
    }

    @Override
    public boolean TieneOpcionReaccion() {
        return false;
    }

    @Override
    public boolean TieneOpcionAyudar() {
        return false;
    }
}
