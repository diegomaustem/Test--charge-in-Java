package trabalho_bd;

public class Teste {

	public static void main(String[] args) {
		Conexao conect = new Conexao();
		conect.conectar();
			if(conect.estaConectado()) {
				conect.listarA();
				conect.listarB();
				conect.listarC();
			}else {
				System.out.println("Banco não encontrado");
			}
	}

}
