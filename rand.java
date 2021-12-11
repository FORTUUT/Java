/*
*第三方类文件
*随机函数
*FORTUUT.rand;
*返回类型:Long  
*/
import java.util.Random;
 
public class rand {
    public static Long random2() {
        boolean[] numberList={true,true,true,true,true,true,true,true,true,true};// 0   1    2    3    4    5    6    7    8   9
        StringBuilder rndNumber=new StringBuilder();//存放随机数生成
        int numberLength=6;//需要生成多长的数字？最多9位数
        int i=numberLength;//长度计数器
        long aresult;//int aresult;
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
        aresult=Long.valueOf(rndNumber.toString());//Integer.valueOf(rndNumber.toString());
        return aresult;
    }
}