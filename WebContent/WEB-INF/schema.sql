#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: forum
#------------------------------------------------------------

CREATE TABLE forum(
        id_forum Int  Auto_increment  NOT NULL
	,CONSTRAINT forum_PK PRIMARY KEY (id_forum)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: topic
#------------------------------------------------------------

CREATE TABLE topic(
        id_topic Int  Auto_increment  NOT NULL ,
        name     Varchar (50) NOT NULL ,
        id_forum Int NOT NULL
	,CONSTRAINT topic_PK PRIMARY KEY (id_topic)

	,CONSTRAINT topic_forum_FK FOREIGN KEY (id_forum) REFERENCES forum(id_forum)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: discussion
#------------------------------------------------------------

CREATE TABLE discussion(
        id_discussion Int  Auto_increment  NOT NULL ,
        name          Varchar (50) NOT NULL ,
        status        TinyINT NOT NULL ,
        id_topic      Int NOT NULL
	,CONSTRAINT discussion_PK PRIMARY KEY (id_discussion)

	,CONSTRAINT discussion_topic_FK FOREIGN KEY (id_topic) REFERENCES topic(id_topic)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: user
#------------------------------------------------------------

CREATE TABLE user(
        id_user  Int  Auto_increment  NOT NULL ,
        name     Varchar (255) NOT NULL ,
        password Varchar (50) NOT NULL
	,CONSTRAINT user_PK PRIMARY KEY (id_user)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: message
#------------------------------------------------------------

CREATE TABLE message(
        id_message    Int  Auto_increment  NOT NULL ,
        content       Text NOT NULL ,
        sentAt        Date NOT NULL ,
        id_discussion Int NOT NULL ,
        id_user       Int NOT NULL
	,CONSTRAINT message_PK PRIMARY KEY (id_message)

	,CONSTRAINT message_discussion_FK FOREIGN KEY (id_discussion) REFERENCES discussion(id_discussion)
	,CONSTRAINT message_user0_FK FOREIGN KEY (id_user) REFERENCES user(id_user)
)ENGINE=InnoDB;

