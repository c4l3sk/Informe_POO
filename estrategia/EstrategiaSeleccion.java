package estrategia;

import java.util.List;

import modelo.Postulacion;

// Interfaz del patrón Strategy
public interface EstrategiaSeleccion {
    Postulacion seleccionar(List<Postulacion> postulaciones);

    String getNombre();
}
