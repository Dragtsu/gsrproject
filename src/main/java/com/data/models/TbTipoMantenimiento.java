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
public class TbTipoMantenimiento {
    
    private String tipo_mantenimiento;
    private String sDescripcion;
    private int id_tipo_mantenimiento;
    private final String SufijoTipoMantenimiento="TM";

    public String getTipo_mantenimiento() {
        return tipo_mantenimiento;
    }

    public void setTipo_mantenimiento(String tipo_mantenimiento) {
        this.tipo_mantenimiento = tipo_mantenimiento.replace(SufijoTipoMantenimiento,"");
    }

    public String getsDescripcion() {
        return sDescripcion;
    }

    public void setsDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public int getId_tipo_mantenimiento() {
        return id_tipo_mantenimiento;
    }

    public void setId_tipo_mantenimiento(int id_tipo_mantenimiento) {
        this.id_tipo_mantenimiento = id_tipo_mantenimiento;
    }
    
     public String[] toArray() {

        return new String[]{SufijoTipoMantenimiento+id_tipo_mantenimiento,tipo_mantenimiento, sDescripcion};

    }
    
}
