package es.aytos.fpdual.bean;

import java.util.*;

public class Ciudadano {

    private String id;

    private String documento;

    private String nombreCompleto;

    private String direccion;

    private String movil;

    private boolean vacunable;

    private List<Vacunacion> vacunaciones;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMovil() {
        return this.movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public boolean isVacunable() {
        return this.vacunable;
    }

    public void setVacunable(boolean vacunable) {
        this.vacunable = vacunable;
    }

    public List<Vacunacion> getVacunaciones() {
        return this.vacunaciones;
    }

    public void setVacunaciones(List<Vacunacion> vacunaciones) {
        this.vacunaciones = vacunaciones;
    }

}
