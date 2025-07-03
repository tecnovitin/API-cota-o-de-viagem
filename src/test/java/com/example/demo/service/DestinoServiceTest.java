package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
@DisplayName("Deve deletar um destino")
void deveDeletarUmDestino() {
	
	}
}
