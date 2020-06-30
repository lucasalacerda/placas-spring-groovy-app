package com.lucas.senac.placas.repositories

import com.lucas.senac.placas.dto.Placa
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class PlacaRepository  {

    @Autowired
    MongoTemplate mongoTemplate

    Placa save(Placa placa) {
        return mongoTemplate.save(placa)
    }

    Placa findById(id) {
        return mongoTemplate.findById(id, Placa.class)
    }

    List<Placa> findAll() {
        return mongoTemplate.findAll(Placa.class)
    }
}
