DROP TABLE pronosticos;

CREATE TABLE pronosticos (
  id int(11) NOT NULL AUTO_INCREMENT,
  idParticipante int(11) DEFAULT NULL,
  nombreParticipante varchar(45) DEFAULT NULL,
  nombreEquipo1 varchar(45) DEFAULT NULL,
  ganaEquipo1 varchar(45) DEFAULT NULL,
  empate varchar(45) DEFAULT NULL,
  ganaEquipo2 varchar(45) DEFAULT NULL,
  nombreEquipo2 varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

INSERT INTO pronosticos (idParticipante, nombreParticipante, nombreEquipo1, ganaEquipo1, empate, ganaEquipo2, nombreEquipo2)
VALUES  
(1, 'Mariana', 'Argentina', 'X', '', '', 'Arabia Saudita'), 
(1, 'Mariana', 'Polonia', '', 'X', '', 'México'), 
(1, 'Mariana', 'Argentina', 'X', '', '', 'México'), 
(1, 'Mariana', 'Arabia Saudita', '', '', 'X', 'Polonia'),
(2, 'Pedro', 'Argentina', 'X', '', '', 'Arabia Saudita'), 
(2, 'Pedro', 'Polonia', '', '', 'X', 'México'), 
(2, 'Pedro', 'Argentina', 'X', '', '', 'México'), 
(2, 'Pedro', 'Arabia Saudita', '', 'X', '', 'Polonia') ,
(3, 'Javier', 'Argentina', 'X', '', '', 'Arabia Saudita'), 
(3, 'Javier', 'Polonia', '', '', 'X', 'México'), 
(3, 'Javier', 'Argentina', 'X', '', '', 'México'), 
(3, 'Javier', 'Arabia Saudita', '', 'X', '', 'Polonia') ;