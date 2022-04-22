package org.chorus.model;

public interface Block {
    String getColor();

    String getMaterial();

    //added to be able to count all blocks in the stream
    default int count() {
        return 1;
    }
}
