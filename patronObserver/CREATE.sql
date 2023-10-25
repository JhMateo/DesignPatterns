CREATE TABLE SensorData
(
  id VARCHAR(255) NOT NULL,
  temperature decimal NOT NULL,
  humidity decimal NOT NULL,
  pressure decimal NOT NULL,
  observationdate timestamp NOT NULL,
  PRIMARY KEY (id)
);