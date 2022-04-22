package org.chorus.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WallTest {
    private BlockImpl regular1;
    private BlockImpl regular2;
    private CompositeBlockImpl composite;
    private Structure wall;

    @BeforeEach
    void setUp() {
        regular1 = new BlockImpl("blue", "brick");
        regular2 = new BlockImpl("yellow", "cement");
        composite = new CompositeBlockImpl("red","wood", List.of(regular1, regular2));
        wall = new Wall(List.of(composite));
    }

    @Test
    void findBlockByColor_validData_ok() {
        Block expected = regular1;
        Block actual = wall.findBlockByColor("blue").get();
        assertEquals(expected, actual);
    }

    @Test
    void findBlocksByMaterial_ok() {
        List<Block> expected = List.of(composite);
        List<Block> actual = wall.findBlocksByMaterial("wood");
        assertEquals(expected, actual);
    }

    @Test
    void count_validData_ok() {
        int expected = 3;
        int actual = wall.count();
        assertEquals(expected, actual);
    }
}
