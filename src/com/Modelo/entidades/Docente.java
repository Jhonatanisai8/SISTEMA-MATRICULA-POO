package com.Modelo.entidades;

public class Docente
        extends Persona {

    private Long idDocente;
    private String codigoDocente;
    private String tituloAcademico;
    private int aniosExperiencia;
    private String emailEducativoDocente;

    public Docente() {
    }

    public Long getIdDocente() {
        return idDocente;
    }

    public String getEmailEducativoDocente() {
        return emailEducativoDocente;
    }

    public void setEmailEducativoDocente(String emailEducativoDocente) {
        this.emailEducativoDocente = emailEducativoDocente;
    }

    public void setIdDocente(Long idDocente) {
        this.idDocente = idDocente;
    }

    public String getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

}
