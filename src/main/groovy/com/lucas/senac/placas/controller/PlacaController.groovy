package com.lucas.senac.placas.controller

import com.lucas.senac.placas.dto.Placa
import com.lucas.senac.placas.services.PlacaService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import java.util.function.DoubleBinaryOperator
import org.slf4j.Logger;

@RestController
@RequestMapping(path = "/placas")
class PlacaController {

    @Autowired
    private PlacaService placaService

    private static final Logger logger = LoggerFactory.getLogger(PlacaController.class);

    @RequestMapping(method = RequestMethod.POST)
    Placa createPlaca(@RequestBody Placa placa) {
        return placaService.save(placa)
    }

    @RequestMapping
    List<Placa> getAllPlacas() {
        placaService.findAll()
    }

}
