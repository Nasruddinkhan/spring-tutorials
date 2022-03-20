SQL> create table student(sno number(5) primary key,
                         sname varchar2(20),
                         total number(10,2),
                         avg number(10,2),
                         result varchar2(10));
cmd>mvn install:install-file -Dfile=C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar -DgroupId=com.mypractice  -DartifactId=ojdbc6 -Dversion=11.2 -Dpackaging=jar