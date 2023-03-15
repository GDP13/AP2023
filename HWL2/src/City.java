public class City extends Location {
 public int population;
 public City(String name, float x, float y,int pop) {
  setName(name);
  setX(x);
  setY(y);
  this.population=pop;
 }

 public int getPopulation() {
  return population;
 }

 public void setPopulation(int population) {
  this.population = population;
 }

 @Override
 public String toString() {
  return "City{" +
          "population=" + population +
          ", name='" + this.getName() + '\'' +
          ", x=" + this.getX() +
          ", y=" + this.getY() +
          '}' + '\n';
 }
}
