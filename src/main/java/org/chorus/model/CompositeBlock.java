package org.chorus.model;

import java.util.List;

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}