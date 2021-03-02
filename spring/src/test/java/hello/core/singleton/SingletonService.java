package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();


    private SingletonService(){}// 외부에서 new를 사용하여 인스턴스 생성 불가

    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }



}
