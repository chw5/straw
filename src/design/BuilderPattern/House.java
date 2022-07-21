package design.BuilderPattern;

/**
 * @Author: wzq
 * @Date: 2022/7/21
 * @Desc: 产品（房子）
 **/
public class House {

    private String basic;//地基

    private String wall;//墙

    private String roofed;//屋顶

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
