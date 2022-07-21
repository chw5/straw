package design.BuilderPattern;

/**
 * @Author: wzq
 * @Date: 2022/7/21
 * @Desc: 普通房子（具体建造者）
 **/
public class CommonHouseBuilder extends HouseBuilder{

    @Override
    public HouseBuilder buildBasic() {
        System.out.println("普通房子地基2米");
        return this;
    }

    @Override
    public HouseBuilder buildWalls() {
        System.out.println("普通房子墙厚0.4米");
        return this;
    }

    @Override
    public HouseBuilder buildRoofed() {
        System.out.println("普通房子屋顶");
        return this;
    }
}
