package co.com.rale.restgeneratorcli.repository.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConfigTest {

  private DBSecret dbSecretUnderTest;
  private Config ConfigUnderTest;

  @BeforeEach
  void setUp() {
    ConfigUnderTest = new Config();

    dbSecretUnderTest =
        DBSecret.builder()
            .password("sa")
            .username("sa")
            .url("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")
            .build();
  }

  @Test
  void dbSecretTest() {
    String engine = "h2";
    String host = "mem";
    String database = "test";
    String options = "DB_CLOSE_DELAY=-1";
    String username = "sa";
    String password = "sa";

    DBSecret secretResult = null;
    try {
      secretResult =
          ConfigUnderTest.getDBSecret(engine, host, null, database, username, password, options);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    assertEquals(dbSecretUnderTest.getUrl(), secretResult.getUrl());
    assertEquals(dbSecretUnderTest.getUsername(), secretResult.getUsername());
    assertEquals(dbSecretUnderTest.getPassword(), secretResult.getPassword());
  }
}
