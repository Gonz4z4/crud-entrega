
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static Connection con;
    private static BasicDataSource dataSource;
    
    private static DataSource getDataSource() { //crea el data source
        if (dataSource == null) {
            try {
                String url = "jdbc:mysql://root:gonza2001@localhost:3306/crud_juegos?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true"; //url de mi base de datos!!
                dataSource = new BasicDataSource();
                dataSource.setUrl(url);
                dataSource.setInitialSize(50); 
                //cantidad de conexiones (mientras menos, menos gasto de memoria pero a más conexiones anda más lento
            }
            catch (Exception ex) {
                throw new RuntimeException("Error al conectar con la BD", ex);
            }
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException { //Devuelve la conexión a través del data source
        return getDataSource().getConnection();
    }
    
}
