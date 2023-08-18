import java.util.Scanner;
class DataItem 
{
    int k=1;
    String key;
    String encodedValue;
    DataItem(String key, String value) 
    {
        this.key = key;
        this.encodedValue = encode(value, k); // Encode the value using Caesar cipher
    }
    private String encode(String text, int shift) 
    {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) 
        {
            if (Character.isLetter(c)) 
            {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            }
            else 
            {
                result.append(c);
            }
        }
        return result.toString();
    }
    String getEncodedValue() 
    {
        return encodedValue;
    }
    String getDecodedValue() 
    {
        return encode(encodedValue, 26 - k);
    }
}
public class caesar_cipheer 
{
    public static void main(String[] args) 
    {
        final int MAX_ITEMS = 100;
        DataItem[] dataItems = new DataItem[MAX_ITEMS];
        int itemCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.print("Do you want to create a new data item or retrieve an existing one? (create/retrieve/exit): ");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("exit")) 
            {
                break;
            } 
            else if (action.equalsIgnoreCase("create")) 
            {
                System.out.print("Enter a unique key name: ");
                String key = scanner.nextLine();
                boolean isDuplicate = false;
                for (int i = 0; i < itemCount; i++) 
                {
                    if (dataItems[i] != null && dataItems[i].key.equals(key)) 
                    {
                        isDuplicate = true;
                        break;
                    }
                }
                if (isDuplicate) 
                {
                    System.out.println("Key name '" + key + "' is already used. Please enter a different key.");
                    continue;
                }
                System.out.print("Enter the value: ");
                String value = scanner.nextLine();
                dataItems[itemCount] = new DataItem(key, value);
                itemCount++;
                if (itemCount >= MAX_ITEMS) 
                {
                    System.out.println("Maximum number of items reached.");
                    break;
                }
            } 
            else if (action.equalsIgnoreCase("retrieve")) 
            {
                System.out.print("Enter a key name to retrieve its encoded value: ");
                String key = scanner.nextLine();
                DataItem foundItem = null;
                for (int i = 0; i < itemCount; i++) 
                {
                    if (dataItems[i] != null && dataItems[i].key.equals(key)) 
                    {
                        foundItem = dataItems[i];
                        break;
                    }
                }
                if (foundItem != null) 
                {
                    System.out.println("Encoded value for '" + key + "': " + foundItem.getEncodedValue());

                    System.out.print("Do you want to see the decoded text? (yes/no): ");
                    String viewChoice = scanner.nextLine();

                    if (viewChoice.equalsIgnoreCase("yes")) 
                    {
                        System.out.println("Decoded value for '" + key + "': " + foundItem.getDecodedValue());
                    }
                } 
                else 
                {
                    System.out.println("No data found for key '" + key + "'.");
                }
            } 
            else 
            {
                System.out.println("Invalid action. Please choose 'create', 'retrieve', or 'exit'.");
            }
        }
        scanner.close();
    }
}
