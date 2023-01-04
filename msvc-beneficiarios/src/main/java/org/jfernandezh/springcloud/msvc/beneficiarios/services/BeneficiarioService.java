package org.jfernandezh.springcloud.msvc.beneficiarios.services;

import org.jfernandezh.springcloud.msvc.beneficiarios.models.entity.Beneficiario;

import java.util.List;
import java.util.Optional;

public interface BeneficiarioService {

    List<Beneficiario> listar();

    Optional<Beneficiario> buscarId(Long id);

    Beneficiario guardar(Beneficiario beneficiario);

    void eliminar(Long id);
}
