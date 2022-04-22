package org.chorus.model;

import java.util.List;

public class CompositeBlockImpl extends BlockImpl implements CompositeBlock {
    private final List<BlockImpl> blocks;

    public CompositeBlockImpl(String color, String material, List<BlockImpl> blocks) {
        super(color, material);
        this.blocks = blocks;
    }

    @Override
    public List<BlockImpl> getBlocks() {
        return blocks;
    }

    public int count() {
        // + 1 for the composite block itself
        return blocks.size() + 1;
    }
}
