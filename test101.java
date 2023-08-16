import java.util.Scanner;
public class test101
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String msg = sc.nextLine();
        System.out.print("Enter the shift value: ");
        int shift = sc.nextInt();
        String encodedMsg = encode(msg, shift);
        System.out.println("Encoded message: " + encodedMsg);
        String decodedMsg = decode(msg, shift);
        System.out.println("Decoded message: " + decodedMsg);
    }
    public static String encode(String input, int shift) 
    {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < input.length(); i++) 
        {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) 
            {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                char encodedChar = (char) (base + (currentChar - base + shift) % 26);
                encoded.append(encodedChar);
            } 
            else 
            {
                encoded.append(currentChar);
            }
        }
        return encoded.toString();
    }
    public static String decode(String input, int shift) 
    {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < input.length(); i++) 
        {
            char currentChar = input.charAt(i);
            if (Character.isLetter(currentChar)) 
            {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                char decodedChar = (char) (base + (currentChar - base + (26 - shift)) % 26);
                decoded.append(decodedChar);
            } 
            else 
            {
                decoded.append(currentChar);
            }
        }
        return decoded.toString();
    }
}
