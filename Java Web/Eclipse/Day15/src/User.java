import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class User {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@TODO
	public String toString() {
		return "User []";
	}

}
@Target({ElementType.TYPE, ElementType.METHOD})
@interface TODO {
	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	public enum Status {
		STARTED, NOT_STARTED
	}

	String author() default "XHJ";

	Priority priority() default Priority.LOW;

	Status status() default Status.NOT_STARTED;
}