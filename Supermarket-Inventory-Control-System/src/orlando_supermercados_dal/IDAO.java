package orlando_supermercados_dal;

import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author ZENETO
 * @param<T>
 */
public interface IDAO<T> {

    /* Método que verifica se o usuário logado é do tipo Administrador. */
    public boolean verificaAdm(T o) throws SQLException;

    /* Método que verifica se o usuário logado é do tipo Funcionário. */
    public boolean verificaFunc(T o) throws SQLException;

    /* Método que lista seleciona os dados em uma table usando ArrayList. */
    public ArrayList<T> consulta() throws SQLException;

    /* Método usado para preencher o preview de fornecedores (aba alterar e excluir) */   
    public T consulta(int id) throws SQLException;

    /* Método que insere no banco de dados. */
    public boolean insere(T o) throws SQLException;

    /* Método que atualiza no banco de dados. */
    public boolean atualiza(T o) throws SQLException;

    /* Método que reativa um usuario sem removê-lo do banco de dados. */
    public boolean reativar(T o) throws SQLException;

    /* Método que desativa um usuario sem removê-lo do banco de dados. */
    public boolean desativar(T o) throws SQLException;

    /* Método que remove do banco de dados. */
    public boolean apaga(T o) throws SQLException;

    /* Método consultar estoque sem data digitada. */
    public ArrayList<T> consultaSemData(T o) throws SQLException;

    /* Método consultar estoque com data digitada.*/
    public ArrayList<T> consultaComData(T o) throws SQLException;

}
