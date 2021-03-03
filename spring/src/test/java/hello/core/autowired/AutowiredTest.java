package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOptin(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){ ///주입할 대상이 없으면 메서드 자체 호출 x
            System.out.println("member1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ // 주입할 대상이 없으면 null 입력
            System.out.println("member2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional <Member> noBean3){ //주입할 대상이 없으면 Optional.empty 입력
            System.out.println("member3 = " + noBean3);
        }
    }

}
