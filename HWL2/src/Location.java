import java.util.Objects;

public class Location {
    private String name;
    private float x;
    private float y;

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location loaction = (Location) o;
        return Float.compare(loaction.x, x) == 0 && Float.compare(loaction.y, y) == 0 && Objects.equals(name, loaction.name);
    }
}
