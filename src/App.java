import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Administrador admin1 = new Administrador(101, "Carlos Admin", "carlos@empresa.com");
        Tecnico tecSoftware = new Tecnico(201, "Sofia Tech", "sofia.s@empresa.com", TipoIncidencia.SOFTWARE);
        Tecnico tecRed = new Tecnico(202, "Marco Network", "marco.n@empresa.com", TipoIncidencia.RED);

        System.out.println("\tUsuarios Creados");
        System.out.println("Administrador: " + admin1.getNombre());
        System.out.println("Técnico Software: " + tecSoftware.getNombre() + " (" + tecSoftware.getEspecialidad() + ")");
        System.out.println("Técnico Red: " + tecRed.getNombre() + " (" + tecRed.getEspecialidad() + ")");

        Incidencia inc1 = new Incidencia(1, "El ERP no inicia después de la actualización.", "ETQ-005", TipoIncidencia.SOFTWARE, EstadoIncidencia.NUEVA_ASIGNADA, Prioridad.MEDIA);
        Incidencia inc2 = new Incidencia(2, "No hay acceso a Internet en el piso 3.", "ETQ-006", null, EstadoIncidencia.NUEVA_ASIGNADA, Prioridad.BAJA);

        System.out.println("\n \t Incidencias Iniciales ");
        System.out.println("Incidencia 1 (ERP): Estado: " + inc1.getEstado() + ", Tipo: " + inc1.getTipo());
        System.out.println("Incidencia 2 (Red): Estado: " + inc2.getEstado() + ", Tipo: " + inc2.getTipo());

        System.out.println("\n Acciones del Administrador (" + admin1.getNombre() + ")");
        admin1.consultarIncidencias();

        System.out.println("\nAsignando Incidencia 2 (Red)...");
        admin1.asignarPrioridad(inc2, Prioridad.ALTA);
        admin1.asignarTecnico(inc2, tecRed);
        System.out.println("Prioridad actualizada: " + inc2.getPrioridad());
        System.out.println("Técnico asignado: " + inc2.getTecnicoResponsable().getNombre());

        admin1.generarReporte();

        System.out.println("\nAcciones del Técnico de Red (" + tecRed.getNombre() + ")");
        tecRed.consultarIncidencias();

        if (inc2.getTipo() == null) {
            tecRed.clasificarIncidencia(inc2, TipoIncidencia.RED);
            System.out.println("\nIncidencia 2 clasificada como: " + inc2.getTipo());
        }

        EstadoIncidencia estadoAnt1 = inc2.getEstado();
        tecRed.gestionarCicloDeVida(inc2, EstadoIncidencia.EN_PROCESO);
        RegistroEstado reg1 = new RegistroEstado(estadoAnt1, inc2.getEstado(), tecRed.getNombre());
        inc2.getHistorialEstados().add(reg1);
        System.out.println("Estado actualizado a: " + inc2.getEstado());

        EstadoIncidencia estadoAnt2 = inc2.getEstado();
        tecRed.gestionarCicloDeVida(inc2, EstadoIncidencia.RESUELTA);
        RegistroEstado reg2 = new RegistroEstado(estadoAnt2, inc2.getEstado(), tecRed.getNombre());
        inc2.getHistorialEstados().add(reg2);
        System.out.println("Estado actualizado a: " + inc2.getEstado());

        EstadoIncidencia estadoAnt3 = inc2.getEstado();
        tecRed.gestionarCicloDeVida(inc2, EstadoIncidencia.CERRADA);
        RegistroEstado reg3 = new RegistroEstado(estadoAnt3, inc2.getEstado(), tecRed.getNombre());
        inc2.getHistorialEstados().add(reg3);
        System.out.println("Estado final: " + inc2.getEstado());

        System.out.println("\n \tHistorial de Estados para Incidencia 2 ");
        List<RegistroEstado> historial = inc2.obtenerHistorial();
        for (RegistroEstado registro : historial) {
            System.out.println("Fecha: " + registro.getFechaHora() + " | De: " + registro.getEstadoAnterior() + " | A: " + registro.getEstadoNuevo() + " | Por: " + registro.getTecnicoResponsable());
        }
    }
}