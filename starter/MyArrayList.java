class MyArrayList<E> implements MyList<E>
{
    Object[] data;
    /*
     * Constructors
     */

    public MyArrayList()
    {
        this.data = new Object[5];
    }
    public MyArrayList(int initialCapacity)
    {
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        } else{
            this.data = new Object[initialCapacity];
        }
    }

    //Look up lecture notes on shallow copy
    public MyArrayList(E[] Arr)
    {

    }
    
    /**
     * Increase the capacity of underlying array if needed
     *
     * @param requiredCapacity minimum capacity after expanding
     */
    public void expandCapacity(int requiredCapacity)
    {
        
    }

    /**
     * Get the amount of elements array can hold
     *
     * @return number of elements that can be held
     */
    public int getCapacity()
    {
        return data.length;
    }

    /**
     * Add an element at the specified index
     *
     * @param index   position to insert the element
     * @param element the element to insert
     */
    public void insert(int index, E element)
    {

    }

    /**
     * Add an element to the end of the list
     *
     * @param element the element to append
     */
    public void append(E element)
    {

    }

    /**
     * Add an element to the beginning of the list 
     *
     * @param element the element to prepend
     */
    public void prepend(E element)
    {

    }

    /**
     * Get the element at the given index
     *
     * @param index the index at which to return the element
     * @return the element at the index
     */
    public E get(int index)
    {

    }

    /**
     * Replaces an element at the specified index with a new element and return
     * the original element
     *
     * @param index   the index at which to replace
     * @param element the element with which to replace
     * @return the original element
     */
    public E set(int index, E element)
    {

    }

    /**
     * Remove the element at the specified index and return the removed element
     *
     * @param index the index at which to remove the element
     * @return the removed element
     */
    public E remove(int index)
    {

    }

    /**
     * Get the number of elements in the list
     *
     * @return number of elements in the list
     */
    public int size()
    {

    }
}