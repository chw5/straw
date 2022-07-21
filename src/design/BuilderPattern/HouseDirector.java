package design.BuilderPattern;

/**
 * @Author: wzq
 * @Date: 2022/7/21
 * @Desc: 建造指挥者
 **/
public class HouseDirector {

    HouseBuilder houseBuilder = null;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse(){
        House house = houseBuilder.buildBasic()
                .buildRoofed()
                .buildWalls()
                .build();
        return house;
    }
}
