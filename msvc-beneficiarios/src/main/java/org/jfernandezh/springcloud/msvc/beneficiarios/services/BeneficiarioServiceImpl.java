package org.jfernandezh.springcloud.msvc.beneficiarios.services;

import org.jfernandezh.springcloud.msvc.beneficiarios.models.entity.Beneficiario;
import org.jfernandezh.springcloud.msvc.beneficiarios.repositories.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Beneficiario> listar() {
        return (List<Beneficiario>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Beneficiario> buscarId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Beneficiario guardar(Beneficiario beneficiario) {
        return repository.save(beneficiario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
