package com.financeModule.CRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Projects")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Project {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "descripcion", length = 1000)
    @JsonProperty("descripcion")
    private String descripcion;



    public Boolean hasSameId(String id){
        return (Objects.equals(id, this.id));
    }

    public Object getId() {
        return id;
    }


}





