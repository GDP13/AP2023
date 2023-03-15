public class Airport extends Location {
    public int noTerminals;

    public Airport(String name, float x, float y,int nt) {
        setName(name);
        setX(x);
        setY(y);
        this.noTerminals=nt;
    }

    public int getNoTerminals() {
        return noTerminals;
    }

    public void setNoTerminals(int noTerminals) {
        this.noTerminals = noTerminals;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "noTerminals=" + noTerminals +
                ", name='" + this.getName() + '\'' +
                ", x=" + this.getX() +
                ", y=" + this.getY() +
                '}' + '\n';
    }
}
