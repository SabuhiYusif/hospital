import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {

	public static void initializeDatabase(){
		Connection con = null;
		Statement stmt = null;

        try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
			stmt = con.createStatement();

//			stmt.executeUpdate("CREATE TABLE student (studentID varchar(20) NOT NULL, PRIMARY KEY (studentID));");
			stmt.executeUpdate("CREATE TABLE patient (patientID varchar(20) PRIMARY KEY," +
														   "name varchar(30)," +
															"surname varchar(30)," +
															"date varchar(30)," +
															"insuranceCode varchar(60)" +
					");");
//			stmt.executeUpdate("CREATE SEQUENCE SEQU");
//			stmt.executeUpdate("CREATE TABLE patientFolder (ID INTEGER GENERATED BY DEFAULT AS SEQUENCE SEQU PRIMARY KEY," +
//																 "patientID varchar(30)," +
//
//																 "oncologistID varchar(30)" +
//																 "firstVisitDate varchar(30)" +
//																	");");
////
//			stmt.executeUpdate("CREATE TABLE visit (ID INTEGER PRIMARY KEY," +
//														"oncologistID INTEGER" +
//														"patientID varchar2(20)" +
//														"visitDate varchar2(30)" +
//					") ");
//			stmt.executeUpdate("CREATE TABLE oncologist (professionalID INTEGER PRIMARY KEY," +
//																"name VARCHAR2(30)," +
//																"surname VARCHAR2(30)," +
//																"type VARCHAR2(40)," +
//																"careerLevel VARCHAR2(30)" +
//					")");
//
			stmt.executeUpdate("CREATE TABLE user (username varchar(20) NOT NULL,  PRIMARY KEY(username),  password varchar(20) NOT NULL, role varchar(50) NOT NULL);");

			stmt.executeUpdate("CREATE TABLE medicine (id varchar(20) NOT NULL,  PRIMARY KEY(id),  name varchar(20) NOT NULL, companyName varchar(50) NOT NULL);");

			System.out.println("Database initialized successfully");
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	public static void resetDatabase(){
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
			stmt = con.createStatement();
//			stmt.executeUpdate("DROP TABLE patient;");
//			stmt.executeUpdate("DROP TABLE patientFolder;");
			stmt.executeUpdate("DROP TABLE user;");
			stmt.executeUpdate("DROP TABLE medicine;");
//			stmt.executeUpdate("DROP TABLE user;");
			System.out.println("Database reset successfully");
		}  catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}



}