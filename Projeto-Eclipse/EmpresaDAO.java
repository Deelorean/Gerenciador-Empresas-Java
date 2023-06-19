package PROJETOA3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
    private static final String URL = "jdbc:mysql://aws.connect.psdb.cloud/projetoa3?sslMode=VERIFY_IDENTITY";
    private static final String USUARIO = "peoo2x055txo9snfvgnw";
    private static final String SENHA = "pscale_pw_DRHuRfaNkd8n3XAXfUc3MYFX7PJdSMjFvt0IMW2p37X";

    // Método para adicionar uma empresa ao banco de dados
    public void adicionarEmpresa(Empresa empresa) {
        try {
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO empresa (nome, cnpj, quantidade_funcionarios, nome_gerente, area_atuacao) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCnpj());
            stmt.setInt(3, empresa.getQuantidadeFuncionarios());
            stmt.setString(4, empresa.getNomeGerente());
            stmt.setString(5, empresa.getAreaAtuacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para remover uma empresa do banco de dados com base no ID
    public void removerEmpresa(int id) {
        String sql = "DELETE FROM empresa WHERE id = ?";

        try (Connection conexao = obterConexao();
                PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todas as empresas do banco de dados
    public List<Empresa> listarEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM empresa";

        try (Connection conexao = obterConexao();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                int quantidadeFuncionarios = resultSet.getInt("quantidade_funcionarios");
                String nomeGerente = resultSet.getString("nome_gerente");
                String areaAtuacao = resultSet.getString("area_atuacao");

                Empresa empresa = new Empresa(nome, cnpj, quantidadeFuncionarios, nomeGerente, areaAtuacao);
                empresa.setId(id);

                empresas.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empresas;
    }

    // Método para buscar uma empresa no banco de dados com base no ID
    public Empresa buscarEmpresa(int id) {
        Empresa empresa = null;
        try {
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM empresa WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                empresa = new Empresa(null, null, id, null, null);
                empresa.setId(rs.getInt("id"));
                empresa.setNome(rs.getString("nome"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setQuantidadeFuncionarios(rs.getInt("quantidade_funcionarios"));
                empresa.setNomeGerente(rs.getString("nome_gerente"));
                empresa.setAreaAtuacao(rs.getString("area_atuacao"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresa;
    }

    // Método para atualizar uma empresa no banco de dados
    public void atualizarEmpresa(Empresa empresa) {
        try {
            Connection conn = obterConexao();
            PreparedStatement stmt = conn.prepareStatement("UPDATE empresa SET nome = ?, cnpj = ?, quantidade_funcionarios = ?, nome_gerente = ?, area_atuacao = ? WHERE id = ?");
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCnpj());
            stmt.setInt(3, empresa.getQuantidadeFuncionarios());
            stmt.setString(4, empresa.getNomeGerente());
            stmt.setString(5, empresa.getAreaAtuacao());
            stmt.setInt(6, empresa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para obter uma conexão com o banco de dados
    private Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
