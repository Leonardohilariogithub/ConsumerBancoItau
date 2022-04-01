package com.example.Consumer.services;

import com.example.Consumer.entidades.ContaEntidade;
import com.example.Consumer.entidades.OperacaoEntidade;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class ContaServiceRedisSaque {

    private final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost",6379);

    public void criarSaquesGratuitosNoRedis(ContaEntidade contaEntidade) {

        Jedis jedis = pool.getResource();
        jedis.set(contaEntidade.getNumeroDaConta(), Integer.toString(contaEntidade.getSaqueSemTaxa()));

    }

    public void atualizarSaquesGratuitosNoRedis(OperacaoEntidade operacaoEntidade) {

        Jedis jedis = pool.getResource();

        Integer saqueGratuitos = Integer.parseInt((jedis.get(operacaoEntidade.getNumeroDaConta())));

        if(saqueGratuitos > 0){
            jedis.set(operacaoEntidade.getNumeroDaConta(), Integer.toString(saqueGratuitos -1));
        }
    }
}
