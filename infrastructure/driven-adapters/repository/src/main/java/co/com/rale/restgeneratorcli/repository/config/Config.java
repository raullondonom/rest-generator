package co.com.rale.restgeneratorcli.repository.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

  public DBSecret getDBSecret(
      String engine,
      String host,
      String port,
      String database,
      String username,
      String password,
      String options)
      throws Exception {
    switch (engine) {
      case "postgresql":
        return getDBSecretPostgreSQL(engine, host, port, database, username, password, options);
      case "h2":
        return getDBSecretH2(engine, host, database, username, password, options);
      default:
        // TODO: Incluir excepcion personalizada
        throw new Exception("Not suported database");
    }
  }

  private DBSecret getDBSecretPostgreSQL(
      String engine,
      String host,
      String port,
      String database,
      String username,
      String password,
      String options) {
    return DBSecret.builder()
        .url("jdbc:" + engine + "://" + host + ":" + port + "/" + database + ";" + options)
        .username(username)
        .password(password)
        .build();
  }

  private DBSecret getDBSecretH2(
      String engine,
      String host,
      String database,
      String username,
      String password,
      String options) {
    return DBSecret.builder()
        .url("jdbc:" + engine + ":" + host + ":" + database + ";" + options)
        .username(username)
        .password(password)
        .build();
  }

  public Connection getConnection(
      String engine,
      String host,
      String port,
      String database,
      String username,
      String password,
      String options)
      throws SQLException, Exception {
    DBSecret secret = getDBSecret(engine, host, port, database, username, password, options);
    return DriverManager.getConnection(secret.getUrl(), secret.getUsername(), secret.getPassword());
  }
}
