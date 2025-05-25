package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Destino;
import com.example.demo.dto.DestinoDTO;
import com.example.demo.mapper.DestinoMapper;
import com.example.demo.repository.IDestinoRepository;

@Service
public class DestinoService {
        @Autowired
        private DestinoMapper destinoMapper;

        @Autowired
        private  IDestinoRepository destinoRepository;


        public void deletarDestino(Long id){
                destinoRepository.deleteById(id);
        }

        public List<DestinoDTO> listar(){
                return  destinoMapper
                .toDTOList(destinoRepository
                .findAll());


        }

        public Optional<DestinoDTO> buscarPorID(Long id){
                return destinoRepository
                .findById(id)
                .map(destinoMapper::toDTO);
        }
        public DestinoDTO atualizar(Long id, DestinoDTO destinoDTO){
                Destino localEx = destinoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Destino não encontrado"));
                


                localEx.setNome(destinoDTO.getNome());
                localEx.setDescricao(destinoDTO.getDescricao());
                localEx.setLocalizacao(destinoDTO.getLocalizacao());
                localEx.setPrecoPorPessoa(destinoDTO.getPrecoPorPessoa());
                
                Destino localAtualizado = destinoRepository.save(localEx);
                
                return destinoMapper.toDTO(localAtualizado);
                
                
                
        }
        public DestinoDTO salvar(DestinoDTO dto){
                Destino destino = destinoMapper.toEntity(dto);
                return  destinoMapper.toDTO(destinoRepository.save(destino));
        }
}
