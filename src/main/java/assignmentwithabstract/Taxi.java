package assignmentwithabstract;

import java.util.HashSet;
import java.util.Set;

public class Taxi extends Transportation implements AbstractOperation {

    String destination = "";
    int distance = 0;
    int basic_distance = 1;
    int basic_fee = 3000;
    int feeperdis = 1000;
    int totalfee = 0;

    static Set taxilist = new HashSet();

    public Taxi(String number){
        if (taxilist.contains(number)){
            System.out.println("이미 있는 번호 입니다.");
        }else {
            super.number = number;
            max_people = 5;
            status = "일반";
            taxilist.add(number);
            System.out.println(number+"번 택시객체 만들어짐!");
        }

    }


    public void Taxi(int people){
        if (people>5){
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
            status = "운행 중";
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
            CheckGas();
        }
    }


    public int CalFee(){
        if(distance>1){
            return basic_fee+feeperdis*(distance-basic_distance);
        }
        else {
            return basic_fee;
        }
    }

    @Override
    public void Start() {
        status = "운행중";
        System.out.println("상태 : "+ status);
    }

    @Override
    public void Stop() {
        status = "운행불가";
        System.out.println("상태 : "+ status);
    }

    @Override
    public void GasControl(int fluctuation) {
        gas += fluctuation;
    }

    @Override
    public void SpeedChange(int fluctuation) {
        if(gas<=10){
            System.out.println("연료가 부족합니다.");
            Stop();
        }else {
            speed = fluctuation;
            System.out.println("변경된 속도 : "+speed);
        }
    }

    public void PeopleOff(){
        totalfee += CalFee();
        now_people = 0;
        this.destination = "";
        this.distance = 0;
        status = "일반";
    }

    @Override
    public void PeopleUp(int crowd) {
        if (crowd>max_people){
            System.out.println("정원을 초과하였습니다");
        }else {
            now_people = crowd;
        }

    }

    @Override
    public void PeopleDown(int crowd) {
        totalfee += CalFee();
        now_people = 0;
        this.destination = "";
        this.distance = 0;
    }

    @Override
    public void CheckGas() {
        if(gas<=10) {
            System.out.println("연료가 부족합니다.");
            Stop();
        }
    }
}