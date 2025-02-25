import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

  // -------- WAVE 1 -------

  @Test
  void testListConstructorWithThreeValues() {
    // Arrange
    List<Integer> values = List.of(5, 7, 3);

    // Act
    Node head = new Node(values);

    // Assert
    assertEquals(5, head.value);
    assertNotNull(head.next);
    assertEquals(7, head.next.value);
    assertNotNull(head.next.next);
    assertEquals(3, head.next.next.value);
    assertNull(head.next.next.next);
    assertEquals(head, head.next.prev);
    assertEquals(head.next, head.next.next.prev);
  }

  @Test
  void testListConstructorWithEmptyList() {
    // Arrange
    List<Integer> emptyList = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Node(emptyList),
        "Expected constructor to throw IllegalArgumentException for an empty list."
    );
  }

  
  // DONE: Add test for list constructor when passed null list
  // DONE: Add at least one more test for list constructor that would be useful and cover new ground.

  @Test
  void testListConstructorWithNullList() {
    // act and assert
    assertThrows(
      IllegalArgumentException.class,
      () -> new Node(null),
      "Expected constructor to throw IllegalArgumentException for a null list."
    );
  }

  @Test
  void testListConstructorWithSingleValue() {
    // arrange
    List<Integer> singleValueList = List.of(42);

    // act
    Node head = new Node(singleValueList);

    // assert
    assertEquals(42, head.value);
    assertNull(head.next);
    assertNull(head.prev);
  }


  // -------- WAVE 2 -------

  @Test
  void testToListWithThreeValues() {
    // Arrange
    Node head = new Node(5);
    Node middle = new Node(7);
    Node tail = new Node(3);

    head.next = middle;
    middle.prev = head;
    middle.next = tail;
    tail.prev = middle;

    // Act
    List<Integer> values = head.toList();

    // Assert
    assertEquals(List.of(5, 7, 3), values);
  }

  // DONE: Add test for Node with no next or prev
  // DONE: Add at least one more test for list constructor that would be useful and cover new ground.

  @Test
  void testToListWithNoNextOrPrev() {
    // arange
    Node isolatedNode = new Node(100);

    // act
    List<Integer> values = isolatedNode.toList();

    // assert
    assertEquals(List.of(100), values);
  }

  @Test
  void testToListWithLongerList() {
    // arange
    List<Integer> values = List.of(1, 2, 3, 4, 5, 6);
    Node head = new Node(values);

    // act
    List<Integer> result = head.toList();

    // assert
    assertEquals(values, result);
  }
}
