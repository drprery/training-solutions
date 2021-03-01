package covid;

public class Validator {

    public boolean isValidFullName(String name){
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isValidZipCode(String code){
        if (code == null || code.trim().length() != 4){
            return false;
        }
        return true;
    }

    public boolean isValidAge(int age){
        if (age > 150 || age < 10){
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email){
        String trimmedEmail = email.trim();

        int wormPos=trimmedEmail.indexOf("@");
        String domain=trimmedEmail.substring(wormPos+1);
        int dotPos=domain.indexOf(".");

        return wormPos>0 && dotPos>0 && dotPos<domain.length()-1 && trimmedEmail.indexOf(".")>wormPos+1 && trimmedEmail.length() > 5;
    }

    public boolean isValidSsn(String ssn){
        if (ssn.length() != 9) {
            return false;
        }
        int sum = 0;
        String[] ssnChars = ssn.split("");

        for (int i = 0; i < ssnChars.length - 1; i++) {
            int num = Integer.parseInt(ssnChars[i]);
            sum += i % 2 == 0 ? num * 3 : num * 7;
        }
        int controlNum = Integer.parseInt(ssnChars[ssnChars.length - 1]);
        return sum % 10 == controlNum;
    }
}
