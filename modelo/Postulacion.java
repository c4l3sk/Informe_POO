package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import observer.Observador;

// Sujeto del patrón Observer
public class Postulacion {
    private int idPostulacion;
    private LocalDate fecha;
    private EstadoPostulacion estado;
    private Estudiante estudiante;
    private Oportunidad oportunidad;
    private final List<Observador> observadores = new ArrayList<>();

    public Postulacion(int idPostulacion, LocalDate fecha, Estudiante estudiante,
                       Oportunidad oportunidad) {
        this.idPostulacion = idPostulacion;
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.oportunidad = oportunidad;
        this.estado = EstadoPostulacion.ENVIADA;
    }

    public int getIdPostulacion() {
        return idPostulacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public EstadoPostulacion getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Oportunidad getOportunidad() {
        return oportunidad;
    }

    // Métodos del Observer
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }

    private void notificarObservadores(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(this, mensaje);
        }
    }

    public void actualizarEstado(EstadoPostulacion nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores("La postulación #" + idPostulacion + " al puesto '"
                + oportunidad.getPuesto() + "' cambió a: " + nuevoEstado);
    }
}
