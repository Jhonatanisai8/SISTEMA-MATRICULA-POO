package com.Modelo.entidades;

public class Dni {

    private Long idDni;
    private String tipoDocumentoDni;
    private String numeroDni;

    public Dni() {
    }

    public Long getIdDni() {
        return idDni;
    }

    public void setIdDni(Long idDni) {
        this.idDni = idDni;
    }

    public String getTipoDocumentoDni() {
        return tipoDocumentoDni;
    }

    public void setTipoDocumentoDni(String tipoDocumentoDni) {
        this.tipoDocumentoDni = tipoDocumentoDni;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

}
