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
    
    private String id_vehiculo;
    private String sDescripcion;
    private String fMantenimiento;
    private String fVerificacion;
    private String fSeguro;
    private Double nCostoServicio;

    public String getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(String id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getfMantenimiento() {
        return fMantenimiento;
    }

    public void setfMantenimiento(String fMantenimiento) {
        this.fMantenimiento = fMantenimiento;
    }

    public String getfVerificacion() {
        return fVerificacion;
    }

    public void setfVerificacion(String fVerificacion) {
        this.fVerificacion = fVerificacion;
    }

    public String getfSeguro() {
        return fSeguro;
    }

    public void setfSeguro(String fSeguro) {
        this.fSeguro = fSeguro;
    }

    public Double getnCostoServicio() {
        return nCostoServicio;
    }

    public void setnCostoServicio(Double nCostoServicio) {
        this.nCostoServicio = nCostoServicio;
    }   
    
    public String[] toArray() {

        return new String[]{id_vehiculo,sDescripcion, fMantenimiento, fVerificacion, fSeguro, ""+nCostoServicio};

    }

    public String getsDescripcion() {
        return sDescripcion;
    }

    public void setsDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    
}
