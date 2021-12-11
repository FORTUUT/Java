import java.util.Random;
import java.time.LocalDate;

public class transport {
    public static void main(String[] args) {
    	cars[] acar = new cars[200];
    	weihus[] aweihu = new weihus[200];
    	Money[] aMoney = new Money[200];

    	for(int i=0,a=0;i<200;i++) {
    		if(i%4 == 0 && i>=4)
    			a++;
    		acar[i] = new cars(i+333,a);
    	}
    	for(int i=0;i<200;i++) {
    		int year = 2000+(int)(double)test6.ace()%20;
    		int month = (int)(double)test6.ace()%12+1;
    		int day = (int)(double)test6.ace()%28+1;
    		aweihu[i] = new weihus(year,month,day);
    	}
        for(int i=0;i<200;i++) {
    		int year = 2000+(int)(double)test6.ace()%20;
    		int month = (int)(double)test6.ace()%12+1;
    		int day = (int)(double)test6.ace()%28+1;
            int Money = (int)(double)test6.ace()%20000+3000;
    		aMoney[i] = new Money(year,month,day,Money);
    	}
    	for(cars e:acar) {
    		System.out.println("insert into 车辆 values("+e.getCarNum()+","+e.getTimes()+","+e.getDepotNum()+")");
    	}
    	int a=0;
    	for(weihus e:aweihu) {
    		System.out.println("insert into 维护 values("+"'"+e.getDate()+"'"+","+acar[a].getCarNum()+","+e.getMoney()+")");
    		a++;
    	}
        int b=0;
        for(Money e: aMoney){
            System.out.println("insert into 资产 values("+"'"+e.getDate()+"'"+","+(acar[b].getDepotNum()-200)+","+e.getMoney()+")");
            b++;
        }
    }
}

class cars{
    private int carNum;
    private Long times;
    private int depotNum;

    public cars(int carNum,int depotNum){
        this.carNum = 6825000+carNum;
        this.times = test6.ace()%100+1;
        this.depotNum = 202100+depotNum;
    }

    public int getCarNum(){
        return carNum;
    }
    public Long getTimes(){
        return times;   
    }
    public int getDepotNum(){
        return depotNum;
    }
    public void setTimes(Long times){
        this.times = times;
    }
}

class weihus {
    private LocalDate time;
    private Long money;

    public weihus(int year,int month,int day){
        this.money = test6.ace()%5000+5000;
        this.time = LocalDate.of(year,month,day);
    }

    public Long getMoney() {
        return money;
    }
    public LocalDate getDate(){
        return time;
    }
}

class Money{
    private LocalDate date;
    private int Money;

    public Money(int year,int month,int day,int Money){
        this.date = LocalDate.of(year,month,day);
        this.Money = Money;
    }

    public LocalDate getDate(){
        return date;
    }
    public int getMoney(){
        return Money;
    }
}

class test6{
    public static Long ace(){
        boolean[] numberList={true,true,true,true,true,true,true,true,true,true};
        StringBuilder rndNumber=new StringBuilder();//存放随机数生成
        int numberLength=9;//需要生成多长的数字？最多9位数
        int i=numberLength;//长度计数器
        Long result1;//int result;
        Random rnd=new Random();
        while(i>0){
            int rndOffset=rnd.nextInt(10);
            if(rndOffset==0 && i==numberLength) continue;//解决新数列中第一位可能是0的bug
            if(numberList[rndOffset]){
                rndNumber.append(rndOffset);//添加到新数列
                numberList[rndOffset]=false;//从源数列中移除已使用的数字
                i--;//距离我们需要的长度又接近了1
            }
        }
        result1 = Long.valueOf(rndNumber.toString());
        return result1;
    }
}