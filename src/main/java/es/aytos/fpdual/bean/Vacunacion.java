package es.aytos.fpdual.bean;

import java.util.*;

public class Vacunacion {

    private Integer id;

    private Integer mes;

    private String marca;

    private Integer efectoAdverso;

    private Integer idCiudadano;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMes() {
        return this.mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getEfectoAdverso() {
        return this.efectoAdverso;
    }

    public void setEfectoAdverso(Integer efectoAdverso) {
        this.efectoAdverso = efectoAdverso;
    }

    public Integer getIdCiudadano() {
        return this.idCiudadano;
    }

    public void setIdCiudadano(Integer idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public static String obtenerMarcaAleatoria() {
        return (new Random().nextInt(10) % 2 == 0) ? "Pfizer" : "Moderna";
    }
}
