import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PatientDAO {


    public static  Patient getPatient(String ID) {
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
        Patient patient = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT * FROM patient WHERE patientID = '"+ID+"'");
            patient = new Patient();
            patient.setPatientID(result.getString("patientID"));
            patient.setName(result.getString("name"));
            patient.setSurname(result.getString("surname"));
            patient.setDate(result.getString("date"));
            patient.setInsuranceCode(result.getString("insuranceCode"));

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return patient;
    }

    public static boolean insertPatient(Patient patient) {
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/universitydb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate("INSERT INTO patient VALUES ('"+patient.getPatientID()+"', '"+
                                                                            patient.getName()+"', '"+
                                                                            patient.getSurname()+"', '"+
                                                                            patient.getDate()+"', '"+
                                                                            patient.getInsuranceCode()+"', '"+
                                                                         "' )");
            con.commit();
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        if(result == 0){
            return false;
        }
        else{
            return true;
        }
    }


    public static List<Patient> getPatientList(){
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
        ArrayList<Patient> output = new ArrayList<Patient>();
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/hospitaldb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT * FROM patient ");

            while(result.next()){
                Patient p = new Patient();
                p.setPatientID(result.getString("patientID"));
                p.setName(result.getString("name"));
                p.setSurname(result.getString("surname"));
                p.setDate(result.getString("date"));
                p.setInsuranceCode(result.getString("insuranceCode"));
                output.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return output;
    }

}
