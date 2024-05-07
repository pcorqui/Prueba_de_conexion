import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myrest = null;
        PreparedStatement preparedStatement = null;

        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","admin");
            System.out.println("Genial, nos conectamos");

            myStamt = myConn.createStatement();
//            myrest = myStamt.executeQuery("SELECT * FROM employees");
//
//            while(myrest.next()){
//                System.out.println(myrest.getString("first_name"));
//            }

            String sql = ("INSERT INTO employees (first_name, pa_surname) VALUES (?,?)");
            preparedStatement = myConn.prepareStatement(sql);
            preparedStatement.setString(1,"Paul");
            preparedStatement.setString(2,"Cortes");

            int rowAffected = 0;//preparedStatement.executeUpdate();

            if(rowAffected> 0){
                System.out.println("Se ha creado un nuevo empleado");
            }

            //actualizar
//            rowAffected = preparedStatement.executeUpdate("UPDATE employees set first_name='paulo' where id = 7");
//            if(rowAffected>1){
//                System.out.println("dato actualizado");
//            }

            //borrar
            myStamt.executeUpdate("Delete from employees where first_name = 'Paul'");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal ):");
        }

    }
}