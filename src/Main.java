
public class Main {
    public static final String REGEX = "^[a-zA-Z0-9_]*$";

    public static void main(String[] args) {
        try {
            check("Test", "123", "123");
            System.out.println("всё ок");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("некорректный логин");
        }
        if(login.length()>20){
            throw new WrongLoginException("размер больше 20");
        }
        if(!password.matches(REGEX)){
            throw new WrongPasswordException("некорректный пароль");
        }
        if(password.length()>20){
            throw new WrongPasswordException("пароль больше 20");
        }
        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("пароли не совпадают");
        }
    }
}
