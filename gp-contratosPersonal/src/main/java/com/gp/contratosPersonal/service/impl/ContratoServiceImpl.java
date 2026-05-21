package com.gp.contratosPersonal.service.impl;

import com.gp.contratosPersonal.dto.*;
import com.gp.contratosPersonal.model.Contrato;
import com.gp.contratosPersonal.repository.ContratoRepository;
import com.gp.contratosPersonal.service.ContratoService;
import com.gp.contratosPersonal.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContratoServiceImpl implements ContratoService {

    private final ContratoRepository contratoRepository;
    private final PersonaClient personaClient;
    private final AfpClient afpClient;
    private final IsapreClient isapreClient;
    private final TipoContratoClient tipoContratoClient;
    private final CesantiaClient cesantiaClient;
    private final DireccionClient direccionClient;
    private final FaenaClient faenaClient;

    public ContratoServiceImpl(
            ContratoRepository contratoRepository,
            PersonaClient personaClient,
            AfpClient afpClient,
            IsapreClient isapreClient,
            TipoContratoClient tipoContratoClient,
            CesantiaClient cesantiaClient,
            DireccionClient direccionClient,
            FaenaClient faenaClient) {
        this.contratoRepository = contratoRepository;
        this.personaClient = personaClient;
        this.afpClient = afpClient;
        this.isapreClient = isapreClient;
        this.tipoContratoClient = tipoContratoClient;
        this.cesantiaClient = cesantiaClient;
        this.direccionClient = direccionClient;
        this.faenaClient = faenaClient;
    }

    @Override
    public ContratoResponseDto create(ContratoRequestDto dto) {
        log.info("Creando contrato para persona ID {}", dto.getIdPersona());

        Contrato contrato = new Contrato();
        contrato.setIdPersona(dto.getIdPersona());
        contrato.setIdAfp(dto.getIdAfp());
        contrato.setIdIsapre(dto.getIdIsapre());
        contrato.setIdTipoContrato(dto.getIdTipoContrato());
        contrato.setIdSeguroCesantia(dto.getIdSeguroCesantia());
        contrato.setIdDireccion(dto.getIdDireccion());
        contrato.setIdFaena(dto.getIdFaena());
        contrato.setSalario(dto.getSalario());
        contrato.setFechaInicio(dto.getFechaInicio());
        contrato.setFechaFin(dto.getFechaFin());

        Contrato saved = contratoRepository.save(contrato);
        log.info("Contrato creado con ID {}", saved.getId());

        return buildResponse(saved);
    }

    @Override
    public ContratoResponseDto findById(Integer id) {
        log.info("Buscando contrato con ID {}", id);
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        return buildResponse(contrato);
    }

    @Override
    public List<ContratoResponseDto> findAll() {
        log.info("Listando todos los contratos");
        return contratoRepository.findAll().stream().map(this::buildResponse).toList();
    }

    @Override
    public void delete(Integer id) {
        log.info("Eliminando contrato con ID {}", id);
        contratoRepository.deleteById(id);
    }

    private ContratoResponseDto buildResponse(Contrato contrato) {
        PersonaResponseDto persona = personaClient.getPersona(contrato.getIdPersona());
        AfpResponseDto afp = afpClient.getAfp(contrato.getIdAfp());
        IsapreResponseDto isapre = isapreClient.getIsapre(contrato.getIdIsapre());
        TipoContratoResponseDto tipoContrato = tipoContratoClient.getTipoContrato(contrato.getIdTipoContrato());
        CesantiaResponseDto cesantia = cesantiaClient.getSeguroCesantia(contrato.getIdSeguroCesantia());
        DireccionResponseDto direccion = direccionClient.getDireccion(contrato.getIdDireccion());
        FaenaResponseDto faena = faenaClient.getFaena(contrato.getIdFaena());

        ContratoResponseDto response = new ContratoResponseDto();
        response.setId(contrato.getId());

        //Datos personales:
        response.setRut(persona.getRut());
        response.setDv(persona.getDv());
        response.setNombre(persona.getNombre());
        response.setApellido(persona.getApellido());
        response.setFechaNacimiento(persona.getFechaNacimiento());
        response.setEstadoCivil(persona.getEstadoCivil());

        //Previsionales:
        response.setAfpNombre(afp.getNombre());
        response.setAfpPorcentaje(afp.getPorcentaje());
        response.setIsapreNombre(isapre.getNombre());
        response.setIsaprePorcentaje(isapre.getPorcentaje());

        //Contrato:
        response.setTipoContrato(tipoContrato.getNombre());
        response.setCotizacionCesantia(cesantia.getPorcentaje());

        //Dirección:
        response.setDireccionCompleta(direccion.getDireccionCompleta());

        //Faena:
        response.setFaenaNombre(faena.getNombre());
        response.setFaenaDescripcion(faena.getDescripcion());

        //Datos propios de este microservicio:
        response.setSalario(contrato.getSalario());
        response.setFechaInicio(contrato.getFechaInicio());
        response.setFechaFin(contrato.getFechaFin());

        return response;
    }
}
