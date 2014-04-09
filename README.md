1. Download play framework: http://playframework.com/
2. Add it to your system path
3. Install MySQL if needed
4. Create a database and execute the table definition found at http://stat-computing.org/dataexpo/2009/sqlite.html
5. Download a .csv from http://stat-computing.org/dataexpo/2009/the-data.html, the 1987 is decent enough size
(1m rows, but only 80 000 are needed currently). Place it in client/data
6. Open server/conf/application.conf and enter the mysql details
```
db.default.url="jdbc:mysql://localhost:3306/testdb"
db.default.user=root
db.default.password=""
```
7. Open client/src/net/pixomania/dbtest/client/Main and change the line
```ArrayList<Flight> flights = Util.loadFlights(new File("C:\\Users\\Victor\\dbtest\\client\\data\\1987.csv"));```
to correspond with the absolute path to the .csv.
8. Open a terminal window. cd into the server directory. Execute ```play compile``` followed by ```play start```
9. Run client/Main.java (start MySQL prior)
10. Program should now send 80 000 consecutive requests, and 80 000 rows should have been inserted into the database
11. To shutdown the server after executing ```play start```, press Ctrl-D, open a terminal and terminate the
java process of the server, and then remove the RUNNING_PID from the server directory.

** Note: DB4o does not run on development (the ```play run``` command) and has to be tested in production
(the ```play start``` command) **

Relationships implemented in branch 'relational'