package com.Modelo.entidades;

public class ApoderadoDatos
        extends Persona {

    private Long idApoderado;
    private String nombreApoderado;
    private String relacionEstudiante;
    private String ocupacion;
    private String estadoCivil;

    public ApoderadoDatos() {
    }

    public Long getIdApoderado() {
        return idApoderado;
    }

    public String getNombreApoderado() {
        return nombreApoderado;
    }

    public void setNombreApoderado(String nombreApoderado) {
        this.nombreApoderado = nombreApoderado;
    }

    public void setIdApoderado(Long idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getRelacionEstudiante() {
        return relacionEstudiante;
    }

    public void setRelacionEstudiante(String relacionEstudiante) {
        this.relacionEstudiante = relacionEstudiante;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

}
