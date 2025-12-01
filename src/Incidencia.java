import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Incidencia {
    private int idIncidencia;
    private String descripcion;
    private String numeroEtiqueta;
    private Date fechaRegistro;
    private TipoIncidencia tipo;
    private EstadoIncidencia estado;
    private Prioridad prioridad;

    private List<RegistroEstado> historialEstados;
    private Tecnico tecnicoResponsable;

    public Incidencia(int idIncidencia, String descripcion, String numeroEtiqueta, TipoIncidencia tipo, EstadoIncidencia estado, Prioridad prioridad) {
        this.idIncidencia = idIncidencia;
        this.descripcion = descripcion;
        this.numeroEtiqueta = numeroEtiqueta;
        this.fechaRegistro = new Date();
        this.tipo = tipo;
        this.estado = estado;
        this.prioridad = prioridad;
        this.historialEstados = new ArrayList<>();
    }

    public boolean validarCampos() {
        return idIncidencia > 0;
    }

    public List<RegistroEstado> obtenerHistorial() {
        return historialEstados;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroEtiqueta() {
        return numeroEtiqueta;
    }

    public void setNumeroEtiqueta(String numeroEtiqueta) {
        this.numeroEtiqueta = numeroEtiqueta;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public TipoIncidencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoIncidencia tipo) {
        this.tipo = tipo;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public List<RegistroEstado> getHistorialEstados() {
        return historialEstados;
    }

    public void setHistorialEstados(List<RegistroEstado> historialEstados) {
        this.historialEstados = historialEstados;
    }

    public Tecnico getTecnicoResponsable() {
        return tecnicoResponsable;
    }

    public void setTecnicoResponsable(Tecnico tecnicoResponsable) {
        this.tecnicoResponsable = tecnicoResponsable;
    }
}