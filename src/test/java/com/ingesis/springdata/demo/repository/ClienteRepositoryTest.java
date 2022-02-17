package com.ingesis.springdata.demo.repository;

import com.ingesis.springdata.demo.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository repository;

    @Test
    void shouldFindAll() {
        List<Cliente> clientes = repository.findAll();
        print(clientes);
        assertThat(clientes).hasSize(50);
    }

    @Test
    void shoulReturnCountEqualTo50() {
        long count = repository.count();
        assertThat(count).isEqualTo(50);
    }

    @Test
    void shouldRetrieveAllClientsWithGivenIds() {
        List<Integer> clienteIds = Arrays.asList(1, 20, 34);
        List<Cliente> clientes = repository.findAllById(clienteIds);
        print(clientes);
        assertThat(clientes).hasSize(3);
    }

    @Test
    void shouldFindAllSortedByNit() {
        List<Cliente> clientes = repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "nit"));
        print(clientes);
        assertThat(clientes).hasSize(50);
    }

    @Test
    void shouldReturnPageOneAndTwo() {
        Pageable pageable = Pageable.ofSize(30);
        Page<Cliente> clientesPage1 = repository.findAll(pageable.withPage(0));
        Page<Cliente> clientesPage2 = repository.findAll(pageable.withPage(1));
        assertThat(clientesPage1).hasSize(30);
        assertThat(clientesPage1.getTotalPages()).isEqualTo(2);
        assertThat(clientesPage1.getTotalElements()).isEqualTo(50);
        assertThat(clientesPage2).hasSize(20);
        print(clientesPage1.getContent());
        print(clientesPage2.getContent());
    }

    private void print(List<Cliente> clientes) {
        clientes.forEach(this::print);
    }

    private void print(Cliente cliente) {
        System.out.printf("Cliente: %s, %s\n", cliente.getNit(), cliente.getNombre());
    }
}
