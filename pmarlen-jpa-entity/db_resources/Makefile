# Makefile instalcaion de ambiente de Base de Datos del Sistema Perfumeria Marlen

# make init_DB_DEVE MYSQL_ROOT_PASSWORD=xxxxxx

#IMGS_DIR=../../Fotos_Perfumeria_Marlen
#PREFIX_IMG=0000.JPG

#prapre_DB_TEST : ../../pmarlen-logic/src/test/resources/initScenarioForTest.sql
#	mysql --default-character-set=utf8 -u PMARLEN_TEST -pPMARLEN_TEST_PASSWORD PMARLEN_DB_TEST < ../../pmarlen-logic/src/test/resources/initScenarioForTest.sql

init_DB_DEVE : create_users_DEVE 
	echo import from previous DB to be defined.

create_users_DEVE : create_DB_DEVE
	mysql --default-character-set=utf8 -u root -p$(MYSQL_ROOT_PASSWORD) < sql/CREATE_DBUSER_DEVE.MySQL.SQL

create_DB_DEVE : sql/CREATE_SCHEMA_DEVE.MySQL.SQL sql/CREATE_SCHEMA_DEVE.MySQL.SQL
	mysql --default-character-set=utf8 -u root -p$(MYSQL_ROOT_PASSWORD) < sql/CREATE_SCHEMA_DEVE.MySQL.SQL

run_regenerate_scripts_DB : model/exported/project.xml model/jpa-builder-0.9.7.jar
	java -cp model/jpa-builder-0.9.7.jar com.tracktopell.dao.builder.dbschema.VPModel2SQL model/exported/project.xml mysql PMARLEN_DB_DEVE sql/CREATE_SCHEMA_DEVE.MySQL.SQL  "{all}" > resultsgen_mysql.txt 2> debug_resultsgen_mysql.txt
	java -cp model/jpa-builder-0.9.7.jar com.tracktopell.dao.builder.dbschema.VPModel2SQL model/exported/project.xml derby PMARLEN_DB      sql/CREATE_SCHEMA.DERBY.SQL       "{all}" > resultsgen_mysql.txt 2> debug_resultsgen_mysql.txt

run_regenerate_JPABeans : model/exported/project.xml model/jpa-builder-0.9.7.jar
	java -cp model/jpa-builder-0.9.7.jar com.tracktopell.dao.builder.jpa.VPModel2DTOAndBeans  model/exported/project.xml com.pmarlen.wscommons.services.dto  com.pmarlen.model.beans ../src/main/java "{all}"
	java -cp model/jpa-builder-0.9.7.jar com.tracktopell.dao.builder.jpa.UpdatePersistenceXML model/exported/project.xml model/persistence.xml com.pmarlen.model.beans "{all}" > ../src/main/resources/META-INF/persistence.xml

# sudo aptitude install librsvg2-bin
create_png: /usr/bin/rsvg model/exported/ER1.svg
	rsvg -f png model/exported/ER1.svg model/exported/ER1.png

clean_results :
	rm -f debug*
	rm -f results*
