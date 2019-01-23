package com.data.models;

import static com.data.configurations.StaticData.*;

public class TbProgramacionServicios {

    private int id_programacion_servicio;
    private TbServicios servicio;
    private TbUnidad unidad;
    private String id_unidad;
    private String sDescripcion_programacion;
    private String dFecha_programada;
    private double nCostoServicio;
    private int bRealizado;
    private int id_servicio;

    public int getId_programacion_servicio() {
        return id_programacion_servicio;
    }

    public void setId_programacion_servicio(String id_programacion_servicio) {

        this.id_programacion_servicio = Integer.parseInt(id_programacion_servicio.replace(SUFIJO_ID_PROGRAMACION_SERVICIO, ""));
    }

    public String getsDescripcion_programacion() {
        return sDescripcion_programacion;
    }

    public void setsDescripcion_programacion(String sDescripcion_programacion) {
        this.sDescripcion_programacion = sDescripcion_programacion;
    }

    public String getdFecha_programada() {
        return dFecha_programada;
    }

    public void setdFecha_programada(String dFecha_programada) {
        this.dFecha_programada = dFecha_programada;
    }

    public double getnCostoServicio() {
        return nCostoServicio;
    }

    public void setnCostoServicio(double nCostoServicio) {
        this.nCostoServicio = nCostoServicio;
    }

    public int getbRealizado() {
        return bRealizado;
    }

    public void setbRealizado(int bRealizado) {
        this.bRealizado = bRealizado;
    }

    public TbServicios getServicio() {
        return servicio;
    }

    public void setServicio(TbServicios servicio) {
        this.servicio = servicio;
    }

    public TbUnidad getUnidad() {
        return unidad;
    }

    public void setUnidad(TbUnidad unidad) {
        this.unidad = unidad;
    }

    public String[] toArray() {

        return new String[]{
            SUFIJO_ID_PROGRAMACION_SERVICIO + id_programacion_servicio,
            unidad.getId_unidad(),
            unidad.getsNombre(),
            SUFIJO_ID_SERVICIOMANTENIMIENTO + servicio.getId_servicio() + "",
            servicio.getNombre_servicio(),
            sDescripcion_programacion,
            dFecha_programada,
            formatoNumerico.format(nCostoServicio),
            (bRealizado == 1) ? "SI" : "NO"};
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {

        this.id_servicio = Integer.parseInt(id_servicio.replace(SUFIJO_ID_SERVICIOMANTENIMIENTO, ""));
    }

}
