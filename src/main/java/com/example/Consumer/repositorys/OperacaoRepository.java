package com.example.Consumer.repositorys;

import com.example.Consumer.entidades.OperacaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<OperacaoEntidade, Long> {


}
