public class arrayShit {
    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,5,6,7,8,9,10,11};
        recursiveGetter(array, 0, array.length);
    }

    public static void recursiveGetter(int[] array, int min, int max) {
        int mid = (max + min) / 2;

        if (max != min) {
            System.out.println(array[mid]);
            recursiveGetter(array, min, mid);
            recursiveGetter(array, mid + 1, max);
        }
    }
}
