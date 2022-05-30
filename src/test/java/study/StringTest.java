package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String actual1 = "1,2";
        String actual2 = "1";

        String[] expected1 = actual1.split(",");
        String[] expected2 = actual2.split(",");

        /**
         * AssertJ contains Method
         * 중복여부, 순서를 상관쓰지 않는다.
         *
         * String 및 Collection에서 사용이 가능하다.
         */
        assertThat(expected1).contains("1", "2");

        /**
         * ContainsOnly
         * 순서,중복을 무시하는 대신 원소의 개수가 정확하게 일치해야한다.
         */
        assertThat(expected1).containsOnly("2", "1");


        /**
         * ContainsExactly
         * 원소의 개수 및 중복, 순서가 정확하게 일치해야 한다.
         */
        assertThat(expected2).containsExactly("1");
    }

    @Test
    @DisplayName("String의 length를 벗어나지 않을 때, charAt() 매소드 성공")
    void charAtIsSuccessWhenLengthIsValid() {
        String actual = "abc";

        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

    }

    @Test
    @DisplayName("String의 length를 벗어나지 않을 때, charAt() 매소드 성공")
    void charAtIsFailWhenLengthIsInValid() {
        String actual = "abc";
        int invalidIndex = actual.length() + (int) (Math.random() * 10);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char chr = actual.charAt(invalidIndex);
                });
    }
}
