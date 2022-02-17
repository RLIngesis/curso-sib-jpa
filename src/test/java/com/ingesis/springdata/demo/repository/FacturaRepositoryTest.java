package com.ingesis.springdata.demo.repository;

import com.ingesis.springdata.demo.model.Factura;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FacturaRepositoryTest {
    @Autowired
    private FacturaRepository repository;

    @Test
    void shouldFindFacturaByNumeroFactura() {
        Optional<Factura> optionalFactura = repository.findByNumeroFactura(456567902);
        assertThat(optionalFactura).isPresent();
        Factura factura = optionalFactura.get();
        assertThat(factura.getIdFactura()).isEqualTo(12);
    }

    @Test
    void shouldFindFacturasVendedor() {
        List<Factura> facturas = repository.findByIdVendedorOrderByFecha(4);
        assertThat(facturas).hasSize(5);
    }

}
