package fr.amani.entities;

import java.util.Collections;
import java.util.List;

public record Grid(int x, int y, List<Coordinates> obstacles) {
    public Grid(int x, int y) {
        this(x, y, Collections.emptyList());
    }

}
