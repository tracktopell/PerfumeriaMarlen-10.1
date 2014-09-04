
mysql --default-character-set=utf8 -u PMARLEN_DEVE -pPMARLEN_DEVE_PASSWORD PMARLEN_DB_DEVE < DELETE_DATA.SQL 

mvn clean compile exec:java -Dexec.mainClass=com.pmarlen.migration.ImportData -Dexec.args="PMARLEN_TEST PMARLEN_TEST_PASSWORD jdbc:mysql://localhost/PMARLEN_DB_TEST?characterEncoding=UTF-8&useOldAliasMetadataBehavior=true PMARLEN_DEVE PMARLEN_DEVE_PASSWORD jdbc:mysql://localhost/PMARLEN_DB_DEVE?characterEncoding=UTF-8&useOldAliasMetadataBehavior=true" 
