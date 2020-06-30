package com.lucas.senac.placas.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

import java.text.SimpleDateFormat

@Document(collection = "pedido")
class Pedido {

    @Id
    String id
    String dataEntrega
    List<String> placas
    Double valorServico
    Double valorSinal
    String dataPedido

    @Override
    String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", valorPedido=" + dataPedido +
                ", placas=" + placas +
                ", valorServico=" + valorServico +
                ", valorSinal=" + valorSinal +
                '}';
    }
}
