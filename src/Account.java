public abstract class Account implements User{
	protected String username;

    public Account(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public abstract void showMenu(); // forced on child classes
	
	
}