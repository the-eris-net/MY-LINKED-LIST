package net.eris.the.no5;

import net.eris.the.no4.MyQueue;
import net.eris.the.no4.QueueInterface;
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

public class MyStackTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("pop 메서드 테스트")
    public void deleteTest(int range) {
        StackInterface<String> myStack = new MyStack<>();
        List<String> dest = new ArrayList<>(Arrays.asList("1st", "2nd", "3rd", "4th", "5th", "6th"));

        dest.forEach(myStack::push);
        for (int i = 0; i < range; i++) {
            myStack.pop();
            dest.remove(dest.size() - 1);
        }
        assertEquals(myStack.toString(), String.join(" -> ", dest));
    }

    @Test
    @DisplayName("peek 후 top 테스트")
    public void deleteTestIfOneValue() {
        StackInterface<String> myStack = new MyStack<>();
        String dest = "1st";
        myStack.push(dest);
        assertEquals(myStack.top(), dest);
        assertEquals(myStack.pop(), dest);
        assertEquals(myStack.toString(), "");
    }

    @Test
    @DisplayName("전체 delete 후 전체 add 후  전체 delete")
    public void deleteAddDeleteTest() {
        StackInterface<String> myStack = new MyStack<>();
        List<String> dest = new ArrayList<>(Arrays.asList("1st", "2nd", "3rd", "4th", "5th", "6th"));

        dest.forEach(myStack::push);
        assertEquals(myStack.toString(), String.join(" -> ", dest));
        //처음 삭제
        myStack.pop();
        assertEquals(myStack.toString(), String.join(" -> ", List.copyOf(dest).subList(0, dest.size()-1)));
        //전체 삭제
        IntStream.range(0, myStack.getSize()).forEach(i -> myStack.pop());
        assertEquals(myStack.toString(), "");
        //전체 추가
        dest.forEach(myStack::push);
        assertEquals(myStack.toString(), String.join(" -> ", dest));
        //전체 삭제
        IntStream.range(0, myStack.getSize()).forEach(i -> myStack.pop());
        assertEquals(myStack.toString(), "");
    }

    @Test
    @DisplayName("비어있을경우 테스트")
    public void validRangeTest() {
        StackInterface<String> myStack = new MyStack<>();

        // 빈상태에서 pop과 peek
        assertThrowsExactly(IndexOutOfBoundsException.class, myStack::pop);
        assertThrowsExactly(IndexOutOfBoundsException.class, myStack::top);
    }
}
