package es.aytos.fpdual;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.*;

import javax.annotation.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import es.aytos.fpdual.factoria.*;
import es.aytos.fpdual.mapper.*;
import es.aytos.fpdual.modelo.*;
import es.aytos.fpdual.util.*;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath:application-context.xml" })
@SuppressWarnings("deprecation")
// @Transactional
// @Rollback
public class ServicioHaciendaTest {

    private ServicioHacienda servicioHacienda = null;

    private static final int TOTAL_POBLACION = 100;

    @SuppressWarnings("restriction")
    @Resource
    private ServicioHaciendaMapper servicioHaciendaMapper;

    @Before
    public void inicializar() {
        this.servicioHacienda = this.servicioHaciendaMapper; // Spring
    }

    @Test
    public void testConsultaCiudadanoPorId() {
        Ciudadano c = this.servicioHacienda.consultarCiudadanoPorId(1);
        assertThat(c.getNombre(), is("Nombre 1"));
    }

    @Test
    public void testConsultaCiudadanosPorVariosId() {
        List<Ciudadano> poblacion = this.servicioHacienda.consultarCiudadanos();

        for (int i = poblacion.size() - 1; i >= 0; i--) {
            if (Integer.parseInt(poblacion.get(i).getId()) % 2 == 0) {
                poblacion.remove(i);
            }
        }

        poblacion = this.servicioHacienda.consultarCiudadanosPorVariosId(poblacion);

        for (Ciudadano k : poblacion) {
            System.out.println(k.getNombre());
        }

        assertThat(poblacion.size(), is(50));
    }

    @Test
    public void testConsultaCiudadanos() {
        List<Ciudadano> poblacion = this.servicioHacienda.consultarCiudadanos();
        assertThat(poblacion.size(), is(greaterThan(0)));
    }

    @Test
    public void testInsertaMoroso() {

        this.servicioHacienda.borrarMorosos();

        Integer morosoId = 666;

        Moroso m = new Moroso();
        m.setId(morosoId);
        m.setNombre("David");
        m.setActuacion("PRUEBA TEST");
        this.servicioHacienda.insertarMoroso(m);

        Moroso mBD = this.servicioHacienda.consultarMorosoPorId(morosoId);

        assert (m.getId().equals(mBD.getId()));
        assert (m.getNombre().equals(mBD.getNombre()));
        assert (m.getActuacion().equals(mBD.getActuacion()));
    }

    @Test
    public void testRellenarMorosos() {
        this.servicioHacienda.borrarMorosos();

        List<Ciudadano> ciudadanos = this.servicioHacienda.consultarCiudadanos();

        Moroso m = null;
        for (Ciudadano c : ciudadanos) {
            if (Utilidades.declaraResidirEnElExtranjero(c) && Utilidades.haEstadoViviendoEnSpain(c)) {
                m = new Moroso();
                m.setId(Integer.parseInt(c.getId()));
                m.setNombre(c.getNombre());
                m.setActuacion(Utilidades.decidirActuacion());

                this.servicioHacienda.insertarMoroso(m);
            }
        }

        List<Moroso> morosos = this.servicioHacienda.consultarMorosos();
        assert (morosos.size() > 0);
    }

}
