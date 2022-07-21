package design.BuilderPattern;

/**
 * @Author: wzq
 * @Date: 2022/7/21
 * @Desc: 客户端
 **/
public class Client {

    public static void main(String[] args) {
        CommonHouseBuilder commonHouseBuilder = new CommonHouseBuilder();
        HouseDirector director = new HouseDirector(commonHouseBuilder);
        director.constructHouse();//建造房子
    }
}
