package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        return !"".equals(username);
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1.length()>=8 && password1.equals(password2);
    }

    public boolean isValidEmail(String email) {

        int wormPos=email.indexOf('@');
        String domain=email.substring(wormPos+1);
        int dotPos=domain.indexOf('.');

        return wormPos>0 && dotPos<domain.length()-1 && dotPos>0 && dotPos>wormPos+1;
    }
}
