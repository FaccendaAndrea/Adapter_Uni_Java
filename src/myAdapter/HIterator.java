package myAdapter;

/**
 * An iterator over a collection. Iterator takes the place of Enumeration in the
 * Java Collections Framework. Iterators differ from enumerations in two ways:
 * 
 * 1. Iterators allow the caller to remove elements from the underlying collection
 *    during the iteration with well-defined semantics.
 * 2. Method names have been improved.
 *
 * This interface is a simplified version of java.util.Iterator from J2SE 1.4.2,
 * adapted for CLDC 1.1.
 */
public interface HIterator {
    /**
     * Returns true if the iteration has more elements.
     *
     * @return true if the iterator has more elements
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    Object next();

    /**
     * Removes from the underlying collection the last element returned by the
     * iterator (optional operation). This method can be called only once per call
     * to next.
     *
     * @throws UnsupportedOperationException if the remove operation is not supported
     *         by this Iterator
     * @throws IllegalStateException if the next method has not yet been called, or
     *         the remove method has already been called after the last call to the
     *         next method
     */
    void remove();
} 