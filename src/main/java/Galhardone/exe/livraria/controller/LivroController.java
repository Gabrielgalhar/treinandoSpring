package Galhardone.exe.livraria.controller;


import Galhardone.exe.livraria.Service.LivroService;
import Galhardone.exe.livraria.entity.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.creat(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Livro> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> getId(@PathVariable long id){
        return ResponseEntity.ok().body(service.getId(id));
    }
    @GetMapping
    public ResponseEntity<List<Livro>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }
    @PutMapping
    public ResponseEntity<Livro> update(@PathVariable long id, @RequestBody Livro obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }
}
