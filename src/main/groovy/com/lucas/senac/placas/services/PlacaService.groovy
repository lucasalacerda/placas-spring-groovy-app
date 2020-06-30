package com.lucas.senac.placas.services

import com.lucas.senac.placas.dto.Placa
import com.lucas.senac.placas.repositories.PlacaRepository
import org.bson.types.ObjectId
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlacaService {

    @Autowired
    private PlacaRepository placaRepository

    private static final Logger logger = LoggerFactory.getLogger(PlacaService.class);

    Placa save(Placa placa) {
        Double altura = placa.altura
        Double largura = placa.largura
        Double area = altura * largura
        Double custoMaterial = area * 146.3
        Double custoDesenho = placa.frase.size() * 0.32
        Double custoTotal = custoMaterial + custoDesenho
        placa.preco = custoTotal
        placaRepository.save(placa)
    }

    List<Placa> findAll() {
        placaRepository.findAll()
    }

    Placa findById(String id) {
        placaRepository.findById(id)
    }
}
