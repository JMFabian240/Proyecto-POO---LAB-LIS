import java.util.Date;

public class RegistroEstado {
    private Date fechaHora;
    private EstadoIncidencia estadoAnterior;
    private EstadoIncidencia estadoNuevo;
    private String tecnicoResponsable;

    public RegistroEstado(EstadoIncidencia estadoAnterior, EstadoIncidencia estadoNuevo, String tecnicoResponsable) {
        this.fechaHora = new Date();
        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
        this.tecnicoResponsable = tecnicoResponsable;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public EstadoIncidencia getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoIncidencia estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public EstadoIncidencia getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(EstadoIncidencia estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public String getTecnicoResponsable() {
        return tecnicoResponsable;
    }

    public void setTecnicoResponsable(String tecnicoResponsable) {
        this.tecnicoResponsable = tecnicoResponsable;
    }
}