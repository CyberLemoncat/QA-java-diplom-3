package pages;

import net.datafaker.Faker;

public class RandomUser {
    private static final Faker faker = new Faker();
    public static final String TEST_USER_EMAIL = faker.internet().emailAddress();
    public static final String TEST_USER_PASSWORD = faker.internet().password(6, 10);
    public static final String TEST_USER_NAME = faker.name().firstName();
}
