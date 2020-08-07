//饿汉式单列模式
/**
 *  线程安全，调用效率高，但是不能懒加载（使用的时候加载）。
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}

//懒汉式单例模式

/**
 * 线程安全，调用效率低下，但是可以实现懒加载
 */
class Singleton2{
    private static Singleton2 instance;

    private Singleton2(){}

    //为什么要加锁，因为可能有两个线程同时获取对象，可能会产生两个对象。
    private static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
            return instance;
        }
        return instance;
    }
}


//静态内部类实现单例模式（推荐使用的方式）
//线程安全，调用效率高，懒加载
class Singleton3{
    //构造函数（私有的）
    private Singleton3(){}

    //静态内部类
    private static class T{
        private static Singleton3 t = new Singleton3();

    }

    public static Singleton3 getInstance() {
        return T.t;
    }

}
