package assignmentwithabstract;

public class Transportation {

    public String number;
    int gas = 100;
    int speed = 0;
    public int max_people;
    int now_people;
    String status = "";



    public static void main(String[] args) {
        Bus bus1 = new Bus("1");
        bus1.PeopleUp(2);
        bus1.GasControl(-50);
        bus1.Stop();
        bus1.GasControl(10);
        bus1.Bus();
        bus1.Start();
        bus1.PeopleUp(45);
        bus1.PeopleUp(5);
        bus1.Bus();
        bus1.GasControl(-55);
        bus1.Bus();

//
        System.out.println("--------------------");
        Taxi taxi1 = new Taxi("1");
        Taxi taxi2 = new Taxi("2");
        taxi1.Taxi();
        taxi1.Taxi(2,"서울역",2);
        taxi1.Taxi();
        taxi1.GasControl(-80);
        taxi1.PeopleOff();
        taxi1.Taxi();
        taxi1.Taxi(5);
        taxi1.Taxi(3,"구로디지털단지역",12);
        taxi1.Taxi();
        taxi1.GasControl(-20);
        taxi1.PeopleOff();
        taxi1.Taxi();
    }
}