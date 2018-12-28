/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.models;

/**
 *
 * @author dragneel
 */
public class TbUnidad {

    private String id_unidad;
    private String sNombre;
    private String sDescripcion;
    private int unidad_disponible;

   
    public String[] toArray() {
        return new String[]{id_unidad,sNombre, sDescripcion, (unidad_disponible==1)?"SI":"NO"};
    }

    public String getsDescripcion() {
        return sDescripcion;
    }

    public void setsDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public int getUnidad_disponible() {
        return unidad_disponible;
    }

    public void setUnidad_disponible(int unidad_disponible) {
        this.unidad_disponible = unidad_disponible;
    }

    
}
