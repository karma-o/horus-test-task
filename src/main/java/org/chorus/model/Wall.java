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
    private final List<CompositeBlockImpl> composites;

    public Wall(List<CompositeBlockImpl> composites) {
        this.composites = composites;
    }

    // this method should return List because
    // it is possible that there are multiple blocks with the same color,
    // and I don't see any reason o return random element here
    @Override
    public Optional<Block> findBlockByColor(String color) {
        List<Block> result = new ArrayList<>();
        composites.stream()
                .filter(c -> c.getColor().equals(color))
                .forEach(result::add);
        composites.stream()
                .flatMap(c -> c.getBlocks().stream())
                .filter(b -> b.getColor().equals(color))
                .forEach(result::add);
        return result.parallelStream().findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> result = new ArrayList<>();
        composites.stream()
                .filter(c -> c.getMaterial().equals(material))
                .forEach(result::add);
        composites.stream()
                .flatMap(c -> c.getBlocks().stream())
                .filter(b -> b.getMaterial().equals(material))
                .forEach(result::add);
        return result;
    }

    public int count() {
        return composites.stream()
                .mapToInt(CompositeBlockImpl::count)
                .sum();
    }
}
