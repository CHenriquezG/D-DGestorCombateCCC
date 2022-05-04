package logico.Estrategia;

public class moverse implements Estrategia{
    @Override
    public boolean TieneOpcionDaño() {
        return false;
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
