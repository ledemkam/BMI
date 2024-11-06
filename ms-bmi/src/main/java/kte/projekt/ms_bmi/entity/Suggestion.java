package kte.projekt.ms_bmi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SUGGESTION")
public class Suggestion {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      private String label;
      private String description;

}
