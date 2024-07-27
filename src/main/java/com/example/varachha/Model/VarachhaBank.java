package com.example.varachha.Model;

import com.example.varachha.Annotation.Fixsize;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank")
public class VarachhaBank {
    @Id
    @JsonProperty("acno")
    @Fixsize //custom annonation
    private Long accountNo;
    private Long balance;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;
}


