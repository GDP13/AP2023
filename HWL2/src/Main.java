import java.util.Stack;

public class Main {

    City loc1 = new City("city1",1,2,4354);
    City loc2 = new City("city2",2,2,4354);
    City loc3 = new City("city3",1,3,4354);

    Airport loc4 = new Airport("airport1",6,2,6);
    Airport loc5 = new Airport("airport2",9,423,10);
    Airport loc6 = new Airport("airport3",351,432,2);

    GasStation loc7 = new GasStation("gasstation1",3231,634,7.25);
    GasStation loc8 = new GasStation("gasstation2",31,34,9.25);
    GasStation loc9 = new GasStation("gasstation3",32,63,2.25);

    Road road1 = new Road("road1", Road.Type.HIGHWAY, loc1, loc4, 200, 200);
    Road road2 = new Road("road2", Road.Type.EXPRESS, loc1, loc7, 100, 150);
    Road road3 = new Road("road3", Road.Type.COUNTRY, loc1, loc8, 50, 250);
    Road road4 = new Road("road4", Road.Type.HIGHWAY, loc2, loc5, 200, 200);
    Road road5 = new Road("road5", Road.Type.EXPRESS, loc2, loc7, 100, 150);
    Road road6 = new Road("road6", Road.Type.COUNTRY, loc2, loc8, 50, 250);
    Road road7 = new Road("road7", Road.Type.HIGHWAY, loc3, loc6, 200, 200);
    Road road8 = new Road("road8", Road.Type.EXPRESS, loc3, loc9, 100, 150);
    Road road9 = new Road("road9", Road.Type.EXPRESS, loc4, loc7, 100, 150);
    Road road10 = new Road("road10", Road.Type.EXPRESS, loc5, loc8, 100, 150);
    Road road11 = new Road("road11", Road.Type.COUNTRY, loc6, loc9, 50, 250);

    Location[] locations={loc1,loc2,loc3,loc4,loc5,loc6,loc7,loc8,loc9};
    Road[] roads= {road1,road2,road3,road4,road5,road6,road7,road8,road9,road10,road11};

    public void print() {
        for (Road road : roads) {
            System.out.print(road.toString());
        }
        for (Location location : locations) {
            System.out.print(location.toString());
        }
    }

    public void validate(){
        if(validateRoadLenght()==0)return;
        System.out.println("valide road lengths");
        if(compareLocations()==0 )return;
        System.out.println("valide roads");
        if(compareRoads()==0 )return;
        System.out.println("valide locations");
        System.out.println("validated");
    }

    private int validateRoadLenght() {
        Location l1;
        Location l2;
        double euclDist;
        for (Road road : roads) {
            l1 = road.getLoc1();
            l2 = road.getLoc1();
            euclDist = Math.sqrt((l1.getX() - l2.getX()) * (l1.getX() - l2.getX()) + (l1.getY() - l2.getY()) * (l1.getY() - l2.getY()));
            if (euclDist > road.getLength()) {
                System.out.println("invalid length for" + road.getName());
                return 0;
            }
        }
        return 1;
    }

    private int compareRoads() {
        for(int i=0;i<roads.length-1;i++){
            for(int j=i+1;j<roads.length;j++){
                if(roads[i]==roads[j]){
                    System.out.println(roads[i].getName()+"="+roads[j].getName());
                    return 0;
                }
            }
        }
        return 1;
    }

    private int compareLocations() {
        for(int i=0;i<locations.length-1;i++){
            for(int j=i+1;j<locations.length;j++){
                if(locations[i]==locations[j]){
                    System.out.println(locations[i].getName()+"="+locations[j].getName());
                    return 0;
                }
            }
        }
        return 1;
    }

    private boolean isPath(Location l1, Location l2){
        Location[] isVisited = new Location[locations.length];
        int k=0;
        int i;
        int j;
        boolean ok = true;
        Stack<Location> stack=new Stack<Location>();
        stack.push(l1);
        while(!stack.isEmpty()) {
            l1 = stack.pop();
            if (l1 == l2) return true;
            else {
                for (i = 0; i < k; i++) {
                    if (l1 == isVisited[i]) ok = false;
                }
                if (ok) {
                    ok = true;
                    isVisited[k] = l1;
                    k++;
                    for (i = 0; i < roads.length; i++) {
                        if (l1 == roads[i].getLoc1()) {
                            for (j = 0; j < k; j++) {
                                if (roads[i].getLoc2() == isVisited[j]) ok = false;
                            }
                            if (ok) {

                                stack.push(roads[i].getLoc2());
                            }
                            ok = true;
                        }
                        if (l1 == roads[i].getLoc2()) {
                            for (j = 0; j < k; j++) {
                                if (roads[i].getLoc1() == isVisited[j]) ok = false;
                            }
                            if (ok) {

                                stack.push(roads[i].getLoc1());
                            }
                            ok = true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {;

        Main main = new Main();
        main.print();
        main.validate();
        if(main.isPath(main.locations[0],main.locations[6]))System.out.println("da");
        else System.out.println("nu");
        if(main.isPath(main.locations[1],main.locations[7]))System.out.println("da");
        else System.out.println("nu");
        if(main.isPath(main.locations[3],main.locations[4]))System.out.println("da");
        else System.out.println("nu");
        if(main.isPath(main.locations[2],main.locations[8]))System.out.println("da");
        else System.out.println("nu");
        if(main.isPath(main.locations[3],main.locations[8]))System.out.println("da");
        else System.out.println("nu");
        if(main.isPath(main.locations[1],main.locations[5]))System.out.println("da");
        else System.out.println("nu");
        if(main.isPath(main.locations[2],main.locations[7]))System.out.println("da");
        else System.out.println("nu");
    }

}