package com.data.models;

public class TbTrabajador {

    private String Num_Celular;
    private String Nombre;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private String Vigencia_Licencia;

    public String getNum_Celular() {
        return Num_Celular;
    }

    public void setNum_Celular(String Num_Celular) {
        this.Num_Celular = Num_Celular;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String Apellido_Paterno) {
        this.Apellido_Paterno = Apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String Apellido_Materno) {
        this.Apellido_Materno = Apellido_Materno;
    }

    public String getVigencia_Licencia() {
        return Vigencia_Licencia;
    }

    public void setVigencia_Licencia(String Vigencia_Licencia) {
        this.Vigencia_Licencia = Vigencia_Licencia;
    }

    public String[] toArray() {

        return new String[]{Num_Celular, Nombre, Apellido_Paterno, Apellido_Materno, Vigencia_Licencia};

    }

}
