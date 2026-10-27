package modelo;

public class Empresa extends Usuario {
    private String sector;

    public Empresa(String nombre, String correo, String sector) {
        super(nombre, correo);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public void realizarAccion() {
        System.out.println("La empresa publica oportunidades y revisa postulaciones.");
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Sector: " + sector);
    }
}
