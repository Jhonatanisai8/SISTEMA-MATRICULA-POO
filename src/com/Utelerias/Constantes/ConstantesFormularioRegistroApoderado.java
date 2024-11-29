package com.Utelerias.Constantes;

import javax.swing.ImageIcon;

public interface ConstantesFormularioRegistroApoderado {

    final ImageIcon ICONO_BOTON_GUARDAR = new ImageIcon("C:\\Users\\User\\Music\\CUARTO CICLO\\08 LABORATORIOS POO\\ProyectoMatriculaPOO\\src\\com\\imgs\\RegistroEstudiantes.png");
    final String[] PROVINCIAS = {"=Seleccionar=", "Amazonas", "Ancash", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cuzco", "Lima"};
    final String[] TIPO_DOCUMENTO = {"=Seleccionar=", "Dni", "Carnet De Extranjeria"};
    final String[] RELACION_ESTUDIANTE = {"=Seleccionar=", "Madre", "Padre", "Tutor Legal", "Abuelo", "Abuela"};
    final String[] OCUPACIONES = {
        "=Seleccionar=", "Programador", "Desarrollador web", "Analista de datos", "Ingeniero de software",
        "Diseñador gráfico", "Diseñador UX/UI", "Arquitecto de software", "Tester de software",
        "Cientifico de datos", "Ingeniero de datos", "Especialista en SEO", "Especialista en marketing digital",
        "Community manager", "Content manager", "Gerente de proyecto", "Consultor",
        "Doctor", "Enfermero", "Veterinario", "Farmacéutico",
        "Profesor", "Investigador", "Abogado", "Juez",
        "Artista", "Músico", "Escritor", "Actor",
        "Chef", "Mecánico", "Electricista"
    };
    final String[] ESTADO_CIVIL = {"=Seleccionar=", "Soltero", "Casado"};
    final String[] ENCABEZADOS_TABLA = {"DNI", "NOMBRES", "APP. PATERNO", "APP. MATERNO", "FECHA NACIMIENTO",
        "TIPO DE DOC. IDENTIDAD", "Nº DE DOC", "CALLE", "Nº DE CALLE", "DISTRITO",
        "PROVINCIA", "TELEFONO", "EMAIL PERSONAL", "RELACION CON ESTUDIANTE", "OCUPACION", "ESTADO CIVIL"};

}
