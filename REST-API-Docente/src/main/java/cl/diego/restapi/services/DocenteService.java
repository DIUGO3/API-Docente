package cl.diego.restapi.services;

import cl.diego.restapi.models.Docente;
import cl.diego.restapi.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository repository;

    public Docente crear(Docente docente) throws Exception {
        Optional<Docente> existente = repository.findByTipoDocumentoAndNumeroDocumento(
                docente.getTipoDocumento(), docente.getNumeroDocumento());

        if (existente.isPresent()) {
            throw new Exception("Ya existe un docente con este tipo y número de documento.");
        }
        return repository.save(docente);
    }

    public List<Docente> listar() {
        return repository.findAll();
    }

    public Docente actualizar(Long id, Docente docente) throws Exception {
        Docente existente = repository.findById(id).orElseThrow(() -> new Exception("Docente no encontrado."));

        existente.setNombres(docente.getNombres());
        existente.setApellidos(docente.getApellidos());
        existente.setEmail(docente.getEmail());
        existente.setEspecialidad(docente.getEspecialidad());
        // NOTA: tipoDocumento y numeroDocumento no deben cambiar
        return repository.save(existente);
    }

    public void eliminar(Long id) throws Exception {
        Docente existente = repository.findById(id).orElseThrow(() -> new Exception("Docente no encontrado."));
        repository.delete(existente);
    }
}
