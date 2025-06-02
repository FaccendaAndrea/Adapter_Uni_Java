package myAdapter;

/**
 * An ordered collection (also known as a sequence). The user of this interface has
 * precise control over where in the list each element is inserted. The user can
 * access elements by their integer index (position in the list), and search for
 * elements in the list.
 *
 * This interface is a simplified version of java.util.List from J2SE 1.4.2,
 * adapted for CLDC 1.1.
 */
public interface HList extends HCollection {
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    boolean contains(Object o);

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    HIterator iterator();

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence.
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    Object[] toArray();

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence; the runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of this list are to be stored
     * @return an array containing the elements of this list
     * @throws ArrayStoreException if the runtime type of the specified array is not
     *         a supertype of the runtime type of every element in this list
     */
    Object[] toArray(Object[] a);

    /**
     * Appends the specified element to the end of this list.
     *
     * @param o element to be appended to this list
     * @return true (as per the general contract of the Collection.add method)
     */
    boolean add(Object o);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    boolean remove(Object o);

    /**
     * Returns true if this list contains all of the elements of the specified collection.
     *
     * @param c collection to be checked for containment in this list
     * @return true if this list contains all of the elements of the specified collection
     */
    boolean containsAll(HCollection c);

    /**
     * Appends all of the elements in the specified collection to the end of this list.
     *
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     */
    boolean addAll(HCollection c);

    /**
     * Inserts all of the elements in the specified collection into this list at the
     * specified position.
     *
     * @param index index at which to insert the first element from the specified collection
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    boolean addAll(int index, HCollection c);

    /**
     * Removes from this list all of its elements that are contained in the specified
     * collection.
     *
     * @param c collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     */
    boolean removeAll(HCollection c);

    /**
     * Retains only the elements in this list that are contained in the specified
     * collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     */
    boolean retainAll(HCollection c);

    /**
     * Removes all of the elements from this list.
     */
    void clear();

    /**
     * Compares the specified object with this list for equality.
     *
     * @param o the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this list.
     *
     * @return the hash code value for this list
     */
    int hashCode();

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    Object get(int index);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    Object set(int index, Object element);

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    void add(int index, Object element);

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    Object remove(int index);

    /**
     * Returns the index of the first occurrence of the specified element in this list.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list,
     *         or -1 if this list does not contain the element
     */
    int indexOf(Object o);

    /**
     * Returns the index of the last occurrence of the specified element in this list.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this list,
     *         or -1 if this list does not contain the element
     */
    int lastIndexOf(Object o);

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @return a list iterator over the elements in this list (in proper sequence)
     */
    HListIterator listIterator();

    /**
     * Returns a list iterator of the elements in this list (in proper sequence),
     * starting at the specified position in this list.
     *
     * @param index index of first element to be returned from the list iterator
     * @return a list iterator of the elements in this list (in proper sequence),
     *         starting at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    HListIterator listIterator(int index);

    /**
     * Returns a view of the portion of this list between the specified fromIndex,
     * inclusive, and toIndex, exclusive.
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *         (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
     */
    HList subList(int fromIndex, int toIndex);
} 