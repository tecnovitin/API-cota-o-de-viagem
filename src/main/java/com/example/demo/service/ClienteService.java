package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Cliente;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.mapper.ClienteMapper;
import com.example.demo.repository.IClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private IClienteRepository clienteRepository;

    // Busca todos os clientes
    public List<ClienteDTO> listar() {
        return clienteMapper
        .toDTOList(clienteRepository
        .findAll());
    }

    //Busca cliente por ID
    public Optional<ClienteDTO> buscarPorId(Long id) {
        return clienteRepository
        .findById(id)
        .map(clienteMapper::toDTO);
    }

    //Busca cliente por email
    public Optional<ClienteDTO> buscarPorEmail(String email) {
        return clienteRepository
        .findByEmail(email)
        .map(clienteMapper::toDTO);
    }


    //Cria um novo cliente
    public ClienteDTO salvar(ClienteDTO dto) {
        Optional<Cliente> clienteExistente = clienteRepository.findByEmail(dto.email);
        if (clienteExistente.isPresent()) {
            throw new RuntimeException("Ja existe um cliente cadastrado com este email");
        }

        Cliente cliente = clienteMapper.toEntity(dto);
        return clienteMapper.toDTO(clienteRepository.save(cliente));
    }

    //Atualiza o cliente existente
    public ClienteDTO atualizar(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository
                .findById(id).map(c -> {
                    if (!c.getEmail().equals(clienteDTO.email)) {
                        Optional<Cliente> clienteComEmail = clienteRepository.findByEmail(clienteDTO.email);
                        if (clienteComEmail.isPresent() && !clienteComEmail.get().getId().equals(id)) {
                            throw new RuntimeException("Ja existe outro cliente cadastrado com este email");
                        }
                    }

                    c.setNome(clienteDTO.nome);
                    c.setEmail(clienteDTO.email);
                    c.setTelefone(clienteDTO.telefone);
                    return c;
                }).orElseThrow(() -> {
                    throw new RuntimeException("Cliente nao encontrado");
                });

        Cliente clienteAtualizado = clienteRepository.save(cliente);
        return clienteMapper.toDTO(clienteAtualizado);
    }


    //Deleta cliente
    public void deletarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente nao encontrado");
        }
        clienteRepository.deleteById(id);
    }
}

