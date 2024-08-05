package utilities;

import com.github.javafaker.Faker;

/**
 * Creating sample test data using Faker to create the NEW user everytime
 * @author devesh.sarda
 */
public class SampleTestData 
{
	public static final Faker faker = new Faker();
    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();
    public static final String password = faker.internet().password(8, 15, true, true, true);
    public static final String email = faker.internet().emailAddress();
	
    /**
     * Getter for first name
     * @return
     */
	public static String getFirstName() {
		return firstName;
	}
	
	/**
	 * Getter for last name
	 * @return
	 */
	public static String getLastName() {
		return lastName;
	}
}