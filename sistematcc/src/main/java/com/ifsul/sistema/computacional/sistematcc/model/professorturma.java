package com.ifsul.sistema.computacional.sistematcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="professorTurma")
public class professorturma {
    @Column(nullable = false)
    private int professorId;

    @Column(nullable = false)
    private int turmaId;

   
}
