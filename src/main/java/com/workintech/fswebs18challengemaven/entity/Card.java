package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "card", schema = "fsweb")
public class Card {
    @Id
    private Long id;

    @Column(name = "value")
    private Integer value;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    public void setValue(Integer value) {
        if (value != null && this.type != null && this.type != Type.JOKER) {
            throw new IllegalArgumentException("Kartın hem value hem de type değeri olamaz.");
        }
        if (this.type == Type.JOKER && value != null) {
            throw new IllegalArgumentException("JOKER kartın value değeri olamaz.");
        }
        this.value = value;
    }

    public void setType(Type type) {
        if (type != null && this.value != null) {
            throw new IllegalArgumentException("Kartın hem value hem de type değeri olamaz.");
        }

        this.type = type;

        if (this.type == Type.JOKER) {
            this.value = null;
            this.color = null;
        }
    }

    public void setColor(Color color) {
        if (this.type == Type.JOKER && color != null) {
            throw new IllegalArgumentException("JOKER kartın color değeri olamaz.");
        }
        this.color = color;
    }

}
