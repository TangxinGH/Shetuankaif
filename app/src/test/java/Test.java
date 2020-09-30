import kunpeng.App;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {
//    @Autowired  必须是一个springBean 类型的。
    @org.junit.jupiter.api.Test
    public void test1(){
        System.out.println("hello world");
    }
}
