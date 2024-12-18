public class Main {

    public static boolean sleepIn(boolean weekday, boolean vacation) {
		// Your solution here
        if (!weekday || vacation) {
            return true;
        }
        else {
            return false;
        }

	}

    public static boolean nearHundred(int x) {
        //Your solution here
        boolean bool = false;
        if ((Math.abs(x-100) <= 10 )||(Math.abs(x-200) <=10)) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    

    public static boolean sameFirstLast(int[] nums) {
        //Your solution here
        int n = nums.length;
        if (n >= 1 && (nums[0] == nums[n-1])) {
            return true;
        }

        else {
            return false;
        }
    }

    public static boolean no23(int[] nums) {
        //Your solution here
        int n = nums.length;
        boolean bool = true;
        for (int i=0; i<n; i++) {
            if (nums[i] == 2 || nums[i] ==3) {
                bool = false;
                break;
            }
            else {
                bool = true;
            }
        }
        return bool;

    }

    public static String helloName(String name) {
        //Your solution here
        String str = "Hello " + name + "!";
        return str;
    }
}