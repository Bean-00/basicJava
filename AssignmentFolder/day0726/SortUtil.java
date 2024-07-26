package AssignmentFolder.day0726;

public class SortUtil {
    public int[] ascending(int[] inputNumbers) {
        int[] array = inputNumbers;

        for (int pivot = 0; pivot < array.length; pivot++) {
            for (int target = pivot + 1; target < array.length; target++) {
                if (array[target] < array[pivot]) {
                    int temp = array[pivot];
                    array[pivot] = array[target];
                    array[target] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        SortUtil util = new SortUtil();
        int[] numbers = new int[] {7, 5, 2, 19, 34, 51, 32, 11, 67, 21};

        numbers = util.ascending(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);

            if (i != numbers.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("");
            }
        }
        System.out.println("Successful!!");
    }
}