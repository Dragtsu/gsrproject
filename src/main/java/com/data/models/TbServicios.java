/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.models;

import static com.data.configurations.StaticData.*;

/**
 *
 * @author dragneel
 */
public class TbServicios {

    private int id_servicio;
    private String nombre_servicio;
    private String sDescripcion;
    private Double nCostoServicio;

    
    

    public String[] toArray() {
        System.out.println("Convirtiendo array");

        return new String[]{SUFIJO_ID_SERVICIOMANTENIMIENTO + id_servicio, nombre_servicio, sDescripcion, formatoNumerico.format(nCostoServicio)};

    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = Integer.parseInt(id_servicio.replace(SUFIJO_ID_SERVICIOMANTENIMIENTO, ""));
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public String getsDescripcion() {
        return sDescripcion;
    }

    public void setsDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public Double getnCostoServicio() {
        return nCostoServicio;
    }

    public void setnCostoServicio(Double nCostoServicio) {
        this.nCostoServicio = nCostoServicio;
    }

}
