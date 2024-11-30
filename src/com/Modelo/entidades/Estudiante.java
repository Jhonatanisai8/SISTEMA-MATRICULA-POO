package com.Modelo.entidades;

public class Estudiante
        extends Persona {

    private Long idEstudiante;
    private String codigoEstudiante;
    private String emailEducativo;
    private Apoderado apoderado;

    public Estudiante() {
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getEmailEducativo() {
        return emailEducativo;
    }

    public void setEmailEducativo(String emailEducativo) {
        this.emailEducativo = emailEducativo;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    @Override
    public String toString() {
        return idEstudiante + "-" + super.getNombre() + "-" + super.getApellidoPaterno() + "-"
                + super.getApellidoMaterno() + "-" + super.getFechaNacimiento() + "-" + super.getDni().getIdDni();
    }

}
