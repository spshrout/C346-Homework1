package ius;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class MyLinkedListTest {

    @Test
    public void NextReturnsNullWhenNextIsNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        assertEquals("Null next does not equal null.", null, list.next());

    }

    @Test
    public void NextReturnsExpectedListWhenNextIsNotNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> next = new MyLinkedList<>();
        list.next = next;
        assertSame("Non null next is not same as expected next.", next, list.next());

    }

    @Test
    public void LastReturnsExpectedListWhenNextIsNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        assertSame("Last of list with no next does not equal list.", list, list.last());

    }

    @Test
    public void LastofListWithOneNextReturnsExpectedList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> next = new MyLinkedList<>();
        list.next = next;
        assertSame("Last of list with one next is not same as next.", next, list.last());

    }

    @Test
    public void LastofListWithMultipleNextReturnsExpectedList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> next = new MyLinkedList<>();
        MyLinkedList<Integer> next2 = new MyLinkedList<>();
        next.next = next2;
        list.next = next;
        assertSame("Last of list with multiple next is not same as last.", next2, list.last());

    }


    @Test(expected = IllegalArgumentException.class)
    public void AfterofListThrowsExceptionWhenNextIsNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.after(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AfterofListThrowsExceptionWhenRequestedElementExceedsNextCount() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> next = new MyLinkedList<>();
        list.next = next;
        list.after(2);

    }


    @Test
    public void AfterofListReturnsExpectedListWhenRequestedElementWithinNextCount() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list.next = list2;
        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        list2.next = list3;
        assertSame("After of list not same as expected list.", list3, list.after(2));


    }

    @Test(expected = IllegalStateException.class)
    public void DetachThrowsExceptionWhenNextIsNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.detach();

    }

    @Test
    public void DetachSetsNextAsNullWhenNextIsNotNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list.next = list2;
        list.detach();
        assertEquals("Next is not null after detach.", null, list.next());

    }

    @Test
    public void DetachReturnsPreviousNextWhenNextNotIsNotNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list.next = list2;
        assertSame("Previous next not returned with detach.", list2, list.detach());

    }

    @Test
    public void GetReturnsExpectedValueWhenValueNotNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.value = 283;
        assertEquals("Get with non-null value does not return expected value", (Integer) 283, list.get());

    }

    @Test
    public void GetReturnsNullWhenValueIsNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        assertEquals("Get with null value does not return null value", null, list.get());

    }

    @Test
    public void SetSetsExpectedValueWhenValueNotNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.set(283);
        assertEquals("Set with non-null value does not set expected value", (Integer) 283, list.value);

    }

    @Test
    public void SetSetsNullWhenValueIsNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.set(null);
        assertEquals("Set with null value does not set expected value", null, list.value);

    }

    @Test
    public void SetNextSetsExpectedValueWhenValueNotNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list.setNext(list2);
        assertSame("SetNext with non-null value does not set expected next", list2, list.next);

    }

    @Test
    public void SetNextSetsNullWhenValueIsNull() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list.next = list2;
        list.setNext(null);
        assertEquals("SetNext with null value does not set null next", null, list.next);

    }



    @Test
    public void AppendSetsAppendedListAsNextWhenNoExistingNext() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list.append(list2);
        assertSame("Next of list with appended list not same as expected list.",list2,list.next);
    }

    @Test
    public void AppendSetsFirstAppendedListAsNextWhenSecondAppend() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        list.append(list2);
        list.append(list3);
        assertSame("Next of list with second appended list not same as expected list.",list2,list.next);
    }

    @Test
    public void AppendSetsSecondAppendedListAsNextNextWhenSecondAppend() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        list.append(list2);
        list.append(list3);
        assertSame("Next of next of list with second appended list not same as expected list.",list3,list2.next);
    }





    @Test
    public void InsertSetsInsertedListAsNextWhenNoExistingNext() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list.insert(list2);
        assertSame("Next of list with inserted list not same as expected list.",list2,list.next);
    }

    @Test
    public void InsertSetsFirstInsertedListAsNextNextWhenSecondInsert() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        list.insert(list2);
        list.insert(list3);
        assertSame("Next of next of list with second inserted list not same as expected list.",list2,list3.next);
    }

    @Test
    public void InsertSetsSecondInsertedListAsNextWhenSecondInsert() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        list.insert(list2);
        list.insert(list3);
        assertSame("Next of list with second appended list not same as expected list.",list3,list.next);
    }


}