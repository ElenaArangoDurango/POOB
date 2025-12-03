package ventanacontacto;

import java.util.ArrayList;

public class ListaContactos {

    private ArrayList<Contacto> lista;

    public ListaContactos() {
        lista = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        lista.add(contacto);
    }

    public ArrayList<Contacto> getLista() {
        return lista;
    }
}
