package collection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void 링크드_리스트에_값을_추가한다() {
        SimpleList simpleLinkedList = new SimpleLinkedList();

        assertThat(simpleLinkedList.add("first")).isTrue();
        assertThat(simpleLinkedList.size()).isEqualTo(1);
    }

}
