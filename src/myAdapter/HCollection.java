package myAdapter;

/**
 * The root interface in the collection hierarchy. A collection represents a group
 * of objects, known as its elements. Some collections allow duplicate elements and
 * others do not. Some are ordered and others unordered.
 * 
 * This interface is a simplified version of java.util.Collection from J2SE 1.4.2,
 * adapted for CLDC 1.1.
 */
public interface HCollection {
    /**
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    int size();

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
    boolean isEmpty();

    /**
     * Returns true if this collection contains the specified element.
     *
     * @param o element whose presence in this collection is to be tested
     * @return true if this collection contains the specified element
     * @throws ClassCastException if the type of the specified element is incompatible
     *         with this collection
     * @throws NullPointerException if the specified element is null and this
     *         collection does not permit null elements
     */
    boolean contains(Object o);

    /**
     * Returns an iterator over the elements in this collection.
     *
     * @return an Iterator over the elements in this collection
     */
    HIterator iterator();

    /**
     * Returns an array containing all of the elements in this collection.
     *
     * @return an array containing all of the elements in this collection
     */
    Object[] toArray();

    /**
     * Returns an array containing all of the elements in this collection; the runtime
     * type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of this collection are to be stored
     * @return an array containing all of the elements in this collection
     * @throws ArrayStoreException if the runtime type of the specified array is not
     *         a supertype of the runtime type of every element in this collection
     * @throws NullPointerException if the specified array is null
     */
    Object[] toArray(Object[] a);

    /**
     * Adds the specified element to this collection.
     *
     * @param o element to be added to this collection
     * @return true if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the add operation is not supported by
     *         this collection
     * @throws ClassCastException if the class of the specified element prevents it
     *         from being added to this collection
     * @throws NullPointerException if the specified element is null and this
     *         collection does not permit null elements
     * @throws IllegalArgumentException if some property of the element prevents it
     *         from being added to this collection
     */
    boolean add(Object o);

    /**
     * Removes a single instance of the specified element from this collection, if it
     * is present.
     *
     * @param o element to be removed from this collection, if present
     * @return true if an element was removed as a result of this call
     * @throws ClassCastException if the type of the specified element is incompatible
     *         with this collection
     * @throws NullPointerException if the specified element is null and this
     *         collection does not permit null elements
     * @throws UnsupportedOperationException if the remove operation is not supported
     *         by this collection
     */
    boolean remove(Object o);

    /**
     * Returns true if this collection contains all of the elements in the specified
     * collection.
     *
     * @param c collection to be checked for containment in this collection
     * @return true if this collection contains all of the elements in the specified collection
     * @throws ClassCastException if the types of one or more elements in the specified
     *         collection are incompatible with this collection
     * @throws NullPointerException if the specified collection contains one or more
     *         null elements and this collection does not permit null elements, or if
     *         the specified collection is null
     */
    boolean containsAll(HCollection c);

    /**
     * Adds all of the elements in the specified collection to this collection.
     *
     * @param c collection containing elements to be added to this collection
     * @return true if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the addAll operation is not supported
     *         by this collection
     * @throws ClassCastException if the class of an element of the specified
     *         collection prevents it from being added to this collection
     * @throws NullPointerException if the specified collection contains a null element
     *         and this collection does not permit null elements, or if the specified
     *         collection is null
     * @throws IllegalArgumentException if some property of an element of the specified
     *         collection prevents it from being added to this collection
     */
    boolean addAll(HCollection c);

    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection.
     *
     * @param c collection containing elements to be removed from this collection
     * @return true if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the removeAll method is not supported
     *         by this collection
     * @throws ClassCastException if the types of one or more elements in this
     *         collection are incompatible with the specified collection
     * @throws NullPointerException if this collection contains one or more null
     *         elements and the specified collection does not support null elements, or
     *         if the specified collection is null
     */
    boolean removeAll(HCollection c);

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this collection
     * @return true if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the retainAll operation is not
     *         supported by this collection
     * @throws ClassCastException if the types of one or more elements in this
     *         collection are incompatible with the specified collection
     * @throws NullPointerException if this collection contains one or more null
     *         elements and the specified collection does not permit null elements, or
     *         if the specified collection is null
     */
    boolean retainAll(HCollection c);

    /**
     * Removes all of the elements from this collection.
     *
     * @throws UnsupportedOperationException if the clear operation is not supported
     *         by this collection
     */
    void clear();

    /**
     * Compares the specified object with this collection for equality.
     *
     * @param o object to be compared for equality with this collection
     * @return true if the specified object is equal to this collection
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this collection.
     *
     * @return the hash code value for this collection
     */
    int hashCode();
} 