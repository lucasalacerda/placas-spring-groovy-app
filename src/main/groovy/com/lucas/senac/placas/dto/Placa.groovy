package com.lucas.senac.placas.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "placas")
class Placa {

    @Id
    String id
    Double altura
    Double largura
    String frase
    Double preco
    CorPlaca corFrase

    @Override
    String toString() {
        return "Placa{" +
                "id='" + id + '\'' +
                ", altura=" + altura +
                ", largura=" + largura +
                ", frase='" + frase + '\'' +
                ", corFrase=" + corFrase +
                '}';
    }
}
