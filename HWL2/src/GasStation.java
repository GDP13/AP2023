public class GasStation extends Location {
    public double gasPrice;

    public GasStation(String name, float x, float y,double gp) {
        setName(name);
        setX(x);
        setY(y);
        this.gasPrice=gp;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "gasPrice=" + gasPrice +
                ", name='" + this.getName() + '\'' +
                ", x=" + this.getX() +
                ", y=" + this.getY() +
                '}' + '\n';
    }
}
