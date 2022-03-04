package es.aytos.fpdual.util;

import java.util.*;

import es.aytos.fpdual.modelo.*;

public class Utilidades {

    private final static Integer D4 = 4;

    private final static Integer D6 = 6;

    private final static Integer D8 = 8;

    private final static Integer D10 = 10;

    private final static Integer D12 = 12;

    private final static Integer D20 = 20;

    private final static Integer D100 = 100;

    private static final int CODIGO_SPAIN = 1;

    private static final int CODIGO_ANDORRA = 2;

    private static final int CODIGO_GIBRALTAR = 3;

    private static final int CODIGO_LUXEMBURGO = 4;

    private static final int CODIGO_ISLAS_BERMUDAS = 5;

    private static final int CODIGO_IRLANDA = 6;

    private static final String RESIDENCIA_EN_SPAIN = "240";

    private static final String RESIDENCIA_EN_EXTRANJERO = "100";

    public static final Integer TOPE_DIAS_MAXIMO_EN_SPAIN_PARA_NO_DECLARAR = 180;

    public static final int ACTUACION_KIKI_CODIGO = 1;

    public static final String ACTUACION_KIKI_DESCRIPCION = "MUERTE POR KIKI";

    public static final int ACTUACION_ROTURA_PIERNAS_CODIGO = 2;

    public static final String ACTUACION_ROTURA_PIERNAS_DESCRIPCION = "ROTURA PIERNAS";

    public static final int ACTUACION_CORBATA_CODIGO = 3;

    public static final String ACTUACION_CORBATA_DESCRIPCION = "CORBATA COLOMBIANA";

    public static final int ACTUACION_MUTILACION_CODIGO = 4;

    public static final String ACTUACION_MUTILACION_DESCRIPCION = "CORTADA DE MANOS GUILLOTINA STYLE";

    public static final int ACTUACION_VENDIDO_CODIGO = 5;

    public static final String ACTUACION_VENDIDO_DESCRIPCION = "VENDIDO COMO ESCLAVO";

    public static final int ACTUACION_MEDIEVO_CODIGO = 6;

    public static final String ACTUACION_MEDIEVO_DESCRIPCION = "REALIZAR MEDIEVO";

    public static final int ACTUACION_MULTACA_CODIGO = 7;

    public static final String ACTUACION_MULTACA_DESCRIPCION = "MULTACA INFERNAL";

    public static final int ACTUACION_LIBRE_CODIGO = 8;

    public static final String ACTUACION_LIBRE_DESCRIPCION = "SE LIBRA POR ERROR JUDICIAL";

    private static String tirar1dX(Integer x) {
        return String.valueOf(new Random().nextInt(x) + 1);
    }

    public static String tirar1d4() {
        return tirar1dX(D4);
    }

    public static String tirar1d6() {
        return tirar1dX(D6);
    }

    public static String tirar1d8() {
        return tirar1dX(D8);
    }

    public static String tirar1d10() {
        return tirar1dX(D10);
    }

    public static String tirar1d12() {
        return tirar1dX(D12);
    }

    public static String tirar1d20() {
        return tirar1dX(D20);
    }

    public static String tirar1d100() {
        return tirar1dX(D100);
    }

    public static String obtenerPaisResidencia() {
        String paisResidencia = "ESPAÑA";
        Integer pais = Integer.valueOf(tirar1d6());
        switch (pais) {
        case CODIGO_ANDORRA:
            paisResidencia = "ANDORRA";
            break;
        case CODIGO_GIBRALTAR:
            paisResidencia = "GRIBALTAR ESPAÑOL";
            break;
        case CODIGO_LUXEMBURGO:
            paisResidencia = "LUXEMBURGO";
            break;
        case CODIGO_ISLAS_BERMUDAS:
            paisResidencia = "ISLAS BERMUDAS";
            break;
        case CODIGO_IRLANDA:
            paisResidencia = "IRLANDA";
            break;
        }

        return paisResidencia;
    }

    public static String obtenerDiasResidencia() {
        if (resideEnSpain()) {
            return RESIDENCIA_EN_SPAIN;
        }

        return RESIDENCIA_EN_EXTRANJERO;
    }

    private static boolean resideEnSpain() {
        return !"1".equals(tirar1d8());
    }

    public static String sqlTratarTexto(String cadena) {
        return "'" + cadena + "'";
    }

    public static boolean declaraResidirEnElExtranjero(Ciudadano c) {
        return !c.getPaisResidencia().equals("ESPAÑA");
    }

    public static boolean haEstadoViviendoEnSpain(Ciudadano c) {
        return Integer.valueOf(c.getDiasPermanencia()) > Utilidades.TOPE_DIAS_MAXIMO_EN_SPAIN_PARA_NO_DECLARAR;
    }

    public static String decidirActuacion() {
        int actuacion = Integer.parseInt(Utilidades.tirar1d8());
        String actuacionDesc = "";
        switch (actuacion) {
        case ACTUACION_KIKI_CODIGO:
            actuacionDesc = ACTUACION_KIKI_DESCRIPCION;
            break;
        case ACTUACION_ROTURA_PIERNAS_CODIGO:
            actuacionDesc = ACTUACION_ROTURA_PIERNAS_DESCRIPCION;
            break;
        case ACTUACION_CORBATA_CODIGO:
            actuacionDesc = ACTUACION_CORBATA_DESCRIPCION;
            break;
        case ACTUACION_MUTILACION_CODIGO:
            actuacionDesc = ACTUACION_MUTILACION_DESCRIPCION;
            break;
        case ACTUACION_VENDIDO_CODIGO:
            actuacionDesc = ACTUACION_VENDIDO_DESCRIPCION;
            break;
        case ACTUACION_MEDIEVO_CODIGO:
            actuacionDesc = ACTUACION_MEDIEVO_DESCRIPCION;
            break;
        case ACTUACION_MULTACA_CODIGO:
            actuacionDesc = ACTUACION_MULTACA_DESCRIPCION;
            break;
        case ACTUACION_LIBRE_CODIGO:
            actuacionDesc = ACTUACION_LIBRE_DESCRIPCION;
            break;
        }

        return actuacionDesc;
    }
}
