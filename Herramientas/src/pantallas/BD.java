package pantallas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	
	public String Usuario = "root";
	public String Contraseña = "";
	public Connection conn = null;
	
	
	public void Conectar(String BD){
		
		   
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      //STEP 3: Open a connection
		      
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/" + BD, Usuario, Contraseña);
		      
		   }
		   catch(Exception e){
			   System.err.println(e);
		   }
	}
	
	public void Desconectar(){
		try {
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
	
	
public BD(){
		
		String createDB = "CREATE DATABASE IF NOT EXISTS Herramientas_Jose";
		PreparedStatement preparedStatement = null;
		
		
		
		 try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      //STEP 3: Open a connection
		      
		      conn = DriverManager.getConnection("jdbc:mysql://localhost", Usuario, Contraseña);
		      preparedStatement = conn.prepareStatement(createDB);

		      preparedStatement.executeUpdate();
		      Desconectar();
		   }
		   catch(Exception e){
			   System.err.println(e);
		   }
	      
	}


public void InsertarHerramienta(String nombre, String descripcion, double Precio, int unidades) throws SQLException{
	String mensaje = "";
	Conectar("Herramientas_Jose");
	 String sqlCreate = "CREATE TABLE IF NOT EXISTS Herramientas" 
     + "  (ID INTEGER NOT NULL AUTO_INCREMENT,"
     + "   Nombre            VARCHAR(128) NOT NULL UNIQUE,"
     + "   Descripcion          VARCHAR(256) NOT NULL,"
     + "   Precio          DOUBLE NOT NULL,"
     + "   Unidades          INTEGER NOT NULL,"
     + " PRIMARY KEY ( ID ))";

	 Statement stmt = conn.createStatement();
	 stmt.execute(sqlCreate);
	
	
	 
	 Conectar("Herramientas_Jose");
	 
	 
	 String insertTableSQL = "INSERT INTO Herramientas"
				+ "(Nombre, Descripcion, Precio, Unidades) VALUES"
				+ "(?, ?, ?, ?)";
	PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
	preparedStatement.setString(1, nombre.toLowerCase());
	preparedStatement.setString(2, descripcion.toLowerCase());
	preparedStatement.setDouble(3, Precio);
	preparedStatement.setInt(4, unidades);
	preparedStatement .executeUpdate();
	Desconectar();
	
}

public boolean BuscarHerramienta(String nombre) throws SQLException{
	String resultado = "";
	boolean encontrado = false;
	Conectar("Herramientas_Jose");
	try{
		  String selectSQL = "SELECT Nombre FROM Herramientas WHERE Nombre = ?";
		  PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		  preparedStatement.setString(1, nombre.toLowerCase());
		  ResultSet rs = preparedStatement.executeQuery();
		  while (rs.next()) {
		  	resultado = rs.getString("Nombre");
		  }
		  
	}
	catch(Exception e){
			  System.err.println(e);
		  }
	Desconectar();
	if(resultado == "") encontrado = false;
	if(resultado != "") encontrado = true;
    return encontrado;
}

public void ActualizarHerramienta(String seleccion, String nombre, String descripcion, double precio, int unidades) throws SQLException{
	Conectar("Herramientas_Jose");
	
	
	
	String insertTableSQL = "";
	PreparedStatement preparedStatement = null;
	
		 insertTableSQL = "UPDATE Herramientas SET Nombre = ?, Descripcion = ?, Precio = ?, Unidades = ? WHERE Nombre = ?";
			preparedStatement = conn.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, nombre.toLowerCase());
			preparedStatement.setString(2, descripcion.toLowerCase());
			preparedStatement.setDouble(3, precio);
			preparedStatement.setInt(4, unidades);
			preparedStatement.setString(5, seleccion.toLowerCase());
	
	
		
	preparedStatement.executeUpdate();
	Desconectar();
	
	
}

public void EliminarHerramienta(String nombre) throws SQLException{
	Conectar("Herramientas_Jose");
	
	 
	 String insertTableSQL = "DELETE FROM Herramientas where Nombre = ?";
	PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
	preparedStatement.setString(1, nombre.toLowerCase());
	preparedStatement .executeUpdate();
	Desconectar();
}

// METODOS DE MATERIALES // 



public void InsertarMaterial(String nombre, String descripcion, double Precio, int unidades) throws SQLException{
	String mensaje = "";
	Conectar("Herramientas_Jose");
	 String sqlCreate = "CREATE TABLE IF NOT EXISTS Materiales" 
     + "  (ID INTEGER NOT NULL AUTO_INCREMENT,"
     + "   Nombre            VARCHAR(128) NOT NULL UNIQUE,"
     + "   Descripcion          VARCHAR(256) NOT NULL,"
     + "   Precio          DOUBLE NOT NULL,"
     + "   Unidades          INTEGER NOT NULL,"
     + " PRIMARY KEY ( ID ))";

	 Statement stmt = conn.createStatement();
	 stmt.execute(sqlCreate);
	
	
	 
	 Conectar("Herramientas_Jose");
	 
	 
	 String insertTableSQL = "INSERT INTO Materiales"
				+ "(Nombre, Descripcion, Precio, Unidades) VALUES"
				+ "(?, ?, ?, ?)";
	PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
	preparedStatement.setString(1, nombre.toLowerCase());
	preparedStatement.setString(2, descripcion.toLowerCase());
	preparedStatement.setDouble(3, Precio);
	preparedStatement.setInt(4, unidades);
	preparedStatement .executeUpdate();
	Desconectar();
	
}

public boolean BuscarMaterial(String nombre) throws SQLException{
	String resultado = "";
	boolean encontrado = false;
	Conectar("Herramientas_Jose");
	try{
		  String selectSQL = "SELECT Nombre FROM Materiales WHERE Nombre = ?";
		  PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		  preparedStatement.setString(1, nombre.toLowerCase());
		  ResultSet rs = preparedStatement.executeQuery();
		  while (rs.next()) {
		  	resultado = rs.getString("Nombre");
		  }
		  
	}
	catch(Exception e){
			  System.err.println(e);
		  }
	Desconectar();
	if(resultado == "") encontrado = false;
	if(resultado != "") encontrado = true;
    return encontrado;
}

public void ActualizarMaterial(String seleccion, String nombre, String descripcion, double precio, int unidades) throws SQLException{
	Conectar("Herramientas_Jose");
	
	
	
	String insertTableSQL = "";
	PreparedStatement preparedStatement = null;
	
		 insertTableSQL = "UPDATE Materiales SET Nombre = ?, Descripcion = ?, Precio = ?, Unidades = ? WHERE Nombre = ?";
			preparedStatement = conn.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, nombre.toLowerCase());
			preparedStatement.setString(2, descripcion.toLowerCase());
			preparedStatement.setDouble(3, precio);
			preparedStatement.setInt(4, unidades);
			preparedStatement.setString(5, seleccion.toLowerCase());
	
	
		
	preparedStatement.executeUpdate();
	Desconectar();
	
	
}

public void EliminarMaterial(String nombre) throws SQLException{
	Conectar("Herramientas_Jose");
	
	 
	 String insertTableSQL = "DELETE FROM Materiales where Nombre = ?";
	PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
	preparedStatement.setString(1, nombre.toLowerCase());
	preparedStatement .executeUpdate();
	Desconectar();
}


}
