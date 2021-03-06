package Stream.복습;

import Stream.스트림기본.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class 필터링_맵핑 {
    public static void main(String[] args) {

        //1. Dish형 리스트에 담겨있는 (menu)들의 음식 이름의 길이 (length)를 구하는 스트림을 작성하기.
        List<Integer> lengthOfMenu = Dish.menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(lengthOfMenu);

        //2. 중복된것을 제외할수있다.
        List<Integer> caloriesDistnct = Dish.menu.stream().map(Dish::getName).map(String::length).distinct().collect(Collectors.toList());
        System.out.println(caloriesDistnct);

        //3. 프레디케이트(filter)와 limit 사용하기.
        List<Dish> dishes = Dish.menu.stream().filter(d->d.getCalories() >300).limit(2).collect(Collectors.toList());
        System.out.println(dishes);

        //4. String형 배열을 한 단어씩 출력해보기.
        //map을 이용하여 ""로 새로운 배열을 만들고, 만들어진 배열을 하나의 스트림으로(flatMap)
        List<String> words = asList("Hello", "worlds");
        words.stream().map(s->s.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);

        String[][] namesArray = new String[][]{
                {"kim", "taeng"}, {"mad", "play"},
                {"kim", "mad"}, {"taeng", "play"}};

        Set<String> set = Arrays.stream(namesArray).flatMap(Arrays::stream).collect(Collectors.toSet());
        System.out.println(set);


        //소수 구하기
        System.out.println(isPrime(2));
        //효율적인 소수 구하기
        System.out.println(isPrime2(4));


    }
    //소수 구하기
    public static boolean isPrime(int n){
        return IntStream.range(2,n).noneMatch(s->n%s ==0);
    }

    public static boolean isPrime2(int n){
        int value = (int)Math.sqrt((double)n);
        return IntStream.rangeClosed(2,value).noneMatch(s->n%s == 0);
    }


}
