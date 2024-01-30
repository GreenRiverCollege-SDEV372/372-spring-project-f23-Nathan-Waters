package edu.greenriver.sdev.food.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String url;
    private String author;

    @ElementCollection
    private List<String> ingredients;
    @ElementCollection
    private List<String> method;

    //my constructors/access methods/toString is being generated

}
