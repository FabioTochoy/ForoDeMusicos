package foromusicos.apirestreto.controller;

import foromusicos.apirestreto.domain.Topico;
import foromusicos.apirestreto.dto.TopicoRequest;
import foromusicos.apirestreto.dto.TopicoUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import foromusicos.apirestreto.repository.TopicoRepository;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        try {
            List<Topico> lista = repository.findAll();
            return ResponseEntity.ok(lista); // 200
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody TopicoRequest request) {

        if (request.titulo() == null || request.titulo().isBlank()) {
            return ResponseEntity.badRequest()
                    .body("El título es obligatorio"); // 400
        }

        try {
            Topico topico = new Topico(
                    request.titulo(),
                    request.mensaje(),
                    request.curso()
            );

            Topico guardado = repository.save(topico);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(guardado); // 201

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el tópico"); // 500
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build(); // 404
        }

        //403
        if (id == 1) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("No tienes permisos para eliminar este tópico"); // 403
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody TopicoUpdateRequest request
    ) {

        if (request.titulo() == null || request.titulo().isBlank()) {
            return ResponseEntity.badRequest()
                    .body("Título inválido"); // 400
        }

        return repository.findById(id)
                .map(topico -> {

                    topico.setTitulo(request.titulo());
                    topico.setMensaje(request.mensaje());
                    topico.setCurso(request.curso());

                    Topico actualizado = repository.save(topico);
                    return ResponseEntity.ok(actualizado); // 200
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }
}
