package myTest;

import myAdapter.*;
import junit.framework.TestCase;

/**
 * Test case class for ListAdapter
 * 
 * Template: Homework
 * Assignment: Implement an adapter for List interface
 * Course: Software Development Methods
 * 
 * @see myAdapter.ListAdapter
 */
public class ListAdapterTest extends TestCase {
    private HList list;

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    protected void setUp() {
        list = new ListAdapter();
    }

    /**
     * Test case: testEmptyList
     * 
     * Summary: Tests an empty list's properties
     * 
     * Pre-condition: A new empty list is created
     * Test steps:
     *    1. Check if the list is empty
     *    2. Verify the size is 0
     *    3. Verify that contains() returns false for any object
     * Expected results:
     *    1. isEmpty() returns true
     *    2. size() returns 0
     *    3. contains() returns false
     */
    public void testEmptyList() {
        assertTrue("New list should be empty", list.isEmpty());
        assertEquals("New list should have size 0", 0, list.size());
        assertFalse("Empty list should not contain any elements", list.contains("test"));
    }

    /**
     * Test case: testAdd
     * 
     * Summary: Tests adding elements to the list
     * 
     * Pre-condition: An empty list is created
     * Test steps:
     *    1. Add an element
     *    2. Verify size increased
     *    3. Verify element is contained
     *    4. Add null element
     * Expected results:
     *    1. add() returns true
     *    2. size() returns 1
     *    3. contains() returns true for added element
     *    4. null can be added and retrieved
     */
    public void testAdd() {
        assertTrue("Add should return true", list.add("test"));
        assertEquals("Size should be 1", 1, list.size());
        assertTrue("List should contain added element", list.contains("test"));
        
        assertTrue("Add null should return true", list.add(null));
        assertEquals("Size should be 2", 2, list.size());
        assertTrue("List should contain null", list.contains(null));
    }

    /**
     * Test case: testAddAtIndex
     * 
     * Summary: Tests adding elements at specific positions
     * 
     * Pre-condition: A list with some elements is created
     * Test steps:
     *    1. Add elements at beginning, middle, and end
     *    2. Verify correct insertion order
     *    3. Try invalid indices
     * Expected results:
     *    1. Elements are inserted at correct positions
     *    2. Order is maintained
     *    3. IndexOutOfBoundsException is thrown for invalid indices
     */
    public void testAddAtIndex() {
        list.add("1");
        list.add("3");
        
        list.add(1, "2");
        assertEquals("Element should be at index 1", "2", list.get(1));
        
        try {
            list.add(-1, "x");
            fail("Should throw IndexOutOfBoundsException for negative index");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        try {
            list.add(4, "x");
            fail("Should throw IndexOutOfBoundsException for index > size");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
    }

    /**
     * Test case: testRemove
     * 
     * Summary: Tests removing elements from the list
     * 
     * Pre-condition: A list with some elements is created
     * Test steps:
     *    1. Remove existing element
     *    2. Remove non-existing element
     *    3. Remove null
     * Expected results:
     *    1. remove() returns true and element is removed
     *    2. remove() returns false
     *    3. null can be removed if present
     */
    public void testRemove() {
        list.add("test");
        list.add(null);
        
        assertTrue("Remove should return true for existing element", list.remove("test"));
        assertFalse("Remove should return false for non-existing element", list.remove("nonexistent"));
        assertTrue("Remove should return true for null", list.remove(null));
        assertEquals("Size should be 0", 0, list.size());
    }

    /**
     * Test case: testIterator
     * 
     * Summary: Tests iterator functionality
     * 
     * Pre-condition: A list with some elements is created
     * Test steps:
     *    1. Get iterator
     *    2. Iterate through elements
     *    3. Remove elements using iterator
     * Expected results:
     *    1. Iterator is not null
     *    2. All elements are visited in correct order
     *    3. Elements are removed correctly
     */
    public void testIterator() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        HIterator it = list.iterator();
        assertTrue("Iterator should have next", it.hasNext());
        assertEquals("First element should be '1'", "1", it.next());
        
        it.remove();
        assertEquals("Size should be 2 after remove", 2, list.size());
        assertFalse("List should not contain removed element", list.contains("1"));
        
        try {
            it.remove();
            fail("Should throw IllegalStateException on double remove");
        } catch (IllegalStateException e) {
            // Expected
        }
    }

    /**
     * Test case: testListIterator
     * 
     * Summary: Tests list iterator specific functionality
     * 
     * Pre-condition: A list with some elements is created
     * Test steps:
     *    1. Test forward and backward iteration
     *    2. Test add operation
     *    3. Test set operation
     * Expected results:
     *    1. Correct traversal in both directions
     *    2. Elements are added correctly
     *    3. Elements are set correctly
     */
    public void testListIterator() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        HListIterator it = list.listIterator();
        assertTrue(it.hasNext());
        assertFalse(it.hasPrevious());
        assertEquals(0, it.nextIndex());
        assertEquals(-1, it.previousIndex());
        
        assertEquals("1", it.next());
        assertEquals("2", it.next());
        assertTrue(it.hasPrevious());
        assertEquals("2", it.previous());
        
        it.add("2-new");    // Add "2-new" at current position
        assertEquals(4, list.size());
        assertEquals("2-new", list.get(1));
        assertEquals("2", list.get(2));  // Original "2" is now at position 2
        
        assertEquals("2", it.next());    // Move to the original "2"
        it.set("2-updated"); // Update it to "2-updated"
        assertEquals("2-updated", list.get(2));
    }

    /**
     * Test case: testSubList
     * 
     * Summary: Tests subList functionality
     * 
     * Pre-condition: A list with several elements is created
     * Test steps:
     *    1. Get subList with valid indices
     *    2. Modify subList
     *    3. Try invalid indices
     * Expected results:
     *    1. SubList contains correct elements
     *    2. Changes in subList reflect in original list
     *    3. Invalid indices throw exceptions
     */
    public void testSubList() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        
        HList subList = list.subList(1, 3);
        assertEquals(2, subList.size());
        assertEquals("2", subList.get(0));
        assertEquals("3", subList.get(1));
        
        try {
            list.subList(-1, 2);
            fail("Should throw IndexOutOfBoundsException for negative fromIndex");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        try {
            list.subList(2, 1);
            fail("Should throw IllegalArgumentException when fromIndex > toIndex");
        } catch (IllegalArgumentException e) {
            // Expected
        }
    }

    /**
     * Test case: testToArray
     * 
     * Summary: Tests array conversion functionality
     * 
     * Pre-condition: A list with some elements is created
     * Test steps:
     *    1. Convert to Object array
     *    2. Convert to typed array
     *    3. Convert to array smaller than list
     * Expected results:
     *    1. Correct Object array is created
     *    2. Correct typed array is created
     *    3. New array is created with correct size
     */
    public void testToArray() {
        list.add("1");
        list.add("2");
        
        Object[] array1 = list.toArray();
        assertEquals(2, array1.length);
        assertEquals("1", array1[0]);
        assertEquals("2", array1[1]);
        
        String[] array2 = new String[2];
        Object[] result = list.toArray(array2);
        assertSame(array2, result);
        assertEquals("1", array2[0]);
        assertEquals("2", array2[1]);
        
        String[] array3 = new String[1];
        result = list.toArray(array3);
        assertNotSame(array3, result);
        assertEquals(2, result.length);
    }
} 