package collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimpleArrayListTest {

    @Nested
    @DisplayName("String 타입 SimpleArrayList")
    class SimpleStringList {

        @Test
        void 최소_사이즈보다_작은_크기의_리스트를_생성할_수_없다() {
            assertThatThrownBy(() -> new SimpleArrayList<>(-1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 크기가_0인_리스트에_값을_추가할_수_있다() {
            SimpleList<String> simpleArrayList = new SimpleArrayList<>(0);

            assertThat(simpleArrayList.add("first")).isTrue();
            assertThat(simpleArrayList.size()).isEqualTo(1);
        }

        @Test
        void 크기가_모두_찬_배열을_동적으로_늘려가며_추가한다() {
            SimpleList<String> simpleArrayList = new SimpleArrayList<>(1);
            simpleArrayList.add("first");

            assertThat(simpleArrayList.add("second")).isTrue();
            assertThat(simpleArrayList.size()).isEqualTo(2);
        }

        @Test
        void 인덱스를_지정해_요소를_추가할_수_있다() {
            SimpleList<String> simpleArrayList = new SimpleArrayList<>(2);
            simpleArrayList.add("first");
            simpleArrayList.add("third");

            simpleArrayList.add(1, "second");

            assertThat(simpleArrayList.get(0)).isEqualTo("first");
            assertThat(simpleArrayList.get(1)).isEqualTo("second");
            assertThat(simpleArrayList.get(2)).isEqualTo("third");
        }

        @CsvSource(value = {"first,0", "second,1", "none,-1"})
        @ParameterizedTest
        void 값의_인덱스를_조회할_수_있다(String value, int expected) {
            SimpleList<String> simpleArrayList = new SimpleArrayList<>();
            simpleArrayList.add("first");
            simpleArrayList.add("second");

            assertThat(simpleArrayList.indexOf(value)).isEqualTo(expected);
        }

        @CsvSource(value = {"first,true", "second,false"})
        @ParameterizedTest
        void 값의_존재_여부를_알_수_있다(String value, boolean expected) {
            SimpleList<String> simpleArrayList = new SimpleArrayList<>();
            simpleArrayList.add("first");

            assertThat(simpleArrayList.contains(value)).isEqualTo(expected);
        }

        @Test
        void 해당_인덱스의_값을_삭제한다() {
            SimpleList<String> simpleArrayList = new SimpleArrayList<>();
            simpleArrayList.add("first");
            simpleArrayList.add("second");
            simpleArrayList.add("third");

            assertThat(simpleArrayList.remove(1)).isEqualTo("second");
            assertThat(simpleArrayList.get(0)).isEqualTo("first");
            assertThat(simpleArrayList.get(1)).isEqualTo("third");
        }

        @Test
        void 해당_값을_삭제한다() {
            SimpleList<String> simpleArrayList = new SimpleArrayList<>();
            simpleArrayList.add("first");
            simpleArrayList.add("second");
            simpleArrayList.add("third");

            assertThat(simpleArrayList.remove("second")).isTrue();
            assertThat(simpleArrayList.size()).isEqualTo(2);
        }

    }

    @Nested
    @DisplayName("String 타입 SimpleArrayList")
    class SimpleIntegerList {

        @Test
        void 크기가_모두_찬_배열을_동적으로_늘려가며_추가한다() {
            SimpleList<Integer> simpleArrayList = new SimpleArrayList<>(1);
            simpleArrayList.add(1);

            assertThat(simpleArrayList.add(2)).isTrue();
            assertThat(simpleArrayList.size()).isEqualTo(2);
        }

        @Test
        void 인덱스를_지정해_요소를_추가할_수_있다() {
            SimpleList<Integer> simpleArrayList = new SimpleArrayList<>(2);
            simpleArrayList.add(1);
            simpleArrayList.add(3);

            simpleArrayList.add(1, 2);

            assertThat(simpleArrayList.get(0)).isEqualTo(1);
            assertThat(simpleArrayList.get(1)).isEqualTo(2);
            assertThat(simpleArrayList.get(2)).isEqualTo(3);
        }

        @CsvSource(value = {"1,0", "2,1", "3,-1"})
        @ParameterizedTest
        void 값의_인덱스를_조회할_수_있다(int value, int expected) {
            SimpleList<Integer> simpleArrayList = new SimpleArrayList<>();
            simpleArrayList.add(1);
            simpleArrayList.add(2);

            assertThat(simpleArrayList.indexOf(value)).isEqualTo(expected);
        }

        @CsvSource(value = {"1,true", "2,false"})
        @ParameterizedTest
        void 값의_존재_여부를_알_수_있다(int value, boolean expected) {
            SimpleList<Integer> simpleArrayList = new SimpleArrayList<>();
            simpleArrayList.add(1);

            assertThat(simpleArrayList.contains(value)).isEqualTo(expected);
        }

        @Test
        void 해당_인덱스의_값을_삭제한다() {
            SimpleList<Integer> simpleArrayList = new SimpleArrayList<>();
            simpleArrayList.add(1);
            simpleArrayList.add(2);
            simpleArrayList.add(3);

            assertThat(simpleArrayList.remove(1)).isEqualTo(2);
            assertThat(simpleArrayList.get(0)).isEqualTo(1);
            assertThat(simpleArrayList.get(1)).isEqualTo(3);
        }

        @Test
        void 해당_값을_삭제한다() {
            SimpleList<Integer> simpleArrayList = new SimpleArrayList<>();
            simpleArrayList.add(1);
            simpleArrayList.add(2);
            simpleArrayList.add(3);

            assertThat(simpleArrayList.remove(Integer.valueOf(1))).isTrue();
            assertThat(simpleArrayList.get(0)).isEqualTo(2);
            assertThat(simpleArrayList.size()).isEqualTo(2);
        }

    }

}
