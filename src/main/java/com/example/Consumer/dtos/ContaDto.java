package com.example.Consumer.dtos;

import com.example.Consumer.Enums.EnumTipoDaConta;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String numeroDaConta;

    @Enumerated(EnumType.STRING)
    private EnumTipoDaConta tipoDaConta;      // PESSOA_FISICA, PESSOA_JURIDICA, GOVERNAMENTAL

    private int saqueSemTaxa;

}
