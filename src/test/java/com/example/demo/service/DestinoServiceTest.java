package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;

import java.math.BigDecimal;
import java.util.Optional;

import com.example.demo.Entities.Destino;
import com.example.demo.dto.DestinoDTO;
import com.example.demo.mapper.DestinoMapper;
import com.example.demo.repository.IDestinoRepository;

@ExtendWith(MockitoExtension.class)
public class DestinoServiceTest {

	@Mock
	private IDestinoRepository destinoRepository;
	
	private DestinoMapper destinoMapper = Mappers.getMapper(DestinoMapper.class);
	
	@InjectMocks
	private DestinoService destinoService;
	
@BeforeEach
void setUp() {
	org.springframework.test.util.ReflectionTestUtils.setField(
			destinoService,
			"destinoMapper",
			destinoMapper
			
			
			);
	}



@Test

@DisplayName("Deve salvar um novo Desino com sucesso")

void deveSalvarNovoDestino() {


DestinoDTO dtoTeste = new DestinoDTO();

dtoTeste.nome ="Matinhos";

dtoTeste.descricao= "Descrição do local";

dtoTeste.localizacao = "Paraná";

dtoTeste.precoPorPessoa = new BigDecimal("20.00");


given(destinoRepository.findByNome(dtoTeste.nome)).willReturn(Optional.empty());



given(destinoRepository.save(any(Destino.class))).willAnswer(invocation ->{

Destino destino = invocation.getArgument(0);

destino.setId(1L);

return destino;

});


DestinoDTO dtoTesteSalvo = destinoService.salvar(dtoTeste);

then(destinoRepository).should(times(1)).save(any(Destino.class));

assertThat(dtoTesteSalvo).isNotNull();

assertThat(dtoTesteSalvo.nome).isEqualTo("Matinhos");
}

@Test
@DisplayName("Deve deletar um destino")
void deveDeletarUmDestino() {
	
	
	}
}
