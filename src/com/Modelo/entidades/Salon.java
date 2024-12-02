package com.Modelo.entidades;

public class Salon {

    private Long idSalon;
    private String nombreSalon;
    private int capacidadEstudiantes;
    private String referencia;
    private int vacantesDisponibles;

    public Salon() {
    }

    public Long getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(Long idSalon) {
        this.idSalon = idSalon;
    }

    public void setVacantes(int vacantes) {
        this.vacantesDisponibles = vacantes;
    }

    public int getVacantes() {
        return vacantesDisponibles;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }

    public int getCapacidadEstudiantes() {
        return capacidadEstudiantes;
    }

    public void setCapacidadEstudiantes(int capacidadEstudiantes) {
        this.capacidadEstudiantes = capacidadEstudiantes;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
