package myAdapter;

import java.util.Vector;
import java.util.NoSuchElementException;

/**
 * Implementazione dell'adapter per l'interfaccia List di J2SE 1.4.2 utilizzando
 * la classe Vector di CLDC 1.1 come adaptee.
 * 
 * Questa classe implementa tutte le funzionalità dell'interfaccia List di J2SE 1.4.2,
 * incluse le optional operations, mantenendo la compatibilità con CLDC 1.1.
 * L'implementazione utilizza Vector come struttura dati sottostante, adattando
 * i suoi metodi per soddisfare il contratto dell'interfaccia List.
 *
 * @author [Il tuo nome]
 * @version 1.0
 * @see HList
 * @see HCollection
 * @see Vector
 */
public class ListAdapter implements HList {
    private Vector vector;

    /**
     * Constructs an empty list.
     */
    public ListAdapter() {
        vector = new Vector();
    }

    /**
     * Constructs a list containing the elements of the specified collection.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public ListAdapter(HCollection c) {
        if (c == null)
            throw new NullPointerException();
        vector = new Vector();
        addAll(c);
    }

    public int size() {
        return vector.size();
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

    public boolean contains(Object o) {
        return vector.contains(o);
    }

    public HIterator iterator() {
        return new ListAdapterIterator();
    }

    public Object[] toArray() {
        Object[] result = new Object[size()];
        for (int i = 0; i < size(); i++)
            result[i] = vector.elementAt(i);
        return result;
    }

    public Object[] toArray(Object[] a) {
        if (a == null)
            throw new NullPointerException();
        
        Object[] result = a.length >= size() ? a : 
                         (Object[])java.lang.reflect.Array.newInstance(
                             a.getClass().getComponentType(), size());
        
        for (int i = 0; i < size(); i++)
            result[i] = vector.elementAt(i);
            
        if (result.length > size())
            result[size()] = null;
            
        return result;
    }

    public boolean add(Object o) {
        vector.addElement(o);
        return true;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
        vector.removeElementAt(index);
        return true;
    }

    public boolean containsAll(HCollection c) {
        if (c == null)
            throw new NullPointerException();
        HIterator it = c.iterator();
        while (it.hasNext())
            if (!contains(it.next()))
                return false;
        return true;
    }

    public boolean addAll(HCollection c) {
        if (c == null)
            throw new NullPointerException();
        boolean modified = false;
        HIterator it = c.iterator();
        while (it.hasNext()) {
            if (add(it.next()))
                modified = true;
        }
        return modified;
    }

    public boolean addAll(int index, HCollection c) {
        if (c == null)
            throw new NullPointerException();
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
            
        boolean modified = false;
        HIterator it = c.iterator();
        while (it.hasNext()) {
            add(index++, it.next());
            modified = true;
        }
        return modified;
    }

    public boolean removeAll(HCollection c) {
        if (c == null)
            throw new NullPointerException();
        boolean modified = false;
        HIterator it = iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public boolean retainAll(HCollection c) {
        if (c == null)
            throw new NullPointerException();
        boolean modified = false;
        HIterator it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public void clear() {
        vector.removeAllElements();
    }

    public Object get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        return vector.elementAt(index);
    }

    public Object set(int index, Object element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        Object oldValue = vector.elementAt(index);
        vector.setElementAt(element, index);
        return oldValue;
    }

    public void add(int index, Object element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        vector.insertElementAt(element, index);
    }

    public Object remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        Object oldValue = vector.elementAt(index);
        vector.removeElementAt(index);
        return oldValue;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++)
                if (vector.elementAt(i) == null)
                    return i;
        } else {
            for (int i = 0; i < size(); i++)
                if (o.equals(vector.elementAt(i)))
                    return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size() - 1; i >= 0; i--)
                if (vector.elementAt(i) == null)
                    return i;
        } else {
            for (int i = size() - 1; i >= 0; i--)
                if (o.equals(vector.elementAt(i)))
                    return i;
        }
        return -1;
    }

    public HListIterator listIterator() {
        return new ListAdapterListIterator(0);
    }

    public HListIterator listIterator(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        return new ListAdapterListIterator(index);
    }

    public HList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size())
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                                            ") > toIndex(" + toIndex + ")");
                                            
        ListAdapter subList = new ListAdapter();
        for (int i = fromIndex; i < toIndex; i++)
            subList.add(get(i));
        return subList;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HList))
            return false;
            
        HListIterator it1 = listIterator();
        HListIterator it2 = ((HList)o).listIterator();
        
        while (it1.hasNext() && it2.hasNext()) {
            Object o1 = it1.next();
            Object o2 = it2.next();
            if (!(o1 == null ? o2 == null : o1.equals(o2)))
                return false;
        }
        return !(it1.hasNext() || it2.hasNext());
    }

    public int hashCode() {
        int hashCode = 1;
        HIterator it = iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    /**
     * Iterator implementation for ListAdapter
     */
    private class ListAdapterIterator implements HIterator {
        int cursor = 0;
        int lastRet = -1;

        public boolean hasNext() {
            return cursor != size();
        }

        public Object next() {
            try {
                Object next = get(cursor);
                lastRet = cursor++;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                ListAdapter.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalStateException();
            }
        }
    }

    /**
     * ListIterator implementation for ListAdapter
     */
    private class ListAdapterListIterator implements HListIterator {
        int cursor;
        int lastRet = -1;

        ListAdapterListIterator(int index) {
            cursor = index;
        }

        public boolean hasNext() {
            return cursor != size();
        }

        public Object next() {
            try {
                Object next = get(cursor);
                lastRet = cursor++;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public Object previous() {
            try {
                int i = cursor - 1;
                Object previous = get(i);
                lastRet = cursor = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                ListAdapter.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalStateException();
            }
        }

        public void set(Object o) {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                ListAdapter.this.set(lastRet, o);
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalStateException();
            }
        }

        public void add(Object o) {
            try {
                int i = cursor;
                ListAdapter.this.add(i, o);
                lastRet = -1;
                cursor = i + 1;
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalStateException();
            }
        }
    }
} 