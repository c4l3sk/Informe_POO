package estrategia;

import java.util.Comparator;
import java.util.List;

import modelo.Postulacion;

public class SeleccionPorPromedio implements EstrategiaSeleccion {

    @Override
    public Postulacion seleccionar(List<Postulacion> postulaciones) {
        return postulaciones.stream()
                .max(Comparator.comparingDouble(p -> p.getEstudiante().getPromedio()))
                .orElse(null);
    }

    @Override
    public String getNombre() {
        return "Selección por mejor promedio";
    }
}
