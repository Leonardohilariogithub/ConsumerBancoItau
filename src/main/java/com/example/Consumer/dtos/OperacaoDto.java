package com.example.Consumer.dtos;

import com.example.Consumer.Enums.EnumOperacao;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperacaoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroDaConta;

    @Enumerated(EnumType.STRING)
    private EnumOperacao tipoDaOperacao;     //TRANSFERENCIA(1),SAQUE(2), DEPOSITO(3);
}
