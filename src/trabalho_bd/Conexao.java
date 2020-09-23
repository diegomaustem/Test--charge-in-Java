package trabalho_bd;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	 public void conectar(){
		 String servidor = "jdbc:mysql://localhost:3306/music";
		 String usuario = "root";
		 String senha = "root";
		 String driver = "com.mysql.jdbc.Driver";
		 
		 try {
			 Class.forName(driver);
			 this.connection = DriverManager.getConnection(servidor, usuario, senha);	
			 this.statement = this.connection.createStatement();
		 }catch(Exception e) {
			 System.out.println("Erro:" +e.getMessage());
		 }
		 
	 }
	 
	 public boolean estaConectado() {
		 if(this.connection != null){
			return true; 
		 }else {
			return false;
		 }
	 }
	
	public void listarA() {
		try {
			String query = "Select d.Descricao, (Select Nome from TB_Funcionario where Matricula = d.Mat_GerenteChefe), (Select Nome from TB_Funcionario where Matricula = d.Mat_GerenteAdj),"
					+ "count(e.CodLici), sum(e.ValorLici) from TB_Departamento d left join TB_Edital e on d.CodDP = e.DepartamentoCodDP  group by d.CodDP;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			
				while(this.resultset.next()) {
					System.out.println(
					this.resultset.getInt(1)+ "Descrição:"+
					this.resultset.getInt(2)+ "Gerente Chefe:" +
					this.resultset.getInt(3)+ "Gerente Adjunto:" +
					this.resultset.getInt(4)+ "Quantidade de licitações:" +
					this.resultset.getInt(5)+ "Somatorio Valores:");
				}
		
		}catch (Exception e) {
			System.out.println("Erro:" +e.getMessage());
		}
	}
	
	public void listarB() {
		try {
			String query = "Select e.CNPJ,ed.DescObj,ed.CodLici,ed.ValorLici,e.RazaoSocial, l.Empresa_Lance from TB_Empresa e inner join TB_Leilao l on e.CNPJ = l.Empresa_CNPJ inner join TB_Edital ed on ed.CodLici = l.Edital_CodLici;\r\n";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			
				while(this.resultset.next()) {
					System.out.println(
					this.resultset.getInt(1)+ "Identificação do Edital:"+
					this.resultset.getInt(2)+ "Descrição do Objeto:" +
					this.resultset.getInt(3)+ "Valor Estimado:" +
					this.resultset.getInt(4)+ "Cnpj:" +
					this.resultset.getInt(5)+ " Razão Social:"+
					this.resultset.getInt(6)+ " Lance Efetuado:");
				}
		
		}catch (Exception e) {
			System.out.println("Erro:" +e.getMessage());
		}
	}
	
	public void listarC() {
		try {
			String query = "";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			
				while(this.resultset.next()) {
					System.out.println(
					"" +
					this.resultset.getInt(1)+ "" +
					this.resultset.getInt(2)+ "" +
					this.resultset.getInt(3)+ "" +
					this.resultset.getInt(4)+ "" +
					this.resultset.getInt(5)+ "" +
					this.resultset.getInt(6)+ "");
				}
		
		}catch (Exception e) {
			System.out.println("Erro:" +e.getMessage());
		}
	}
	
}
