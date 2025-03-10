import Filter.MyFilter;

public class App {

    private static void print(Object[] array, String string) {
        System.out.print(string);
        
        for (Object item : array) {
            if (item == null) {
                continue;
            }

            System.out.print(item + " ");
        }

        System.out.println();
    }
    
    private static Object[] filter(
        Object[] array, 
        MyFilter filter, 
        Object   filterValue) {

        Object[] resultArray = new Object[array.length];

        int resultIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != filterValue) {
                resultArray[resultIndex] = filter.apply(array[i]);
                resultIndex++;
            }
        }

        return resultArray;
    }

    public static void main(String[] args) {
        
        Integer[] intArray  = {1, 2, 3, 43, 5};
        Object[]  intObject = filter(intArray, new MyFilter(), 43);

        Long[]   longArray  = {6l, 4l, 33l, 42l, 5l, 66l};
        Object[] longObject = filter(longArray, new MyFilter(), 66l);

        print(intArray, "Int   до: ");
        print(longArray, "Long  до: ");

        print(intObject, "Int   после: ");  // Нет 43 
        print(longObject, "Long  после: "); // Нет 66
    }
}
