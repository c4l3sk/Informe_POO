package vista;

import modelo.Oportunidad;
import modelo.Practica;

// Vista del MVC, solo muestra datos
public class VistaConsola {

    public void mostrarTitulo(String titulo) {
        System.out.println("\n===== " + titulo + " =====");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarOportunidad(Oportunidad o) {
        System.out.println("Oportunidad #" + o.getIdOportunidad() + " publicada por "
                + o.getEmpresa().getNombre() + ": " + o.getPuesto()
                + " | Requisitos: " + o.getRequisitos()
                + " | Horario: " + o.getHorario());
    }

    public void mostrarPractica(Practica p) {
        System.out.println("Práctica #" + p.getIdPractica()
                + " | Estudiante: " + p.getPostulacion().getEstudiante().getNombre()
                + " | Estado: " + p.getEstado()
                + " | Horas: " + p.getHorasRealizadas()
                + " | Inicio: " + p.getFechaInicio()
                + " | Fin: " + p.getFechaFin()
                + " | Evaluación: " + p.getEvaluacion());
    }
}
