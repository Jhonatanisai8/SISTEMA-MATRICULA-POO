package com.Modelo.entidades.InterfaceDao;

import java.util.List;

public interface Repositorio<T> {

    List<T> listar();

    T porDni(Long dni);

    void guardar(T t);

    void modificar(T t);

    void eliminar(Long id);

}
