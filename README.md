# Setup

The database used by the project is **Postgresql**.

## Usage with docker
### Create the container

```
docker run --name jee-app -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres
```
*Note*: It might take a while as it must download the [Postgres image](https://hub.docker.com/_/postgres).

### Enter the container 

```
docker exec -it jee-app psql -U postgres
```

## Apply schema
First, create the database we will be using

```
DROP DATABASE forum;
CREATE DATABASE forum;
```

Enter in the database:
```
\c forum
```

Then, copy and paste the SQL that can be found at `WebContent/WEB-INF/schema.sql`.

## Feed the database

```SQL
INSERT INTO user_forum(name, password, role) VALUES
('Jean', '123', 0),
('Michel', '468', 1),
('Esteban', 'mac4ever', 2);

INSERT INTO forum(id) VALUES (1), (2);

INSERT INTO topic(name, id_forum) VALUES
('Super topic', 1),
('Another cool topic', 1),
('JEE', 2);

INSERT INTO discussion(name, status, id_topic) VALUES
('Discussion sérieuse', 0, 1),
('Another cool topic', 0, 1),
('Hello', 1, 2);

INSERT INTO message(content, sent_at, id_discussion, id_user_forum) VALUES
('Que pensez-vous de ça ?', NOW(), 1, 1),
('Je pense que c bien', NOW(), 1, 2),
('Tout seul', NOW(), 2, 1);
```

## Change your configurations

Open up `src/services/ConnectionFactory.java`.

You might change the following lines if you chose not to follow the examples : 
```Java
  /** Connection URL. */
  private static final String PROPERTY_URL = "jdbc:postgresql://localhost:5432/forum";

  /** User which has access to the database. */
  private static final String PROPERTY_USER = "postgres";

  /** User password. */
  private static final String PROPERTY_PASSWORD = "password";
```

# Clean-up

## With Docker
```
docker container stop jee-app
docker container rm jee-app
```
