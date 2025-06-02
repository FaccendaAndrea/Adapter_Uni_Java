package myAdapter;

/**
 * An iterator for lists that allows the programmer to traverse the list in either
 * direction, modify the list during iteration, and obtain the iterator's current
 * position in the list. A ListIterator has no current element; its cursor
 * position always lies between the element that would be returned by a call to
 * previous() and the element that would be returned by a call to next().
 *
 * This interface is a simplified version of java.util.ListIterator from J2SE 1.4.2,
 * adapted for CLDC 1.1.
 */
public interface HListIterator extends HIterator {
    /**
     * Returns true if this list iterator has more elements when traversing the list
     * in the forward direction.
     *
     * @return true if the list iterator has more elements when traversing the list
     *         in the forward direction
     */
    boolean hasNext();

    /**
     * Returns the next element in the list.
     *
     * @return the next element in the list
     * @throws java.util.NoSuchElementException if the iteration has no next element
     */
    Object next();

    /**
     * Returns true if this list iterator has more elements when traversing the list
     * in the reverse direction.
     *
     * @return true if the list iterator has more elements when traversing the list
     *         in the reverse direction
     */
    boolean hasPrevious();

    /**
     * Returns the previous element in the list.
     *
     * @return the previous element in the list
     * @throws java.util.NoSuchElementException if the iteration has no previous element
     */
    Object previous();

    /**
     * Returns the index of the element that would be returned by a subsequent call
     * to next().
     *
     * @return the index of the element that would be returned by a subsequent call
     *         to next(), or list size if the list iterator is at the end of the list
     */
    int nextIndex();

    /**
     * Returns the index of the element that would be returned by a subsequent call
     * to previous().
     *
     * @return the index of the element that would be returned by a subsequent call
     *         to previous(), or -1 if the list iterator is at the beginning of the list
     */
    int previousIndex();

    /**
     * Removes from the list the last element that was returned by next() or
     * previous() (optional operation).
     *
     * @throws UnsupportedOperationException if the remove operation is not supported
     *         by this list iterator
     * @throws IllegalStateException if neither next nor previous have been called,
     *         or remove or add have been called after the last call to next or previous
     */
    void remove();

    /**
     * Replaces the last element returned by next() or previous() with the specified
     * element (optional operation).
     *
     * @param o the element with which to replace the last element returned by next
     *         or previous
     * @throws UnsupportedOperationException if the set operation is not supported by
     *         this list iterator
     * @throws IllegalStateException if neither next nor previous have been called,
     *         or remove or add have been called after the last call to next or previous
     * @throws ClassCastException if the class of the specified element prevents it
     *         from being added to this list
     * @throws IllegalArgumentException if some aspect of the specified element
     *         prevents it from being added to this list
     */
    void set(Object o);

    /**
     * Inserts the specified element into the list (optional operation).
     *
     * @param o the element to insert
     * @throws UnsupportedOperationException if the add operation is not supported by
     *         this list iterator
     * @throws ClassCastException if the class of the specified element prevents it
     *         from being added to this list
     * @throws IllegalArgumentException if some aspect of this element prevents it
     *         from being added to this list
     */
    void add(Object o);
} 