package logico.Estrategia;

public class contexto {

    public Estrategia ObtenerEstrategia(String opcion){
        Estrategia obtener;
        if(opcion.equals("Ayudar")){
            obtener = new ayudar();

        }else if(opcion.equals("Atacar")){
            obtener = new atacar();
        }else if(opcion.equals("Moverse")){
            obtener = new moverse();
        }else if(opcion.equals("PasarTurno")){
            obtener = new pasarTurno();
        }else if(opcion.equals("Curar")){
            obtener = new curar();
        }else{
            obtener = new curar();
        }
        return obtener;


    }




}
