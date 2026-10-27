package estrategia;

import java.util.Comparator;
import java.util.List;

import modelo.Postulacion;

public class SeleccionPorOrdenLlegada implements EstrategiaSeleccion {

    @Override
    public Postulacion seleccionar(List<Postulacion> postulaciones) {
        return postulaciones.stream()
                .min(Comparator.comparing(Postulacion::getFecha)
                        .thenComparingInt(Postulacion::getIdPostulacion))
                .orElse(null);
    }

    @Override
    public String getNombre() {
        return "Selección por orden de llegada";
    }
}
