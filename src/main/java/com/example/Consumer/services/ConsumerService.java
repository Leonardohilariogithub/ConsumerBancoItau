package com.example.Consumer.services;

import com.example.Consumer.entidades.ContaEntidade;
import com.example.Consumer.entidades.OperacaoEntidade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    public static final String TOPICO_BANCO = "banco";
    public static final String GRUPO_ID = "meugrupoid";

    @Autowired
    private ContaService contaService;

    @KafkaListener(topics = TOPICO_BANCO,groupId = GRUPO_ID, containerFactory = "consumerFactoryConta")   //conta
    public void listen(ContaEntidade contaEntidade) {
        logger.info("Messagem recebida" + contaEntidade.toString());

        contaService.criarSaquesGratuitosNoRedis(contaEntidade);
    }

    @KafkaListener(topics = TOPICO_BANCO,groupId = GRUPO_ID, containerFactory = "consumerFactoryOperacao")//Operacao - Saque
    public void listen(OperacaoEntidade operacaoEntidade) {
        logger.info("Messagem recebida" + operacaoEntidade.toString());

        contaService.atualizarSaquesGratuitosNoRedis(operacaoEntidade);
    }
}

