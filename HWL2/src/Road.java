public class Road {
    private String name;
    private Type type;
    public enum Type{
        HIGHWAY,
        EXPRESS,
        COUNTRY
    }
    private Location loc1;
    private Location loc2;
    private int speedLimit;
    private float length;

    public Road(String name, Type type, Location loc1, Location loc2, int speedLimit, float length) {
        this.name = name;
        this.type = type;
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.speedLimit = speedLimit;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Location getLoc1() {
        return loc1;
    }

    public void setLoc1(Location loc1) {
        this.loc1 = loc1;
    }

    public Location getLoc2() {
        return loc2;
    }

    public void setLoc2(Location loc2) {
        this.loc2 = loc2;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", loc1=" + loc1.getName() +
                ", loc2=" + loc2.getName() +
                ", speedLimit=" + speedLimit +
                ", length=" + length +
                '}' + '\n';
    }

/*    @Override
    public boolean equals(Road road) {

        if(this.name == road.name &&
           this.type == road.type &&
           ((this.loc1 == road.loc1 && this.loc2 == road.loc2)||(this.loc2 == road.loc1 && this.loc1 == road.loc2)) &&
           this.speedLimit==road.speedLimit &&
           this.length==road.length)return true;
        else return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return speedLimit == road.speedLimit && Float.compare(road.length, length) == 0 && name.equals(road.name) && type == road.type && ((loc1.equals(road.loc1) && loc2.equals(road.loc2))||(loc1.equals(road.loc2) && loc2.equals(road.loc1)));
    }

}
