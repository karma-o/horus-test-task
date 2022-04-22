package org.chorus.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WallTest {
    private Block regular1;
    private Block regular2;
    private Block composite;
    private Structure wall;

    @BeforeEach
    void setUp() {
        regular1 = new BlockImpl("blue", "brick");
        regular2 = new BlockImpl("yellow", "cement");
        composite = new CompositeBlockImpl(
                "red","wood", List.of(regular1, regular2));
        wall = new Wall(List.of(composite));
    }

    @Test
    void findBlockByColor_ok() {
        Block expected = regular1;
        Block actual = wall.findBlockByColor("blue").get();
        assertEquals(expected, actual);
    }

    @Test
    void findBlockByColor_notOk() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wall.findBlockByColor("pink");
        });
    }

    @Test
    void findBlocksByMaterial_ok() {
        List<Block> expected = List.of(composite);
        List<Block> actual = wall.findBlocksByMaterial("wood");
        assertEquals(expected, actual);
    }
}
