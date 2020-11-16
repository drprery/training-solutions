package introexception.patient;

public class SsnValidator {
    public boolean isValidSsn(String ssn) {
        if (ssn.length() != 9) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < ssn.length() - 1; i += 2) {
                sum += intFromChar(ssn.charAt(i)) * 3;
            }
            for (int i = 1; i < ssn.length() - 1; i += 2) {
                sum += intFromChar(ssn.charAt(i)) * 7;
            }
            return (intFromChar(ssn.charAt(8)) == (sum % 10));
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private int intFromChar(char aChar) {
        if (aChar < '0' || aChar > '9')
            throw new IllegalArgumentException("Not only numbers included.");
        return aChar - '0';
    }
}
