package test1;

@FunctionalInterface
/*支持函数式编程的接口中只能有一个方法，默认方法除外*/
public interface Customer {
    void service();
    default void print(){
        System.out.println("默认方法的方法体");
    }
}
