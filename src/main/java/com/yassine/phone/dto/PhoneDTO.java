package com.yassine.phone.dto;

import java.util.Date;

import com.yassine.phone.entities.Type;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneDTO {

private Long id;
    
    private String couleur;
    private String marque;
    private Date dateCreation;
    private double prix;
    private int ram;
    private int stockage;
    private String nomType;
    @ManyToOne
    private Type type;


}
