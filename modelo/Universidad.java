package modelo;

import observer.Observador;

public class Universidad extends Usuario implements Observador {
    private String nombreInstitucion;

    public Universidad(String nombre, String correo, String nombreInstitucion) {
        super(nombre, correo);
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    @Override
    public void realizarAccion() {
        System.out.println("La universidad supervisa las prácticas profesionales.");
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Institución: " + nombreInstitucion);
    }

    // Observer
    @Override
    public void actualizar(Postulacion postulacion, String mensaje) {
        System.out.println("   [Notificación a UNIVERSIDAD " + nombreInstitucion + "] " + mensaje);
    }
}
