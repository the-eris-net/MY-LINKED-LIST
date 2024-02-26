package net.eris.the.no4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class MyQueueTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("pop 메서드 테스트")
    public void deleteTest(int range) {
        QueueInterface<String> myQueue = new MyQueue<>();
        List<String> dest = new ArrayList<>(Arrays.asList("1st", "2nd", "3rd", "4th", "5th", "6th"));

        dest.forEach(myQueue::push);
        for (int i = 0; i < range; i++) {
            myQueue.pop();
            dest.remove(0);
        }
        assertEquals(myQueue.toString(), String.join(" -> ", dest));
    }

    @Test
    @DisplayName("peek 후 pop 테스트")
    public void deleteTestIfOneValue() {
        QueueInterface<String> myQueue = new MyQueue<>();
        String dest = "1st";
        myQueue.push(dest);
        assertEquals(myQueue.peek(), dest);
        assertEquals(myQueue.pop(), dest);
        assertEquals(myQueue.toString(), "");
    }

    @Test
    @DisplayName("전체 delete 후 전체 add 후  전체 delete")
    public void deleteAddDeleteTest() {
        QueueInterface<String> myQueue = new MyQueue<>();
        List<String> dest = new ArrayList<>(Arrays.asList("1st", "2nd", "3rd", "4th", "5th", "6th"));

        dest.forEach(myQueue::push);
        assertEquals(myQueue.toString(), String.join(" -> ", dest));
        //처음 삭제
        myQueue.pop();
        assertEquals(myQueue.toString(), String.join(" -> ", List.copyOf(dest).subList(1, dest.size())));
        //전체 삭제
        IntStream.range(0, myQueue.getSize()).forEach(i -> myQueue.pop());
        assertEquals(myQueue.toString(), "");
        //전체 추가
        dest.forEach(myQueue::push);
        assertEquals(myQueue.toString(), String.join(" -> ", dest));
        //전체 삭제
        IntStream.range(0, myQueue.getSize()).forEach(i -> myQueue.pop());
        assertEquals(myQueue.toString(), "");
    }

    @Test
    @DisplayName("비어있을경우 테스트")
    public void validRangeTest() {
        QueueInterface<String> myQueue = new MyQueue<>();

        // 빈상태에서 pop과 peek
        assertThrowsExactly(IndexOutOfBoundsException.class, myQueue::pop);
        assertThrowsExactly(IndexOutOfBoundsException.class, myQueue::peek);
    }
}
