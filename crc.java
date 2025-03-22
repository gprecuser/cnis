import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Generator:");
        String gen = sc.nextLine();

        System.out.println("Enter Data:");
        String data = sc.nextLine();

        String code = data;
        while (code.length() < (data.length() + gen.length() - 1))
            code = code + "0";
        code = data + div(code, gen);
        System.out.println("The transmitted Code Word is: " + code);

        System.out.println("Please enter the received Code Word:");
        String rec = sc.nextLine();

        if (Integer.parseInt(div(rec, gen)) == 0)
            System.out.println("The received code word contains no errors.");
        else
            System.out.println("The received code word contains errors.");

        sc.close();
    }

    static String div(String code, String gen) {
        int pointer = gen.length();
        String result = code.substring(0, pointer);
        String remainder = "";
        for (int i = 0; i < gen.length(); i++) {
            remainder += (result.charAt(i) == gen.charAt(i)) ? "0" : "1";
        }
        while (pointer < code.length()) {
            remainder = remainder.substring(1) + code.charAt(pointer);
            pointer++;
            if (remainder.charAt(0) == '0') continue;
            String temp = "";
            for (int i = 0; i < gen.length(); i++) {
                temp += (remainder.charAt(i) == gen.charAt(i)) ? "0" : "1";
            }
            remainder = temp;
        }
        return remainder.substring(1);
    }
}
