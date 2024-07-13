package com.example.demo.controller;

import com.example.demo.model.AgendarTransferencia;
import com.example.demo.repository.service.AgendarTransferenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agendar-transferencia")
@Api(value = "Agendar Transferencia", tags = "Agendar Transferencia")
public class AgendarTransferenciaConsultaController {

    @Autowired
    private AgendarTransferenciaService agendarTransferenciaService;

    @ApiOperation(value = "Retorna o beneficiario pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o pedido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public List<AgendarTransferencia> consultarAll() throws Exception {

        return agendarTransferenciaService.getAll();

    }
}

