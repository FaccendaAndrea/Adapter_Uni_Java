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

    /**
     * Test case: testContainsAll
     * 
     * Summary: Tests containsAll method of Collection interface
     * 
     * Pre-condition: A list with several elements is created
     * Test steps:
     *    1. Create a collection with elements that are in the list
     *    2. Create a collection with elements not in the list
     *    3. Test containsAll with both collections
     * Expected results:
     *    1. containsAll returns true for collection with elements in list
     *    2. containsAll returns false for collection with elements not in list
     *    3. containsAll throws NullPointerException for null collection
     */
    public void testContainsAll() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        ListAdapter containedList = new ListAdapter();
        containedList.add("1");
        containedList.add("2");
        
        ListAdapter notContainedList = new ListAdapter();
        notContainedList.add("4");
        notContainedList.add("5");
        
        assertTrue("Should contain all elements", list.containsAll(containedList));
        assertFalse("Should not contain all elements", list.containsAll(notContainedList));
        
        try {
            list.containsAll(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // Expected
        }
    }

    /**
     * Test case: testAddAll
     * 
     * Summary: Tests addAll methods of Collection interface
     * 
     * Pre-condition: An empty list is created
     * Test steps:
     *    1. Test addAll at end of list
     *    2. Test addAll at specific index
     *    3. Test with empty collection
     *    4. Test with null collection
     * Expected results:
     *    1. Elements are added correctly at end
     *    2. Elements are added correctly at index
     *    3. No change for empty collection
     *    4. NullPointerException for null collection
     */
    public void testAddAll() {
        ListAdapter toAdd = new ListAdapter();
        toAdd.add("1");
        toAdd.add("2");
        
        assertTrue("Should modify list", list.addAll(toAdd));
        assertEquals("Size should be 2", 2, list.size());
        assertEquals("First element should be 1", "1", list.get(0));
        
        assertTrue("Should modify list", list.addAll(1, toAdd));
        assertEquals("Size should be 4", 4, list.size());
        assertEquals("Element at index 1 should be 1", "1", list.get(1));
        
        ListAdapter empty = new ListAdapter();
        assertFalse("Should not modify list", list.addAll(empty));
        
        try {
            list.addAll(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // Expected
        }
    }

    /**
     * Test case: testRemoveAll
     * 
     * Summary: Tests removeAll method of Collection interface
     * 
     * Pre-condition: A list with several elements is created
     * Test steps:
     *    1. Remove multiple elements using removeAll
     *    2. Try to remove elements not in list
     *    3. Try to remove from empty list
     *    4. Try with null collection
     * Expected results:
     *    1. Specified elements are removed
     *    2. List is unchanged when no elements match
     *    3. Empty list remains unchanged
     *    4. NullPointerException for null collection
     */
    public void testRemoveAll() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");  // Duplicate
        
        ListAdapter toRemove = new ListAdapter();
        toRemove.add("2");
        toRemove.add("3");
        
        assertTrue("Should modify list", list.removeAll(toRemove));
        assertEquals("Size should be 1", 1, list.size());
        assertEquals("Should contain only '1'", "1", list.get(0));
        
        ListAdapter notPresent = new ListAdapter();
        notPresent.add("4");
        assertFalse("Should not modify list", list.removeAll(notPresent));
        
        try {
            list.removeAll(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // Expected
        }
    }

    /**
     * Test case: testRetainAll
     * 
     * Summary: Tests retainAll method of Collection interface
     * 
     * Pre-condition: A list with several elements is created
     * Test steps:
     *    1. Retain subset of elements
     *    2. Retain with empty collection
     *    3. Retain with collection containing no matching elements
     *    4. Try with null collection
     * Expected results:
     *    1. Only specified elements are retained
     *    2. All elements are removed for empty collection
     *    3. All elements are removed when no matches
     *    4. NullPointerException for null collection
     */
    public void testRetainAll() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        ListAdapter toRetain = new ListAdapter();
        toRetain.add("1");
        toRetain.add("2");
        
        assertTrue("Should modify list", list.retainAll(toRetain));
        assertEquals("Size should be 2", 2, list.size());
        assertTrue("Should contain '1'", list.contains("1"));
        assertTrue("Should contain '2'", list.contains("2"));
        assertFalse("Should not contain '3'", list.contains("3"));
        
        ListAdapter empty = new ListAdapter();
        assertTrue("Should modify list", list.retainAll(empty));
        assertTrue("List should be empty", list.isEmpty());
        
        try {
            list.retainAll(null);
            fail("Should throw NullPointerException");
        } catch (NullPointerException e) {
            // Expected
        }
    }

    /**
     * Test case: testListIteratorWithIndex
     * 
     * Summary: Tests listIterator(int) method
     * 
     * Pre-condition: A list with several elements is created
     * Test steps:
     *    1. Get iterator at specific index
     *    2. Test navigation methods
     *    3. Test modification methods
     *    4. Try invalid indices
     * Expected results:
     *    1. Iterator starts at correct position
     *    2. Navigation works correctly
     *    3. Modifications work correctly
     *    4. IndexOutOfBoundsException for invalid indices
     */
    public void testListIteratorWithIndex() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        HListIterator it = list.listIterator(1);
        assertEquals("Previous index should be 0", 0, it.previousIndex());
        assertEquals("Next index should be 1", 1, it.nextIndex());
        assertEquals("Next element should be '2'", "2", it.next());
        assertEquals("Previous element should be '2'", "2", it.previous());
        
        it.add("1.5");
        assertEquals("Size should be 4", 4, list.size());
        assertEquals("Element should be inserted at position 1", "1.5", list.get(1));
        
        try {
            list.listIterator(-1);
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        try {
            list.listIterator(list.size() + 1);
            fail("Should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
    }

    /**
     * Test case: testIndexMethods
     * 
     * Summary: Tests indexOf and lastIndexOf methods
     * 
     * Pre-condition: A list with duplicate elements is created
     * Test steps:
     *    1. Test indexOf with present element
     *    2. Test indexOf with absent element
     *    3. Test lastIndexOf with present element
     *    4. Test with null elements
     * Expected results:
     *    1. indexOf returns first occurrence
     *    2. indexOf returns -1 for absent element
     *    3. lastIndexOf returns last occurrence
     *    4. Methods work correctly with null
     */
    public void testIndexMethods() {
        list.add("1");
        list.add("2");
        list.add("1");  // Duplicate
        list.add(null);
        list.add("2");  // Duplicate
        list.add(null); // Duplicate null
        
        assertEquals("First '1' should be at index 0", 0, list.indexOf("1"));
        assertEquals("Last '1' should be at index 2", 2, list.lastIndexOf("1"));
        assertEquals("First '2' should be at index 1", 1, list.indexOf("2"));
        assertEquals("Last '2' should be at index 4", 4, list.lastIndexOf("2"));
        assertEquals("First null should be at index 3", 3, list.indexOf(null));
        assertEquals("Last null should be at index 5", 5, list.lastIndexOf(null));
        
        assertEquals("Non-existent element should return -1", -1, list.indexOf("3"));
        assertEquals("Non-existent element should return -1", -1, list.lastIndexOf("3"));
    }

    /**
     * Test case: testClear
     * 
     * Summary: Tests clear method of Collection interface
     * 
     * Pre-condition: A list with several elements is created
     * Test steps:
     *    1. Add elements to list
     *    2. Clear the list
     *    3. Verify list state
     * Expected results:
     *    1. List is empty after clear
     *    2. Size is 0
     *    3. Contains returns false for previously contained elements
     */
    public void testClear() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        list.clear();
        assertTrue("List should be empty after clear", list.isEmpty());
        assertEquals("Size should be 0 after clear", 0, list.size());
        assertFalse("Should not contain previously added elements", list.contains("1"));
    }

    /**
     * Test case: testSet
     * 
     * Summary: Tests set method of List interface
     * 
     * Pre-condition: A list with several elements is created
     * Test steps:
     *    1. Set element at valid index
     *    2. Try to set at invalid indices
     *    3. Set with null value
     * Expected results:
     *    1. Element is replaced and old element is returned
     *    2. IndexOutOfBoundsException for invalid indices
     *    3. Null can be set and retrieved
     */
    public void testSet() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        assertEquals("Should return old element", "2", list.set(1, "2-new"));
        assertEquals("New element should be at index", "2-new", list.get(1));
        
        Object oldValue = list.set(1, null);
        assertEquals("Old value should be 2-new", "2-new", oldValue);
        assertNull("New value should be null", list.get(1));
        
        try {
            list.set(-1, "x");
            fail("Should throw IndexOutOfBoundsException for negative index");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        try {
            list.set(list.size(), "x");
            fail("Should throw IndexOutOfBoundsException for index = size");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
    }

    /**
     * Test case: testRemoveAtIndex
     * 
     * Summary: Tests remove(int) method of List interface
     * 
     * Pre-condition: A list with several elements is created
     * Test steps:
     *    1. Remove element at valid index
     *    2. Try to remove at invalid indices
     *    3. Remove last element
     * Expected results:
     *    1. Element is removed and returned
     *    2. IndexOutOfBoundsException for invalid indices
     *    3. List size decreases
     */
    public void testRemoveAtIndex() {
        list.add("1");
        list.add("2");
        list.add("3");
        
        assertEquals("Should return removed element", "2", list.remove(1));
        assertEquals("Size should decrease", 2, list.size());
        assertEquals("Elements should shift left", "3", list.get(1));
        
        try {
            list.remove(-1);
            fail("Should throw IndexOutOfBoundsException for negative index");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        try {
            list.remove(list.size());
            fail("Should throw IndexOutOfBoundsException for index = size");
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
    }

    /**
     * Test case: testEquals
     * 
     * Summary: Tests equals method of List interface
     * 
     * Pre-condition: Two lists are created
     * Test steps:
     *    1. Compare empty lists
     *    2. Compare lists with same elements
     *    3. Compare lists with different elements
     *    4. Compare with null and other types
     * Expected results:
     *    1. Empty lists are equal
     *    2. Lists with same elements in same order are equal
     *    3. Lists with different elements or order are not equal
     *    4. Not equal to null or other types
     */
    public void testEquals() {
        HList list2 = new ListAdapter();
        
        // Empty lists
        assertTrue("Empty lists should be equal", list.equals(list2));
        
        // Same elements, same order
        list.add("1");
        list.add("2");
        list2.add("1");
        list2.add("2");
        assertTrue("Lists with same elements should be equal", list.equals(list2));
        
        // Different elements
        list2.add("3");
        assertFalse("Lists with different elements should not be equal", list.equals(list2));
        
        // Different order
        list.add("3");
        list2.set(1, "3");
        list2.set(2, "2");
        assertFalse("Lists with different order should not be equal", list.equals(list2));
        
        // Null and other types
        assertFalse("List should not equal null", list.equals(null));
        assertFalse("List should not equal other types", list.equals("not a list"));
    }

    /**
     * Test case: testHashCode
     * 
     * Summary: Tests hashCode method of List interface
     * 
     * Pre-condition: Two lists are created
     * Test steps:
     *    1. Compare hashCodes of empty lists
     *    2. Compare hashCodes of equal lists
     *    3. Compare hashCodes after modifications
     * Expected results:
     *    1. Equal lists have equal hashCodes
     *    2. hashCode is consistent
     *    3. Different lists likely have different hashCodes
     */
    public void testHashCode() {
        HList list2 = new ListAdapter();
        
        // Empty lists
        assertEquals("Empty lists should have same hashCode", list.hashCode(), list2.hashCode());
        
        // Same elements, same order
        list.add("1");
        list.add("2");
        list2.add("1");
        list2.add("2");
        assertEquals("Equal lists should have same hashCode", list.hashCode(), list2.hashCode());
        
        // Consistent hashCode
        int hash1 = list.hashCode();
        int hash2 = list.hashCode();
        assertEquals("hashCode should be consistent", hash1, hash2);
        
        // Different lists
        list2.add("3");
        assertFalse("Different lists should have different hashCodes", list.hashCode() == list2.hashCode());
    }
} 