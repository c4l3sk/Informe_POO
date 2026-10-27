package modelo;

import java.time.LocalDate;

public class Practica {
    private int idPractica;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horasRealizadas;
    private String estado;
    private String evaluacion;
    private Postulacion postulacion;

    public Practica(int idPractica, LocalDate fechaInicio, Postulacion postulacion) {
        this.idPractica = idPractica;
        this.fechaInicio = fechaInicio;
        this.postulacion = postulacion;
        this.horasRealizadas = 0;
        this.estado = "EN CURSO";
        this.evaluacion = "Pendiente";
    }

    public int getIdPractica() {
        return idPractica;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getHorasRealizadas() {
        return horasRealizadas;
    }

    public String getEstado() {
        return estado;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public Postulacion getPostulacion() {
        return postulacion;
    }

    public void registrarHoras(int horas) {
        if (horas > 0) {
            this.horasRealizadas += horas;
        }
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void registrarEvaluacion(String evaluacion, LocalDate fechaFin) {
        this.evaluacion = evaluacion;
        this.fechaFin = fechaFin;
        this.estado = "FINALIZADA";
    }
}
