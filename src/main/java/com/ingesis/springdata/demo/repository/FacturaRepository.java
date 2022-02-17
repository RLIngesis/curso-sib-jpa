package com.ingesis.springdata.demo.repository;

import com.ingesis.springdata.demo.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    Optional<Factura> findByNumeroFactura(Integer numeroFactura);

    List<Factura> findByIdVendedorOrderByFecha(Integer idVendedor);

}
