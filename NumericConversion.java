import java.util.Scanner;
public class NumericConversion {
    public static void menu()
    {
        //menu presented to user at beginning and after result
        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.println();
        System.out.print("Please enter an option: ");
    }
    public static long hexStringDecode(String hex)
    {
        //this if statement is used if 0x is put at the beginning of an input
        if (hex.charAt(1) == 'x')
        {
            hex = hex.substring(2);
        }
        //hexAnswer will be what is returned
        long hexAnswer = 0;
        //for loop used to make sure 16^power is to the correct power
        for (int i = 0; i < hex.length(); i++)
        {
            long number = 0;
            char digit = hex.charAt(i);
            //hexCharDecode is used to decode each individual digit in the string
            number = hexCharDecode(digit);
            number = number * (long) Math.pow(16,hex.length()-1-i);
            hexAnswer = hexAnswer + number;
        }
        return hexAnswer;

    }
    public static short hexCharDecode(char digit)
    {
        //This method converts an individual input character from the hexadecimal input to a number
        short number = 0;
        digit = Character.toLowerCase(digit);
        //switch statement for the digit to give it a number value
        switch (digit)
        {
            case '0':
            {
                number = 0;
                break;
            }
            case '1':
            {
                number = 1;
                break;
            }
            case '2':
            {
                number = 2;
                break;
            }
            case '3':
            {
                number = 3;
                break;
            }
            case '4':
            {
                number = 4;
                break;
            }
            case '5':
            {
                number = 5;
                break;
            }
            case '6':
            {
                number = 6;
                break;
            }
            case '7':
            {
                number = 7;
                break;
            }
            case '8':
            {
                number = 8;
                break;
            }
            case '9':
            {
                number = 9;
                break;
            }
            case 'a':
            {
                number = 10;
                break;
            }
            case 'b':
            {
                number = 11;
                break;
            }
            case 'c':
            {
                number = 12;
                break;
            }
            case 'd':
            {
                number = 13;
                break;
            }
            case 'e':
            {
                number = 14;
                break;
            }
            case 'f':
            {
                number = 15;
                break;
            }

        }

        return number;
    }
    public static short binaryStringDecode(String binary)
    {
        //this if statement is used if 0b is used to start the binary string
        if (binary.charAt(1) == 'b')
        {
            binary = binary.substring(2);
        }
        //binaryAnswer will be the number returned at the end of the method
        int binaryAnswer = 0;
        /*a switch case is not required for binary because the only input numbers are 1 and 0
        so the 2^power can just be multiplied by the input number
         */
        for (int i = 0; i < binary.length(); i++)
        {
            int number = binary.charAt(i)-48;
            number = number * (int) Math.pow(2,binary.length()-1-i);
            binaryAnswer = binaryAnswer + (short) number;
        }
        return (short) binaryAnswer;
    }
    public static String binaryToHex(String binary)
    {
        /*the binary method can be used to convert the string to binary,
        then the rest of this method convert decimal to hexadecimal
         */
        int decimal = binaryStringDecode(binary);
        //hexAnswer will be the returned string
        String hexAnswer = "";
        /*digit is a char so that adding on more digits
        will just add another character to the end string
         */
        char digit = 0;
        //do while statement used in case the input is 0
        do {
            int number = decimal % 16;
            decimal = decimal / 16;
            switch (number)
            {
                case 0:
                {
                    digit = '0';
                    break;
                }
                case 1:
                {
                    digit = '1';
                    break;
                }
                case 2:
                {
                    digit = '2';
                    break;
                }
                case 3:
                {
                    digit = '3';
                    break;
                }
                case 4:
                {
                    digit = '4';
                    break;
                }
                case 5:
                {
                    digit = '5';
                    break;
                }
                case 6:
                {
                    digit = '6';
                    break;
                }
                case 7:
                {
                    digit = '7';
                    break;
                }
                case 8:
                {
                    digit = '8';
                    break;
                }
                case 9:
                {
                    digit = '9';
                    break;
                }
                case 10:
                {
                    digit = 'A';
                    break;
                }
                case 11:
                {
                    digit = 'B';
                    break;
                }
                case 12:
                {
                    digit = 'C';
                    break;
                }
                case 13:
                {
                    digit = 'D';
                    break;
                }
                case 14:
                {
                    digit = 'E';
                    break;
                }
                case 15:
                {
                    digit = 'F';
                    break;
                }
            }
            //digit is added before hexAnswer so that the digits are added right to left
            hexAnswer = digit + hexAnswer;
        }
        while (decimal > 0);
        return hexAnswer;
    }
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        menu();

        int menuOption = keyboard.nextInt();


        while (menuOption != 4)
        {
            //this is before the if statements to reduce the amount of times it must be written
            System.out.print("Please enter the numeric string to convert: ");
            String numeric = keyboard.next();
            if (menuOption == 1)
            {
                //each if statement calls upon a different method, this one calls on decoding hex to decimal
                System.out.println("Result: " + hexStringDecode(numeric));
                System.out.println();
            }
            else if (menuOption == 2)
            {
                //this calls on the method to convert binary to decimal
                System.out.println("Result: " + binaryStringDecode(numeric));
                System.out.println();
            }
            else if (menuOption == 3)
            {
                //this calls on the method to convert binary to hexadecimal
                System.out.println("Result: " + binaryToHex(numeric));
                System.out.println();
            }

            menu();

            menuOption = keyboard.nextInt();

        }
        //ending statement if option 4 is picked
        System.out.println("Goodbye!");
    }
}
