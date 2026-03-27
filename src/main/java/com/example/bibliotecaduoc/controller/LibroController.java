package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Libros")

public class LibroController {

    @Autowired
    private LibroService LibroService;

    @GetMapping
    public List<Libro> listaLibros() {
        return LibroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return LibroService.saveLibro(libro);
    }
    @GetMapping("{id}")
    public Libro buscaLibro(@PathVariable int id){
        return LibroService.getLibroId(id);
    }
    @PutMapping("{id}")
    public Libro actualizaLibro(@PathVariable int id, @RequestBody Libro libro){
        //el id lo usamos mas adelante
        return LibroService.updateLibro(libro);
    }
    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return LibroService.deleteLibro(id);
    }



}
