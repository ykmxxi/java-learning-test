package collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimpleArrayListTest {

    @Test
    void 최소_사이즈보다_작은_크기의_리스트를_생성할_수_없다() {
        assertThatThrownBy(() -> new SimpleArrayList(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 크기가_0인_리스트에_값을_추가할_수_있다() {
        SimpleList simpleArrayList = new SimpleArrayList(0);

        assertThat(simpleArrayList.add("first")).isTrue();
        assertThat(simpleArrayList.size()).isEqualTo(1);
    }

    @Test
    void 크기가_모두_찬_배열을_동적으로_늘려가며_추가한다() {
        SimpleList simpleArrayList = new SimpleArrayList(1);
        simpleArrayList.add("first");

        assertThat(simpleArrayList.add("second")).isTrue();
        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

    @Test
    void 인덱스를_지정해_요소를_추가할_수_있다() {
        SimpleList simpleArrayList = new SimpleArrayList(2);
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
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.indexOf(value)).isEqualTo(expected);
    }

    @CsvSource(value = {"first,true", "second,false"})
    @ParameterizedTest
    void 값의_존재_여부를_알_수_있다(String value, boolean expected) {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");

        assertThat(simpleArrayList.contains(value)).isEqualTo(expected);
    }

    @Test
    void 해당_인덱스의_값을_삭제한다() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        assertThat(simpleArrayList.remove(1)).isEqualTo("second");
        assertThat(simpleArrayList.get(0)).isEqualTo("first");
        assertThat(simpleArrayList.get(1)).isEqualTo("third");
    }

    @Test
    void 해당_값을_삭제한다() {
        SimpleList simpleArrayList = new SimpleArrayList();
        simpleArrayList.add("first");
        simpleArrayList.add("second");
        simpleArrayList.add("third");

        assertThat(simpleArrayList.remove("second")).isTrue();
        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

}
