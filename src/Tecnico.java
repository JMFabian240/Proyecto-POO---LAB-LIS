public class Tecnico extends Usuario {
    private TipoIncidencia especialidad;

    public Tecnico(int idUsuario, String nombre, String email, TipoIncidencia especialidad) {
        super(idUsuario, nombre, email);
        this.especialidad = especialidad;
    }

    @Override
    public void consultarIncidencias() {
        System.out.println(getNombre() + " está consultando sus incidencias.");
    }

    public void clasificarIncidencia(Incidencia incidencia, TipoIncidencia tipo) {
        incidencia.setTipo(tipo);
    }

    public void gestionarCicloDeVida(Incidencia incidencia, EstadoIncidencia nuevoEstado) {
        incidencia.setEstado(nuevoEstado);
    }

    public TipoIncidencia getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(TipoIncidencia especialidad) {
        this.especialidad = especialidad;
    }
}