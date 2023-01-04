package org.jfernandezh.springcloud.msvc.beneficiarios.repositories;

import org.jfernandezh.springcloud.msvc.beneficiarios.models.entity.Beneficiario;
import org.springframework.data.repository.CrudRepository;

public interface BeneficiarioRepository extends CrudRepository<Beneficiario, Long> {
}
