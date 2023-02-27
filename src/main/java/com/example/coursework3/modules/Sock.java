package com.example.coursework3.modules;


import com.example.coursework3.utils.Validation;
import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Sock {

    private Color color;
    private Size size;
    private Integer compoundOfCotton;
    private Boolean presenceOnAStock;

    public Sock(Color color, Size size, Integer compoundOfCotton, Boolean presenceOnAStock) {
        this.color = color;
        this.size = size;
        Validation.checkPercent(compoundOfCotton);
        this.compoundOfCotton = compoundOfCotton;
        this.presenceOnAStock = presenceOnAStock;
    }
}
