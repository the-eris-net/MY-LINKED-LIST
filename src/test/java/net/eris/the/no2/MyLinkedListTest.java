package net.eris.the.no2;

import net.eris.the.common.LinkedListInterface;
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

public class MyLinkedListTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("delete 메서드 테스트")
    public void deleteTest(int targetIndex) {
        LinkedListInterface<String> myLinkedList = new MyLinkedList<>();
        List<String> dest = new ArrayList<>(Arrays.asList("1st", "2nd", "3rd", "4th", "5th", "6th"));

        dest.forEach(myLinkedList::add);
        myLinkedList.delete(targetIndex);
        dest.remove(targetIndex);
        assertEquals(myLinkedList.toString(), String.join(" -> ", dest));
    }

    @Test
    @DisplayName("delete 메서드 테스트 - 1개만 남았을 때")
    public void deleteTestIfOneValue() {
        LinkedListInterface<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("1st");
        myLinkedList.delete(0);
        assertEquals(myLinkedList.toString(), "");
        assertEquals(myLinkedList.getSize(), 0);
    }

    @Test
    @DisplayName("전체 delete 후 전체 add 후  전체 delete")
    public void deleteAddDeleteTest() {
        LinkedListInterface<String> myLinkedList = new MyLinkedList<>();
        List<String> dest = new ArrayList<>(Arrays.asList("1st", "2nd", "3rd", "4th", "5th", "6th"));

        dest.forEach(myLinkedList::add);
        assertEquals(myLinkedList.toString(), String.join(" -> ", dest));
        //마지막 삭제
        myLinkedList.delete(dest.size() - 1);
        assertEquals(myLinkedList.toString(), "1st -> 2nd -> 3rd -> 4th -> 5th");
        //처음 삭제
        myLinkedList.delete(0);
        assertEquals(myLinkedList.toString(), "2nd -> 3rd -> 4th -> 5th");
        //전체 삭제
        IntStream.range(0, myLinkedList.getSize()).forEach(i -> myLinkedList.delete(0));
        assertEquals(myLinkedList.toString(), "");
        //전체 추가
        dest.forEach(myLinkedList::add);
        assertEquals(myLinkedList.toString(), String.join(" -> ", dest));
        //전체 삭제
        IntStream.range(0, myLinkedList.getSize()).forEach(i -> myLinkedList.delete(0));
        assertEquals(myLinkedList.toString(), "");
    }

    @Test
    @DisplayName("get 메서드 테스트")
    public void getTest() {
        LinkedListInterface<String> myLinkedList = new MyLinkedList<>();
        List<String> dest = new ArrayList<>(Arrays.asList("1st", "2nd", "3rd", "4th", "5th", "6th"));

        dest.forEach(myLinkedList::add);
        for (int i = 0; i < dest.size(); i++) {
            assertEquals(myLinkedList.get(i), dest.get(i));
        }
    }

    @Test
    @DisplayName("유효 범위 테스트")
    public void validRangeTest() {
        LinkedListInterface<String> myLinkedList = new net.eris.the.no1.MyLinkedList<>();
        List<String> dest = new ArrayList<>(Arrays.asList("1st", "2nd", "3rd", "4th", "5th", "6th"));

        // 무효한 인덱스 번호
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> myLinkedList.get(-1));

        // 유효한 인덱스이지만 아직 없는 인덱스 번호
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> myLinkedList.get(5));

        // 사이즈를 넘어서는 번호
        dest.forEach(myLinkedList::add);
        assertEquals(myLinkedList.get(myLinkedList.getSize() - 1), dest.get(dest.size() - 1));
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> myLinkedList.get(myLinkedList.getSize()));
    }
}
