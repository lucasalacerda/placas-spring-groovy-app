package com.lucas.senac.placas.services

import com.lucas.senac.placas.dto.Pedido
import com.lucas.senac.placas.repositories.PedidoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository

    Pedido savePedido(Pedido pedido) {
        pedidoRepository.save(pedido)
    }

    Pedido findById(String id) {
        pedidoRepository.findById(id)
    }

    List<Pedido> findAll() {
        pedidoRepository.findAll()
    }

    Integer findByDate(String date) {
        pedidoRepository.findAllByDate(date)
    }
}
