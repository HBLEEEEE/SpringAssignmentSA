package assignmentwithabstract;

import java.util.HashSet;
import java.util.Set;

public class Bus extends Transportation implements AbstractOperation {

    int BusFee = 1000;

    static Set buslist = new HashSet();
    public Bus(String number){
        if (buslist.contains(number)){
            System.out.println("이미 있는 번호 입니다.");
        }else {
            super.number = number;
            max_people = 30;
            status = "운행중";
            buslist.add(number);
            System.out.println(number+"번 버스객체 만들어짐!");
        }
    }

    @Override
    public void Start() {
        status = "운행중";
        System.out.println("상태 : "+ status);
    }

    @Override
    public void Stop() {
        status = "차고지행";
        System.out.println("상태 : "+ status);
    }

    @Override
    public void GasControl(int fluctuation) {
        gas += fluctuation;
        if (gas<=10){
            Stop();
        }
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

    @Override
    public void PeopleUp(int crowd) {
        if (now_people+crowd>max_people){
            System.out.println("정원을 초과하였습니다");
        }else {
            now_people += crowd;

        }

    }

    @Override
    public void PeopleDown(int crowd) {
        now_people -= crowd;
    }


    @Override
    public void CheckGas() {
        if(gas<=10) {
            System.out.println("연료가 부족합니다.");
            Stop();
        }
    }



    public void Bus(){
        if(status.equals("차고지행")){
            System.out.println("상태 = "+status);
            System.out.println("주유량 = "+gas);
        }else {
            System.out.println("탑승 승객 수 = "+now_people);
            System.out.println("잔여 승객 수 = "+(max_people-now_people));
            System.out.println("요금 확인 = "+(BusFee*now_people));
        }
    }



}