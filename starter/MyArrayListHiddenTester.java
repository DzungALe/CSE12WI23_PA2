import static org.junit.Assert.*;

import org.junit.*;

public class MyArrayListHiddenTester {
    // Do not change the method signatures!
    static final int inval_CAPACITY = -1;

    Object[] emptyArr = new Object[10];

    Integer[] nullArr = {null, null, null};
    Integer[] intArr = {1, 2, 3};
    Integer[] mixArr = {null, 2, null};

    private MyArrayList nullArrList, intArrList, mixArrList, fullArrList;
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test 
     */
    @Before
    public void setUp() throws Exception {
        nullArrList = new MyArrayList(nullArr);
        intArrList = new MyArrayList(intArr);
        mixArrList = new MyArrayList(mixArr);

        fullArrList = new MyArrayList(intArr);
        fullArrList.size = fullArrList.data.length;
    }

    /**
     * Aims to test the constructor when the input argument
     * is not valid
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalidArg(){
        MyArrayList invalidArr = new MyArrayList(inval_CAPACITY);
    }

    /**
     * Aims to test the constructor when the input argument is null
     */
    @Test
    public void testConstructorNullArg(){
        assertEquals(new Object[]{null,null,null}, nullArrList.data);
    }

    /**
     * Aims to test the constructor when the input array has null elements
     */
    @Test
    public void testConstructorArrayWithNull(){
        assertEquals(new Object[]{null, 2, null}, mixArrList.data);
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        fullArrList.append(4);

        assertEquals(4, fullArrList.get(3));
        assertEquals(6, fullArrList.data.length);
        assertEquals(4, fullArrList.size);
    }

    /**
     * Aims to test the append method when null is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendNull(){
        fullArrList.append(null);

        assertEquals(new Object[]{1, 2, 3, null, null, null}, fullArrList.data);
        assertEquals(6, fullArrList.data.length);
        assertEquals(4, fullArrList.size);
    }

    /**
     * Aims to test the prepend method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testPrependAtCapacity(){
        fullArrList.prepend(0);

        assertEquals(0, fullArrList.get(0));
        assertEquals(6, fullArrList.data.length);
        assertEquals(4, fullArrList.size);
    }
    
    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        fullArrList.prepend(null);

        assertEquals(new Object[]{null, 1, 2, 3, null, null}, fullArrList.data);
        assertEquals(6, fullArrList.data.length);
        assertEquals(4, fullArrList.size);

        
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBound(){
       fullArrList.insert(5, 5);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        for(int i = 4; i <= 10; i++){
            fullArrList.append(i);
        }

        assertEquals(12, fullArrList.data.length);
        assertEquals(10, fullArrList.size);
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBound(){
        fullArrList.get(4);
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBound(){
        fullArrList.set(4, null);
    }

    /**
     * Aims to test the remove method when removing multiple items from a list
     */
    @Test
    public void testRemoveMultiple(){
        fullArrList.remove(0);
        fullArrList.remove(0);

        assertEquals(3, fullArrList.data.length);
        assertEquals(1, fullArrList.size);
        assertEquals(new Object[]{3, null, null}, fullArrList.data);
        
        fullArrList.remove(0);
        assertEquals(3, fullArrList.data.length);
        assertEquals(0, fullArrList.size);
    }

    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBound(){
        fullArrList.remove(4);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
        fullArrList.expandCapacity(4);

        assertEquals(6, fullArrList.data.length);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than current capacity+3 and default capacity
     */
    @Test
    public void testExpandCapacityLarge(){
        fullArrList.expandCapacity(100);

        assertEquals(100, fullArrList.data.length);
    }
    

}
