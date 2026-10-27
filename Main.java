import java.time.LocalDate;

import controlador.PracticSysControlador;
import estrategia.SeleccionPorOrdenLlegada;
import estrategia.SeleccionPorPromedio;
import modelo.Empresa;
import modelo.Estudiante;
import modelo.Oportunidad;
import modelo.Practica;
import modelo.Universidad;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();

        // usuarios
        Universidad universidad = new Universidad(
                "Universidad Nacional", "contacto@universidad.edu", "Universidad Nacional");
        Empresa empresa = new Empresa(
                "Tech Solutions", "contacto@techsolutions.com", "Tecnología");
        Estudiante carlos = new Estudiante(
                "Carlos Perez", "carlos@gmail.com", "Ingeniería de Sistemas", 15.2);
        Estudiante ana = new Estudiante(
                "Ana Torres", "ana@gmail.com", "Ingeniería de Sistemas", 17.4);
        Estudiante luis = new Estudiante(
                "Luis Ramos", "luis@gmail.com", "Ingeniería de Ciberseguridad", 16.1);

        // controlador con la estrategia inicial
        PracticSysControlador controlador =
                new PracticSysControlador(universidad, vista, new SeleccionPorPromedio());

        vista.mostrarTitulo("1. USUARIOS");
        carlos.mostrarInformacion();
        empresa.mostrarInformacion();
        universidad.mostrarInformacion();

        vista.mostrarTitulo("2. PUBLICACIÓN Y POSTULACIÓN");
        Oportunidad op = controlador.publicarOportunidad(
                empresa, "Practicante de Desarrollo Java", "Ciclo IV en adelante", "Lun-Vie 9:00-13:00");
        controlador.postular(carlos, op, LocalDate.of(2026, 10, 20));
        controlador.postular(ana, op, LocalDate.of(2026, 10, 22));
        controlador.postular(luis, op, LocalDate.of(2026, 10, 21));

        vista.mostrarTitulo("3. OBSERVER: REVISIÓN (notificaciones automáticas)");
        controlador.revisarPostulaciones(op);

        vista.mostrarTitulo("4. STRATEGY: SELECCIÓN POR PROMEDIO");
        Practica practica = controlador.seleccionarPostulante(op, LocalDate.of(2026, 11, 2));

        vista.mostrarTitulo("5. SEGUIMIENTO DE LA PRÁCTICA");
        controlador.registrarHoras(practica, 40);
        controlador.registrarHoras(practica, 60);
        controlador.finalizarPractica(practica, "Excelente desempeño", LocalDate.of(2027, 2, 2));

        vista.mostrarTitulo("6. STRATEGY: CAMBIO DE ALGORITMO EN EJECUCIÓN");
        Oportunidad op2 = controlador.publicarOportunidad(
                empresa, "Practicante de Soporte TI", "Ciclo III en adelante", "Lun-Vie 14:00-18:00");
        controlador.postular(carlos, op2, LocalDate.of(2026, 10, 20));
        controlador.postular(ana, op2, LocalDate.of(2026, 10, 22));
        controlador.postular(luis, op2, LocalDate.of(2026, 10, 21));
        controlador.setEstrategia(new SeleccionPorOrdenLlegada());
        controlador.seleccionarPostulante(op2, LocalDate.of(2026, 11, 9));
    }
}
