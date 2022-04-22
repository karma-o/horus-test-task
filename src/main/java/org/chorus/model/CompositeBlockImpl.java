package org.chorus.model;

import java.util.List;
import java.util.Objects;

public class CompositeBlockImpl extends BlockImpl implements CompositeBlock {
    private List<Block> blocks;

    public CompositeBlockImpl(String color, String material, List<Block> blocks) {
        super(color, material);
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        // something wrong here
        // maybe recursion?
        return blocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CompositeBlockImpl that = (CompositeBlockImpl) o;
        return Objects.equals(blocks, that.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), blocks);
    }

    @Override
    public String toString() {
        return "CompositeBlockImpl{"
                + "blocks=" + blocks
                + "color=" + getColor()
                + "material=" + getMaterial()
                + '}';
    }

    @Override
    public int count() {
        return blocks.size() + 1;
    }
}
