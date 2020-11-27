package week05d05;

public class User {
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {

        if(isEmpty(firstName) || isEmpty(lastName)){
            throw new NullPointerException("Valamelyik név hiányzik!");
        }

        this.firstName = firstName;
        this.lastName = lastName;

        if(!isValidEmail(email)){
            throw new IllegalArgumentException("Nem szabályos az email cím!");
        }
        this.email = email;
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }

    public boolean isValidEmail(String email) {

        int wormPos=email.indexOf('@');
        String domain=email.substring(wormPos+1);
        int dotPos=domain.indexOf('.');

        return wormPos>0 && dotPos<domain.length()-1 && dotPos>0 && dotPos>wormPos+1;
    }

    public boolean isEmpty(String str){
        if(str==null || str.trim().equals("")){
            return true;
        } else {
            return false;
        }
    }
}
