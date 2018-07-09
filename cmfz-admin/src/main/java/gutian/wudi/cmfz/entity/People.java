package gutian.wudi.cmfz.entity;

/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-09 15:52
 **/
public class People {
    private String name;
    private Integer value;

    public People(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public People() {
    }
}
