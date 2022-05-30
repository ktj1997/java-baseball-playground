package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUpTest() {
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    void setSizeTest() {
        assertThat(numbers.size()).isGreaterThan(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void setContainTestWithValueSourceTest(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","2,true","3,true","4,true","5,false"})
    void setContainTestWithCsvSourceTest(int number, String isContain){
        if(isContain.equals("true")){
           assertThat(numbers.contains(number)).isTrue();
        }else{
            assertThat(numbers.contains(number)).isFalse();
        }
    }
}
