package design.BuilderPattern;

/**
 * @Author: wzq
 * @Date: 2022/7/21
 * @Desc: 抽象构造者
 **/
public abstract class HouseBuilder {

    private House house = new House();

    //建造流程的抽象方法
    public abstract HouseBuilder buildBasic();

    public abstract HouseBuilder buildWalls();

    public abstract HouseBuilder buildRoofed();

    public House build(){
        return house;
    }

}
