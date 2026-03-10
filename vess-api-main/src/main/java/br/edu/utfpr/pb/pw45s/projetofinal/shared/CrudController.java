package br.edu.utfpr.pb.pw45s.projetofinal.shared;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract class that defines the basic CRUD operations for a controller.
 * @param <ID> ID type
 * @param <E> Entity type
 * <D> DTO type
 */
public abstract class CrudController<ID extends Serializable, E extends Identifiable<ID>, D, R  extends CrudRepository<ID, E>, S extends CrudService<ID, E, R>> extends BaseController<ID, E, D> {

    @Autowired
    protected S service;

    public CrudController(Class<E> entityClass, Class<D> dtoClass) {
        super(entityClass, dtoClass);
    }

    @PostMapping
    public ResponseEntity<ID> create(@RequestBody @Valid D dto) {
        System.out.println("debug: " + dto);
        E entity = toEntity(dto);
        E savedEntity = service.save(entity);
        System.out.println("savedEntity: " + savedEntity);

        return new ResponseEntity<>(savedEntity.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ID> update(@RequestBody @Valid D dto, @PathVariable ID id) {
        E entity = toEntity(dto);
        entity.setId(id);
        E savedEntity = service.save(entity);
        return ResponseEntity.ok(savedEntity.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable ID id) {
        return service.findById(id)
                .map(entity -> ResponseEntity.ok(toDto(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<D>> findAll() {
        List<D> dtos = service.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}