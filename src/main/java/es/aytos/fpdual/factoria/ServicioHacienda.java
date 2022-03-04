package es.aytos.fpdual.factoria;

import java.util.*;

import org.apache.ibatis.annotations.*;

import es.aytos.fpdual.modelo.*;

public interface ServicioHacienda {

    public List<Ciudadano> consultarCiudadanos();

    // Otra forma public Ciudadano consultarCiudadanoPorId(@Param("ciudadano") Ciudadano c);

    public Ciudadano consultarCiudadanoPorId(Integer id);

    public List<Ciudadano> consultarCiudadanosPorVariosId(@Param("ciudadanos") List<Ciudadano> poblacion);

    public void insertarCiudadano(Ciudadano c);

    public void borrarCiudadanos();

    public void insertarMoroso(Moroso m);

    public List<Moroso> consultarMorosos();

    public Moroso consultarMorosoPorId(Integer id);

    public void borrarMorosos();

}
