class MyArrayList<E> implements MyList<E>
{
    Object[] data;
    int size = 0;
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
        this.data = Arr;
        size = Arr.length;
    }   
    
    /**
     * Increase the capacity of underlying array if needed
     *
     * @param requiredCapacity minimum capacity after expanding
     */
    public void expandCapacity(int requiredCapacity)
    {
        
        Object[] dataTmp = new Object[data.length];

        //Assign all values of data to dataTmp (temporary data array)
        for(int i = 0; i < data.length; i++){
            dataTmp[i] = data[i];
        }
        
        if(data.length == 0){
            this.data = new Object[5];
        } else if(data.length + 3 >= requiredCapacity){
            this.data = new Object[data.length + 3];
        } else{
            this.data = new Object[requiredCapacity];
        }

        

        //Reassign all values of dataTmp to data
        for(int i = 0; i < this.size; i++){
            data[i] = dataTmp[i];
        }
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
        //Case where index is invalid (skips an index)
        if(index > this.size){
            throw new IndexOutOfBoundsException();
        }
        //If length of array is equal allocated size, double Capacity
        if(data.length == this.size){
            expandCapacity(data.length + 3);
        } 

        for(int i = this.size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = element;
        this.size++;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element the element to append
     */
    public void append(E element)
    {
        //If length of array is equal allocated size, add 3 to capacity
        if(data.length == this.size){
            expandCapacity(data.length + 3);
        }
        data[size] = element;
        size++;
    }

    /**
     * Add an element to the beginning of the list 
     *
     * @param element the element to prepend
     */
    public void prepend(E element)
    {
        //If length of array is equal allocated size, double Capacity
        if(data.length == this.size){
            expandCapacity(data.length + 3);
        }

        //Appending all values of previous element to next element
        for(int i = this.size - 1; i >= 0; i--){
            data[i + 1] = data[i];
        }
        data[0] = element;
        size++;
    }

    /**
     * Get the element at the given index
     *
     * @param index the index at which to return the element
     * @return the element at the index
     */
    public E get(int index)
    {
        if(index > data.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return (E)data[index];
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
        if(index > data.length || index < 0){
            throw new IndexOutOfBoundsException();
        }

        E tmp = (E)data[index];
        data[index] = element;

        return tmp;
    }

    /**
     * Remove the element at the specified index and return the removed element
     *
     * @param index the index at which to remove the element
     * @return the removed element
     */
    public E remove(int index)
    {
        if(index >= data.length || index < 0){
            throw new IndexOutOfBoundsException();
        }

        E tmp = (E)data[index];
        for(int i = index; i < data.length - 1; i++){
            data[i] = data[i + 1];
        }
        data[data.length - 1] = null;
        size--;
        return tmp;
    }

    /**
     * Get the number of elements in the list
     *
     * @return number of elements in the list
     */
    public int size()
    {
        return size;
    }
}