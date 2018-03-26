import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 按照规则对集合进行排序
 * 第一优先级：child（age<=12）->female->male
 * 第二优先级：point big->small
 */
public class ListSort {
    public static void main(String[] args) {
        List<Refugee> lists = new ArrayList<>();
        lists.add(new Refugee("lilei","male",11,120));
        lists.add(new Refugee("hanmeimei","female",10,126));
        lists.add(new Refugee("zhanglaoshi","male",54,100));
        lists.add(new Refugee("llaoshi ","female",41,150));
        lists.add(new Refugee("xiaozhang","female",75,155));
        lists.add(new Refugee("laozhuren","male",55,145));
        lists.add(new Refugee("shenayi","female",19,127));

        //排序
        Collections.sort(lists, new Comparator<Refugee>() {
            @Override
            public int compare(Refugee o1, Refugee o2) {
                //-1 前者优先  1 后者优先  0相等

                if(o1.age<=12 && o2.age >12){
                    return -1;
                } else if(o1.age>12 && o2.age <=12){
                    return 1;
                } else {
                    if("female".equals(o1.sex) && "male".equals(o2.sex)) {
                        return -1;
                    } else if("male".equals(o1.sex) && "female".equals(o2.sex)){
                        return 1;
                    } else {
                        if(o1.point > o2.point){
                            return -1;
                        } else if(o1.point < o2.point){
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        });

        lists.stream().forEach(System.out::println);
    }
}

class Refugee{
    String name;
    String sex;
    int age;
    int point;

    public Refugee(String name, String sex, int age, int point) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.point = point;
    }
    public String toString(){
        return name;
    }
}
