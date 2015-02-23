/**
 * Created by Leslie on 23/02/2015.
 */
public class ColaZombies {

    NodoPersonaje cabeza, cola;
    int size;

    public ColaZombies(){
        cabeza = null;
        cola = null;
        size = 0;
    }


    public void push(NodoPersonaje plan){
        if(cola == null)
        {
            cola = plan;
            cabeza = cola;
        }
        else
        {
            cola.sig = plan;
            cola = cola.sig;
        }
        size++;
    }


    public NodoPersonaje obtener(int index){
        int contador = 0;
        NodoPersonaje temp = cabeza;
        while(contador<index){
            temp = temp.obtenersig();
            contador++;
        }
        return temp;
    }

    public void eliminiar(int index){
        if(index == 0){
            cabeza = cabeza.obtenersig();
        } else {
            int contador = 0;
            NodoPersonaje temporal = cabeza;
            while (contador < index-1){
                temporal = temporal.obtenersig();
                contador++;
            }
            temporal.enlacesig(temporal.obtenersig().obtenersig());
        }
        size--;
    }


    public NodoPersonaje get(){
        NodoPersonaje primero = obtener(0);
        eliminiar(0);
        return primero;

    }

    public int size(){
        return size;
    }

    public boolean estavacia(){
        if(cola == null){
            return true;
        } else {
            return false;
        }
    }



}
