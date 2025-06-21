package cl.diego.restapi.repositories;

import cl.diego.restapi.models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
    Optional<Docente> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}


