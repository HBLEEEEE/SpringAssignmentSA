package assignment;

public class Transportation {

    String number;
    int gas = 100;
    int speed = 0;
    int changed_speed;
    int max_people;
    int now_people;

    String status = "";

    public void drive_On(){
        this.status = "운행중";
    }

    public void CheckStatus(){
        System.out.println(status);
    }

    public void speed_set(int changed_speed){
        speed += changed_speed;
    }

    public void ride_people(int people){
        if(now_people+people<=max_people){
            now_people += people;
            System.out.println("탑승 승객 수 = "+people);
            System.out.println("잔여 탑승 승객 수 = "+now_people);
        }else {
            System.out.println("최대 승객 수 초과");
        }
    }

    public static void main(String[] args) {
        Bus bus1 = new Bus("1");
        bus1.ride_people(2);
        bus1.OilShock(-50);
        bus1.bus_Off();
        bus1.OilShock(10);
        bus1.Bus();
        bus1.drive_On();
        bus1.ride_people(45);
        bus1.ride_people(5);
        bus1.Bus();
        bus1.OilShock(-55);
        bus1.Bus();

        System.out.println("--------------------");
        Taxi taxi1 = new Taxi("1");
        Taxi taxi2 = new Taxi("2");
        taxi1.Taxi();
        taxi1.Taxi(2,"서울역",2);
        taxi1.Taxi();
        taxi1.OilShock(-80);
        taxi1.TaxiArrive();
        taxi1.Taxi();
        taxi1.Taxi(5);
        taxi1.Taxi(3,"구로디지털단지역",12);
        taxi1.Taxi();
        taxi1.OilShock(-20);
        taxi1.TaxiArrive();
        taxi1.Taxi();
    }
}
