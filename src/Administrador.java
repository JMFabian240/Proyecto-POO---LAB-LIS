public class Administrador extends Usuario {

    public Administrador(int idUsuario, String nombre, String email) {
        super(idUsuario, nombre, email);
    }

    @Override
    public void consultarIncidencias() {
        System.out.println(getNombre() + " está consultando todas las incidencias.");
    }

    public void asignarPrioridad(Incidencia incidencia, Prioridad prioridad) {
        incidencia.setPrioridad(prioridad);
    }

    public void asignarTecnico(Incidencia incidencia, Tecnico tecnico) {
        incidencia.setTecnicoResponsable(tecnico);
    }

    public void generarReporte() {
        System.out.println("Generando reporte...");
    }
}