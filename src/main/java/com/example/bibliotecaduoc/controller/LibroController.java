package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.dto.ClientRequest;
import com.example.bibliotecaduoc.mapper.LibroMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> agregarLibro(@Valid @RequestBody ClientRequest request, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> 
                errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(LibroService.saveLibro(LibroMapper.toModel(request)));
    }
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
