package com.example.demo.controller;

import com.example.demo.model.dto.AgendarTransferenciaDTO;
import com.example.demo.model.dto.AgendarTransferenciaReturnDTO;
import com.example.demo.repository.service.AgendarTransferenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agendar-transferencia")
@Api(value = "Agendar Transferencia", tags = "Agendar Transferencia")
public class AgendarTransferenciaController {

    @Autowired
    private AgendarTransferenciaService agendarTransferenciaService;

    @ApiOperation(value = "Retorna o beneficiario pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o pedido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public AgendarTransferenciaReturnDTO agendarTransferencia(@RequestBody AgendarTransferenciaDTO agendarTransferenciaDTO){

        return null;
    }

}
