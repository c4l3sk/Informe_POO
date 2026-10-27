package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import estrategia.EstrategiaSeleccion;
import modelo.Empresa;
import modelo.EstadoPostulacion;
import modelo.Estudiante;
import modelo.Oportunidad;
import modelo.Postulacion;
import modelo.Practica;
import modelo.Universidad;
import vista.VistaConsola;

// Controlador del MVC
public class PracticSysControlador {
    private final Universidad universidad;
    private final VistaConsola vista;
    private final List<Oportunidad> oportunidades = new ArrayList<>();
    private final List<Postulacion> postulaciones = new ArrayList<>();
    private final List<Practica> practicas = new ArrayList<>();
    private EstrategiaSeleccion estrategia;
    private int contOportunidad = 1;
    private int contPostulacion = 1;
    private int contPractica = 1;

    public PracticSysControlador(Universidad universidad, VistaConsola vista,
                                 EstrategiaSeleccion estrategiaInicial) {
        this.universidad = universidad;
        this.vista = vista;
        this.estrategia = estrategiaInicial;
    }

    // Strategy: se puede cambiar en ejecución
    public void setEstrategia(EstrategiaSeleccion estrategia) {
        this.estrategia = estrategia;
        vista.mostrarMensaje("Estrategia de selección establecida: " + estrategia.getNombre());
    }

    public Oportunidad publicarOportunidad(Empresa empresa, String puesto,
                                           String requisitos, String horario) {
        Oportunidad o = new Oportunidad(contOportunidad++, puesto, requisitos, horario, empresa);
        oportunidades.add(o);
        vista.mostrarOportunidad(o);
        return o;
    }

    public Postulacion postular(Estudiante estudiante, Oportunidad oportunidad, LocalDate fecha) {
        Postulacion p = new Postulacion(contPostulacion++, fecha, estudiante, oportunidad);
        // Observer: se suscriben el estudiante y la universidad
        p.agregarObservador(estudiante);
        p.agregarObservador(universidad);
        postulaciones.add(p);
        vista.mostrarMensaje("Postulación #" + p.getIdPostulacion() + " registrada: "
                + estudiante.getNombre() + " -> " + oportunidad.getPuesto());
        return p;
    }

    public void revisarPostulaciones(Oportunidad oportunidad) {
        for (Postulacion p : postulacionesDe(oportunidad)) {
            p.actualizarEstado(EstadoPostulacion.EN_REVISION);
        }
    }

    public Practica seleccionarPostulante(Oportunidad oportunidad, LocalDate fechaInicio) {
        List<Postulacion> candidatas = postulacionesDe(oportunidad);
        vista.mostrarMensaje("Aplicando: " + estrategia.getNombre());
        Postulacion ganadora = estrategia.seleccionar(candidatas);
        if (ganadora == null) {
            vista.mostrarMensaje("No hay postulaciones para seleccionar.");
            return null;
        }
        for (Postulacion p : candidatas) {
            p.actualizarEstado(p == ganadora ? EstadoPostulacion.ACEPTADA
                                             : EstadoPostulacion.RECHAZADA);
        }
        oportunidad.actualizarEstado("CERRADA");
        Practica practica = new Practica(contPractica++, fechaInicio, ganadora);
        practicas.add(practica);
        vista.mostrarMensaje("Se generó la práctica #" + practica.getIdPractica()
                + " para " + ganadora.getEstudiante().getNombre());
        return practica;
    }

    public void registrarHoras(Practica practica, int horas) {
        practica.registrarHoras(horas);
        vista.mostrarMensaje("Horas registradas: +" + horas + " (total: "
                + practica.getHorasRealizadas() + ")");
    }

    public void finalizarPractica(Practica practica, String evaluacion, LocalDate fechaFin) {
        practica.registrarEvaluacion(evaluacion, fechaFin);
        vista.mostrarPractica(practica);
    }

    private List<Postulacion> postulacionesDe(Oportunidad oportunidad) {
        List<Postulacion> resultado = new ArrayList<>();
        for (Postulacion p : postulaciones) {
            if (p.getOportunidad() == oportunidad) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
