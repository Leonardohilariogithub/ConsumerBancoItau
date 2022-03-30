package com.example.Consumer.entidades;

import com.example.Consumer.Enums.EnumOperacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperacaoEntidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroDaConta;

    @Enumerated(EnumType.STRING)
    private EnumOperacao tipoDaOperacao;     //TRANSFERENCIA(1),SAQUE(2), DEPOSITO(3);

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR",
            timezone = "America/São_Paulo")
    private LocalDateTime dataHora = LocalDateTime.now();

}
