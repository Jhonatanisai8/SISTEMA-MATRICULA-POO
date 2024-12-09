package com.Modelo.entidades;

    public class Apoderado
            extends Persona {

        private Long idApoderado;
        private String relacionEstudiante;
        private String ocupacion;
        private String estadoCivil;

    public Apoderado() {
    }

    public Long getIdApoderado() {
        return idApoderado;
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
