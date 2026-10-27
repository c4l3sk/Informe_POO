package modelo;

public class Oportunidad {
    private int idOportunidad;
    private String puesto;
    private String requisitos;
    private String horario;
    private String estado;
    private Empresa empresa;

    public Oportunidad(int idOportunidad, String puesto, String requisitos,
                       String horario, Empresa empresa) {
        this.idOportunidad = idOportunidad;
        this.puesto = puesto;
        this.requisitos = requisitos;
        this.horario = horario;
        this.empresa = empresa;
        this.estado = "ABIERTA";
    }

    public int getIdOportunidad() {
        return idOportunidad;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public String getHorario() {
        return horario;
    }

    public String getEstado() {
        return estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
