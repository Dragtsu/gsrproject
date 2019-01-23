package com.data.models;

public class TbVigenciaServicios {

    private String tipo_servicio;
    private String id;
    private String descripcion;
    private String vigencia;
    private String dias_restantes;
    private String dias_vencidos;

    public String[] toArray() {
        return new String[]{tipo_servicio, id, descripcion, vigencia, dias_restantes, dias_vencidos};
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getDias_restantes() {
        return dias_restantes;
    }

    public void setDias_restantes(String dias_restantes) {
        this.dias_restantes = dias_restantes;
    }

    public String getDias_vencidos() {
        return dias_vencidos;
    }

    public void setDias_vencidos(String dias_vencidos) {
        this.dias_vencidos = dias_vencidos;
    }
}
