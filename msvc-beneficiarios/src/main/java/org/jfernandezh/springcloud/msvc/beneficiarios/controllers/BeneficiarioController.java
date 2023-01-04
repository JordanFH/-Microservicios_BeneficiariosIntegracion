package org.jfernandezh.springcloud.msvc.beneficiarios.controllers;

import org.jfernandezh.springcloud.msvc.beneficiarios.models.entity.Beneficiario;
import org.jfernandezh.springcloud.msvc.beneficiarios.services.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;

    @GetMapping
    public List<Beneficiario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Beneficiario> optional = service.buscarId(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Beneficiario beneficiario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(beneficiario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Beneficiario beneficiario, @PathVariable Long id) {
        Optional<Beneficiario> optional = service.buscarId(id);

        if (optional.isPresent()) {
            Beneficiario beneficiarioDB = optional.get();
            beneficiarioDB.setNombre(beneficiario.getNombre());
            beneficiarioDB.setDni(beneficiario.getDni());
            beneficiarioDB.setEdad(beneficiario.getEdad());
            beneficiarioDB.setCasado(beneficiario.getCasado());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(beneficiarioDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Beneficiario> optional = service.buscarId(id);
        if (optional.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
