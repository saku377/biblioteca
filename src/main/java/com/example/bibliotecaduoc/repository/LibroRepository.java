package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

}
