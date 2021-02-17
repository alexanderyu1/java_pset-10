import java.util.ArrayList;
public class ProblemSet10 {

    public static void main(String[] args) {

    }

    public String[] fizzBuzz(int start, int end) {
        if(start > end){
            return null;
        }
        String[] arr = new String[end - start];
        int index = 0;

        for(int i = start; i < end; i++){
            String appendString = "";
            if(i%3 == 0){
                appendString += "Fizz";
            }
            if(i%5 == 0){
                appendString += "Buzz";
            }
            if(appendString.length() == 0){
                appendString = Integer.toString(i);
            }
            arr[index] = appendString;
            index++;
        }
        return arr;
    }

    public int maxSpan(int[] numbers) {
        int maxSpan = 0
                , count;
        count = 0;

        if(numbers == null){
            return -1;
        }

        for(int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                count++;
                if (numbers[i] == numbers[j]) {
                    if (count > maxSpan) {
                        maxSpan = count;
                    }
                }
            }
        }
        return maxSpan;
    }

    public int[] fix34(int[] numbers) {
        if(numbers == null){
            return null;
        }
        int threeCount = 0;
        ArrayList<Integer> threeIndexes = new ArrayList<>();
        int fourCount = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 3){
                if(numbers[i + 1] == 4){
                    return null;
                }
                threeCount++;
                threeIndexes.add(i);
            }
            if(numbers[i] == 4){
                if(threeCount == 0){
                    return null;
                }
                fourCount++;
            }
        }
        if(threeCount != fourCount){
            return null;
        }
        int[] arr = new int[numbers.length];
        for(int j : threeIndexes){
            arr[j] = 3;
            arr[j+1] = 4;
        }
        for(int k : numbers){
            for(int l = 0; l < arr.length; l++){
                if(arr[l] == 0 && k !=3 && k !=4){
                    arr[l] = k;
                }
            }
        }
        return arr;
    }

    public int[] fix45(int[] numbers) {
        if(numbers == null){
            return null;
        }
        int fourCount = 0;
        ArrayList<Integer> fourIndexes = new ArrayList<>();
        int fiveCount = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 4){
                if(numbers[i + 1] == 5){
                    return null;
                }
                fourCount++;
                fourIndexes.add(i);
            }
            if(numbers[i] == 5){
                fiveCount++;
            }
        }
        if(fourCount != fiveCount){
            return null;
        }
        int[] arr = new int[numbers.length];
        for(int j : fourIndexes){
            arr[j] = 4;
            arr[j+1] = 5;
        }
        for(int k : numbers){
            for(int l = 0; l < arr.length; l++){
                if(arr[l] == 0 && k !=4 && k !=5){
                    arr[l] = k;
                }
            }
        }
        return arr;
    }

    public boolean canBalance(int[] numbers) {
        int left = 0;
        int right = 0;

        if(numbers == null){
            return false;
        }
        if(numbers.length == 0){
            return false;
        }

        for(int i = 0; i < numbers.length - 1; i++){
            left += numbers[i];
            right = numbers[numbers.length - 1];
        }
        for(int i = numbers.length - 2; i > 0; i--){
            if(left == right)
                return true;
            left -= numbers[i];
            right += numbers[i];
        }
        return (left == right);
    }

    public boolean linearIn(int[] outer, int[] inner) {
        for(int i : inner){
            boolean exists = false;
            for(int k : outer){
                if(i == k){
                    exists = true;
                    break;
                }
            }
            if(!exists){
                return false;
            }
        }
        return true;
    }

    public int[] squareUp(int n) {
        if(n < 0){
            return null;
        }
        ArrayList<Integer> totalarr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int[] smallarr = new int[n];
            int numadditions = 0;
            for(int j = n - 1; j >=0; j--){
                if(numadditions < i + 1){
                    smallarr[j] = numadditions + 1;
                    numadditions++;
                }
            }
            for(int x : smallarr){
                totalarr.add(x);
            }
        }
        return totalarr.stream().mapToInt(i -> i).toArray();
    }

    public int[] seriesUp(int n) {
        if (n >= 0) {
            int[] index = new int[n * (n + 1) / 2];
            int series = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++, series++) {
                    index[series] = j;
                }
            }
            return index;
        } else {
            return null;
        }
    }

    public int maxMirror(int[] numbers) {
        if(numbers == null){
            return -1;
        }

        int max = 0;

        for (int x = 0; x < numbers.length; ++x)
            for (int y = max + 1; y < numbers.length - x + 1; ++y)
                for (int z = x; z < numbers.length - y + 1; ++z) {
                    Boolean mirror = true;

                    for (int i = 0; mirror && i < y; ++i)
                        mirror = numbers[x + i] == numbers[z + y - i - 1];

                    if (mirror) max = y;
                }
        return max;
    }

    public int countClumps(int[] numbers) {
        int count = 0;
        boolean clumps = false;

        if(numbers == null){
            return -1;
        }
        for(int i = 0; i < numbers.length - 1; i++) {
            if(clumps) {
                if(numbers[i] != numbers[i+1])
                    clumps = false;
            }
            else if(numbers[i] == numbers[i+1]) {
                clumps = true;
                count++;
            }
        }
        return count;
    }
}
