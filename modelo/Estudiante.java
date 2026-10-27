package modelo;

import observer.Observador;

public class Estudiante extends Usuario implements Observador {
    private String carrera;
    private double promedio;

    public Estudiante(String nombre, String correo, String carrera, double promedio) {
        super(nombre, correo);
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public void realizarAccion() {
        System.out.println("El estudiante consulta oportunidades y realiza postulaciones.");
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Carrera: " + carrera);
        System.out.println("Promedio: " + promedio);
    }

    // Observer
    @Override
    public void actualizar(Postulacion postulacion, String mensaje) {
        System.out.println("   [Notificación a ESTUDIANTE " + nombre + "] " + mensaje);
    }
}
