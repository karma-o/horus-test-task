package org.chorus;

import java.util.List;
import org.chorus.model.Block;
import org.chorus.model.BlockImpl;
import org.chorus.model.CompositeBlockImpl;
import org.chorus.model.Structure;
import org.chorus.model.Wall;

public class Main {
    public static void main(String[] args) {
        //testing methods:
        Block regular1 = new BlockImpl("blue", "brick");
        Block regular2 = new BlockImpl("yellow", "cement");
        Block composite = new CompositeBlockImpl("red","wood", List.of(regular1, regular2));
        Structure wall = new Wall(List.of(composite));

        System.out.println("wall.count() = " + wall.count());
        wall.findBlockByColor("yellow").get();
        wall.findBlocksByMaterial("brick").forEach(System.out::println);

        wall.findBlockByColor("blue").get();
        wall.findBlocksByMaterial("cement").forEach(System.out::println);

        wall.findBlockByColor("red").get();
        wall.findBlocksByMaterial("wood").forEach(System.out::println);
    }
}
