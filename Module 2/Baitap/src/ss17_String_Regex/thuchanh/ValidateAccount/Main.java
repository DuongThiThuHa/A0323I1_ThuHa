package ss17_String_Regex.thuchanh.ValidateAccount;

public class Main {
    private static Account validateAccount;

    public static final String[] validAccount = new String[] {"123abc_\", \"_abc123\", \"______\", \"123456\",\"abcdefgh"};
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String[] args) {
        validateAccount = new Account();
        for (String account : validAccount){
            boolean isValid = validateAccount.validate(account);
            System.out.println("Account is "+ account + " is valid "+ isValid);
        }

        for (String account : invalidAccount){
            boolean isValid = validateAccount.validate(account);
            System.out.println("Account is "+ account + " is valid "+ isValid);
        }

    }
}
