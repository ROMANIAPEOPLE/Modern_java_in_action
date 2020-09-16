package the_java;

public interface Fooo {
    void printName();


    /**
     * @implSpec  이 구현체는 getName()으로 출력된 문자열을 대문자로 바꿔서 출력한다.
     */

    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    String getName();
}
