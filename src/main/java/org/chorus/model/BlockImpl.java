package org.chorus.model;

import java.util.Objects;

public class BlockImpl implements Block {
    private String color;
    private String material;

    public BlockImpl(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BlockImpl block = (BlockImpl) o;
        return Objects.equals(color, block.color)
                && Objects.equals(material, block.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material);
    }

    @Override
    public String toString() {
        return "BlockImpl{"
                + "color='" + color + '\''
                + ", material='" + material + '\''
                + '}';
    }


}
