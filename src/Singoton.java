/**
 * 双层枷锁机制
 */
public class Singoton {
    //私有构造方法
    //私有静态的成员变量
    //公共静态的对外访问方法

    private Singoton(){}
    private volatile static Student student = null;
    public static Student getStudent(){

        if(student == null){
            synchronized (Singoton.class) {
                if(student == null) {
                    student = new Student();
                }
            }
        }
        return null;
    }
}
