package org.chorus.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Task description:
 *
 * Below, we submit a task with a request to analyze the following code
 * and implement the findBlockByColor, findBlocksByMaterial, and count methods
 * in the Wall class - preferably avoiding code duplication and placing all logic in the Wall class.
 * Including in the analysis and implementation of the CompositeBlock interface!
 */
public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    // this method should return List because
    // it is possible that there are multiple blocks with the same color,
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
        // may be findFirst(), it depends on the use case,
        // but we rarely use those methods
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        // I want to flat map in some way
        List<Block> result = new ArrayList<>();
        blocks.stream().flatMap()

    }

    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(Block::count)
                .sum();
    }
}
