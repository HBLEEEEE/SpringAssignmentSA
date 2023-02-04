package assignment;

public class Bus extends Transportation{

    int BusFee = 1000;


    public Bus(String number){
        super.number = number;
        max_people = 30;
        System.out.println(number+"번 버스객체 만들어짐!");
    }

    public void bus_Off(){
        this.status = "차고지행";
        this.now_people = 0;
    }


    public void check_gas(){
        if (this.gas<10){
            System.out.println("주유 필요");
        }
        bus_Off();
    }

    public void OilShock(int oil){
        gas += oil;
        System.out.println("기름통 수치 변동 : "+ oil );
        check_gas();
    }

    public void change_speed(int changed_speed){
        if (this.gas<10){
            System.out.println("check gas plz");
            check_gas();
        }
        this.speed += changed_speed;
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
