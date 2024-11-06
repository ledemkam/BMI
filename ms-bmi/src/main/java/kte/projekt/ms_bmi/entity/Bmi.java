package kte.projekt.ms_bmi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;


@AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Entity
    @Table(name = "BMI")
    public  class Bmi {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private int height;
        private int weight;
        private LocalDateTime createdAt;

        @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
        @JoinColumn(name = "account_id")
        private Account account;

        @ManyToMany
        @JoinTable(
                name = "BMI_SUGGESTION",
                joinColumns = @JoinColumn(name = "bmi_id")
        )
        private Set<Suggestion> suggestions;
    }

