package PROJETOA3;

import javax.swing.*;
import java.util.List;

public class MenuPrincipal {
    private static final EmpresaDAO empresaDAO = new EmpresaDAO();

    public static void main(String[] args) {
        int opcao;

        // Loop principal do menu
        do {
            opcao = exibirMenu();

            switch (opcao) {
                case 1:
                    adicionarEmpresa();
                    break;
                case 2:
                    removerEmpresa();
                    break;
                case 3:
                    listarEmpresas();
                    break;
                case 4:
                    atualizarEmpresa();
                    break;
                case -1:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Digite novamente.");
            }
        } while (opcao != -1);
    }

    // Exibe o menu e retorna a opção selecionada
    private static int exibirMenu() {
        String[] opcoes = {"Adicionar Empresa", "Remover Empresa", "Listar Empresas", "Atualizar Empresa"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Gerenciador de Empresas Clientes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (opcaoSelecionada == JOptionPane.CLOSED_OPTION) {
            return -1; // Retorna -1 quando a janela é fechada
        } else {
            return opcaoSelecionada + 1;
        }
    }

    // Método para adicionar uma nova empresa
    private static void adicionarEmpresa() {
        // Criação dos campos de texto para receber os dados da empresa
        JTextField nomeField = new JTextField();
        JTextField cnpjField = new JTextField();
        JTextField funcionariosField = new JTextField();
        JTextField gerenteField = new JTextField();
        JTextField areaField = new JTextField();

        Object[] message = {
                "Nome da empresa:", nomeField,
                "CNPJ da empresa:", cnpjField,
                "Quantidade de funcionários:", funcionariosField,
                "Nome do gerente responsável:", gerenteField,
                "Área de atuação:", areaField
        };

        // Exibe o diálogo de entrada de dados para adicionar uma empresa
        int option = JOptionPane.showConfirmDialog(null, message, "Adicionar Empresa", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String cnpj = cnpjField.getText();
            int quantidadeFuncionarios = Integer.parseInt(funcionariosField.getText());
            String nomeGerente = gerenteField.getText();
            String areaAtuacao = areaField.getText();

            Empresa empresa = new Empresa(nome, cnpj, quantidadeFuncionarios, nomeGerente, areaAtuacao);

            empresaDAO.adicionarEmpresa(empresa);
            JOptionPane.showMessageDialog(null, "Empresa adicionada com sucesso!");
        }
    }

    // Método para remover uma empresa
    private static void removerEmpresa() {
        String idString = JOptionPane.showInputDialog("ID da empresa:");
        if (idString != null) {
            int id = Integer.parseInt(idString);
            empresaDAO.removerEmpresa(id);
            JOptionPane.showMessageDialog(null, "Empresa removida com sucesso!");
        }
    }

    // Método para listar todas as empresas
    private static void listarEmpresas() {
        List<Empresa> empresas = empresaDAO.listarEmpresas();

        if (empresas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há empresas cadastradas.");
        } else {
            StringBuilder mensagem = new StringBuilder("Empresas clientes cadastradas:\n\n");
            for (Empresa empresa : empresas) {
                mensagem.append(empresa).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensagem.toString());
        }
    }

    // Método para atualizar os dados de uma empresa
    private static void atualizarEmpresa() {
        String idString = JOptionPane.showInputDialog("ID da empresa:");
        if (idString != null) {
            int id = Integer.parseInt(idString);
            Empresa empresa = empresaDAO.buscarEmpresa(id);

            if (empresa != null) {
                StringBuilder mensagem = new StringBuilder("== Atualizar Empresa ==\n\n");
                mensagem.append("Dados atuais da empresa:\n\n").append(empresa).append("\n\n");

                // Solicita ao usuário os novos dados da empresa
                String novoNome = JOptionPane.showInputDialog("Novo nome da empresa (ou deixe em branco para não alterar):");
                if (novoNome != null && !novoNome.isEmpty()) {
                    empresa.setNome(novoNome);
                }

                String novoCnpj = JOptionPane.showInputDialog("Novo CNPJ da empresa (ou deixe em branco para não alterar):");
                if (novoCnpj != null && !novoCnpj.isEmpty()) {
                    empresa.setCnpj(novoCnpj);
                }

                String novaQuantidadeFuncionariosStr = JOptionPane.showInputDialog("Nova quantidade de funcionários (ou deixe em branco para não alterar):");
                if (novaQuantidadeFuncionariosStr != null && !novaQuantidadeFuncionariosStr.isEmpty()) {
                    int novaQuantidadeFuncionarios = Integer.parseInt(novaQuantidadeFuncionariosStr);
                    empresa.setQuantidadeFuncionarios(novaQuantidadeFuncionarios);
                }

                String novoNomeGerente = JOptionPane.showInputDialog("Novo Nome do gerente responsável (ou deixe em branco para não alterar):");
                if (novoNomeGerente != null && !novoNomeGerente.isEmpty()) {
                    empresa.setNomeGerente(novoNomeGerente);
                }

                String novaAreaAtuacao = JOptionPane.showInputDialog("Nova Área de atuação (ou deixe em branco para não alterar):");
                if (novaAreaAtuacao != null && !novaAreaAtuacao.isEmpty()) {
                    empresa.setAreaAtuacao(novaAreaAtuacao);
                }

                empresaDAO.atualizarEmpresa(empresa);
                JOptionPane.showMessageDialog(null, "Empresa atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Empresa não encontrada com o ID informado.");
            }
        }
    }
}
