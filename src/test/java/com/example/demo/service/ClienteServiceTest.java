package com.example.demo.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import static org.mockito.BDDMockito.*;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Entities.Cliente;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.mapper.ClienteMapper;
import com.example.demo.repository.IClienteRepository;


@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {


@Mock
private IClienteRepository clienteRepository;


private ClienteMapper clienteMapper = Mappers.getMapper(ClienteMapper.class);

@InjectMocks
private ClienteService clienteService;




@BeforeEach
void setUp() {
	org.springframework.test.util.ReflectionTestUtils.setField(
			clienteService,
			"clienteMapper",
			clienteMapper
			);
}

@Test
@DisplayName("Deve salvar um novo cliente com sucesso")
void deveSalvarClienteComSucesso() {
	
	ClienteDTO dtoTeste = new ClienteDTO();
	dtoTeste.nome = "Victor Gabriel";
	dtoTeste.email ="victor@gmail.com";
	dtoTeste.telefone = "44998653225";
	
	given(clienteRepository.findByEmail(dtoTeste.email)).willReturn(Optional.empty());
	
	given(clienteRepository.save(any(Cliente.class))).willAnswer(invocation ->{
			Cliente clientePassado = invocation.getArgument(0);
			clientePassado.setId(1L);
			return clientePassado;
	});
	
	
	ClienteDTO clienteDTOSalvo = clienteService.salvar(dtoTeste);
	
		then(clienteRepository).should(times(1)).save(any(Cliente.class));
		assertThat(clienteDTOSalvo).isNotNull();
		assertThat(clienteDTOSalvo.nome).isEqualTo("Victor Gabriel");

	
	}
@Test
@DisplayName("Deve lançar exeção ao tentar salvar cliente com e-mail duplicado")
void deveLancarExececaoComEmailExistir() {
	
	
	ClienteDTO dtoComEmailRepetido = new ClienteDTO();
	dtoComEmailRepetido.email ="emailexistente@gmail.com";
	given(clienteRepository
			.findByEmail("emailexistente@gmail.com"))
			.willReturn(Optional.of(new Cliente()));
	
	Throwable throwable = catchThrowable(() -> clienteService.salvar(dtoComEmailRepetido));
	assertThat(throwable).isInstanceOf(RuntimeException.class).hasMessage("Ja existe um cliente cadastrado com este email");
	
	then(clienteRepository).should(never()).save(any(Cliente.class));
	
	
}
		
		
		
		
}

