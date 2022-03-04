package es.aytos.fpdual.mapper;

import org.apache.ibatis.annotations.*;

import es.aytos.fpdual.factoria.*;
import es.aytos.fpdual.modelo.*;

public interface ServicioHaciendaMapper extends ServicioHacienda {

    public void insertarCiudadano(@Param("ciudadano") Ciudadano c);

    //
    // public void modificarCiudadano(@Param("ciudadano") Ciudadano c);
    //

    public void insertarMoroso(@Param("moroso") Moroso c);
    //
    // public void modificarMoroso(@Param("moroso") Moroso c);
}
