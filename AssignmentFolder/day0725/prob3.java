package AssignmentFolder.day0725;

public class prob3 {
    public static void main(String[] args) {

        int[] array = {3, 24, 1, 55, 17, 42, 5};
        String arrayResult = "";

        for (int index = 0; index < array.length; index++) {
            int pivot = index;
            for (int target = pivot + 1; target < array.length; target++) {
                if (array[target] < array[pivot]) {
                    int temp = array[pivot];
                    array[pivot] = array[target];
                    array[target] = temp;
                }
            }
            arrayResult += "[" + String.valueOf(array[index]) + "] ";
        }
        System.out.println(arrayResult);
    }
}