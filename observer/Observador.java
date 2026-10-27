package observer;

import modelo.Postulacion;

// Interfaz del patrón Observer
public interface Observador {
    void actualizar(Postulacion postulacion, String mensaje);
}
