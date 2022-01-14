package com.example.testjdk17;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

//@SpringBootTest
class TestJdk17ApplicationTests {

    @Test
    void contextLoads() {
        List<String> x = List.of("x", "xy");
        x.add("z");
        System.out.println(x);
    }

    @Test
    @SneakyThrows
    public void test2() {
        Optional<String> op = Optional.of("akdj");
        String s = op.orElseThrow();
        System.out.println(s);


    }

    @Test
    @SneakyThrows
    public void test() {
        String ans = getAns(3);
        System.out.println(ans);
    }

    private String getAns(int x) {
        return switch (x) {
            case 1, 2, 3 -> "haha";
            case 4, 5, 6 -> "gegege";
            default -> "hehe";
        };
    }

    @Test
    @SneakyThrows
    public void testStr3() {
        String str = """
                 {
                                    "firstName": "Piotr",
                                     "lastName": "Mińkowski"
                                }               

                """;

    }


}
