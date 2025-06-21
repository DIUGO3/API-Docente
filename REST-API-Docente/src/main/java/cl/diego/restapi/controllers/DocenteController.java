package cl.diego.restapi.controllers;

import cl.diego.restapi.models.Docente;
import cl.diego.restapi.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@Tag(name = "Docente Controller", description = "CRUD para entidad Docente")
public class DocenteController {

    @Autowired
    private DocenteService service;

    @PostMapping
    public Docente crear(@RequestBody Docente docente) throws Exception {
        return service.crear(docente);
    }

    @GetMapping
    public List<Docente> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public Docente actualizar(@PathVariable Long id, @RequestBody Docente docente) throws Exception {
        return service.actualizar(id, docente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) throws Exception {
        service.eliminar(id);
    }
}
