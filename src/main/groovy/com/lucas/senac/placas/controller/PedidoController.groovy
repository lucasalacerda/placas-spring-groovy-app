package com.lucas.senac.placas.controller

import com.lucas.senac.placas.dto.Pedido
import com.lucas.senac.placas.services.PedidoService
import com.lucas.senac.placas.services.PlacaService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping(path = "/pedido")
class PedidoController {

    @Autowired
    private PedidoService pedidoService

    @Autowired
    private PlacaService placaService

    private static final Logger logger = LoggerFactory.getLogger(PlacaService.class);

    @RequestMapping(method = RequestMethod.POST)
    Pedido savePedido(@RequestBody Pedido pedido) {
        Double valorServico = 0
        pedido.placas.forEach({ id ->
            valorServico = valorServico + placaService.findById(id).preco
        })
        pedido.valorServico = valorServico
        pedido.valorSinal = valorServico * 0.5
        String dataPedido = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
        String dataEntrega = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
        pedido.dataPedido = dataPedido

        if(pedidoService.findByDate(dataEntrega) <= 6) {
            pedido.dataEntrega = dataEntrega
        }
        else {
            pedido.dataEntrega = LocalDate.now().from(new Date().toInstant().atZone(ZoneId.of("UTC")).plusDays(1)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        }
        logger.info(dataPedido)
        pedidoService.savePedido(pedido)
    }
}
