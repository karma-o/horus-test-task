package org.chorus.model;

import java.util.List;
import java.util.Optional;

public interface Structure {
    // returns any element with the given color
    Optional<Block> findBlockByColor(String color);

    // returns all elements with the given material
    List<Block> findBlocksByMaterial(String material);

    // returns the total number of elements that make up the structure
    int count();
}
