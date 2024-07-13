package com.example.demo.repository;

import com.example.demo.model.AgendarTransferencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendarTransferenciaRepository extends CrudRepository<AgendarTransferencia, Long> {
}
