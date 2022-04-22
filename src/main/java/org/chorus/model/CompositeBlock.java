package org.chorus.model;

import java.util.List;

public interface CompositeBlock extends Block {
    List<BlockImpl> getBlocks();
}
