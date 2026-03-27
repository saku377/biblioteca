package com.example.bibliotecaduoc.service;
import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository LibroRepository;

    public List<Libro> getLibros(){
        return LibroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro){
        return LibroRepository.guardar(libro);
    }

    public Libro getLibroId(int id){
        return LibroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return LibroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) {
        LibroRepository.eliminar(id);
        return "producto eliminado";
    }




}
