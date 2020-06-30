package com.lucas.senac.placas.repositories

import com.lucas.senac.placas.dto.Pedido
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository


@Repository
class PedidoRepository {

    @Autowired
    MongoTemplate mongoTemplate

    Pedido save(Pedido pedido) {
        return mongoTemplate.save(pedido)
    }

    Pedido findById(id) {
        return mongoTemplate.findById(id, Pedido.class)
    }

    List<Pedido> findAll() {
        return mongoTemplate.findAll(Pedido.class)
    }

    Integer findAllByDate(String data) {
        Query query = new Query()
        query.addCriteria(Criteria.where("dataPedido").is(data))
        mongoTemplate.find(query, Pedido.class).size()
    }
}