package assignment;

public class Taxi extends Transportation {

    String destination = "";
    int distance = 0;
    int basic_distance = 1;
    int basic_fee = 3000;
    int feeperdis = 1000;
    int totalfee = 0;

    public Taxi(String number){
        super.number = number;
        max_people = 4;
        status = "운행 중";
        System.out.println(number+"번 택시객체 만들어짐!");

    }



    public void Taxi(int people){
        if (people>max_people){
            System.out.println("최대 승객 수 초과");
        }else {
            now_people = people;
        }
    }
    public void Taxi(int people, String destination, int distance){
        if (people>5){
            System.out.println("최대 승객 수 초과");
        }else {
            now_people = people;
            this.destination = destination;
            this.distance = distance;
        }
    }

    public void Taxi(){
        if(now_people==0){
            System.out.println("주유량 = "+gas);
            System.out.println("상태: "+status);
            System.out.println("누적요금 = "+totalfee);
        }else {
            System.out.println("탑승 승객 수 = "+now_people);
            System.out.println("잔여 승객 수 = "+(max_people-now_people));
            System.out.println("기본 요금 확인 = "+basic_fee);
            System.out.println("목적지 = "+this.destination);
            System.out.println("목적지까지 거리 = "+this.distance + "km");
            System.out.println("지불할 요금 = "+CalFee());
            System.out.println("상태 = "+this.status);
        }
        if (gas<10){
            check_gas();
        }
    }

    public void TaxiArrive(){
        totalfee += CalFee();
        now_people = 0;
        this.destination = "";
        this.distance = 0;

    }

    public int CalFee(){
        if(distance>1){
            return basic_fee+feeperdis*(distance-basic_distance);
        }
        else {
            return basic_fee;
        }
    }

    public void Taxi_Off(){
        this.status = "운행불가";
        System.out.println("상태: "+status);
    }


    public void OilShock(int oil){
        gas += oil;
        System.out.println("기름통 수치 변동 : "+ oil );
    }


    public void check_gas(){
        if (this.gas<10){
            System.out.println("주유 필요");
            Taxi_Off();
        }

    }

    public void change_speed(int changed_speed){
        if (this.gas<10){
            System.out.println("check gas plz");
            check_gas();
        }
        this.speed += changed_speed;
    }
}
