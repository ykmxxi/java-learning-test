package collection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void 링크드_리스트에_값을_추가한다() {
        SimpleList<String> simpleLinkedList = new SimpleLinkedList<>();

        assertThat(simpleLinkedList.add("first")).isTrue();
        assertThat(simpleLinkedList.add("second")).isTrue();
        assertThat(simpleLinkedList.add("third")).isTrue();
        assertThat(simpleLinkedList.get(0)).isEqualTo("first");
        assertThat(simpleLinkedList.get(1)).isEqualTo("second");
        assertThat(simpleLinkedList.get(2)).isEqualTo("third");
        assertThat(simpleLinkedList.size()).isEqualTo(3);
    }

}
