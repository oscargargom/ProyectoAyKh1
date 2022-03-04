package es.aytos.fpdual.modelo;

public class Ciudadano {

    private String id;

    private String nombre;

    private String direccion;

    private String facturacionAnual;

    private String paisResidencia;

    private String diasPermanencia;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFacturacionAnual() {
        return this.facturacionAnual;
    }

    public void setFacturacionAnual(String facturacionAnual) {
        this.facturacionAnual = facturacionAnual;
    }

    public String getPaisResidencia() {
        return this.paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getDiasPermanencia() {
        return this.diasPermanencia;
    }

    public void setDiasPermanencia(String diasPermanencia) {
        this.diasPermanencia = diasPermanencia;
    }

}
