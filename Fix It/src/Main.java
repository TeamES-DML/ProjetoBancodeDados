/*

import negocio.entidade.*;
import negocio.excecao.*;
import negocio.fachada.*;
import negocio.*;
public class Main {
    public static void main(String[] args) throws VeiculoRepetidoException, ProdutoRepetidoException {
        Fachada x = new Fachada();
        Funcionario f = new Funcionario("Daniel", "10579130495","123", "Gerente");
        Produto p = new Produto("Oleo", 120, 200);
        Produto m = new Peca("Motor", "Uno", 100, 150, 50);
        DataSimples d = new DataSimples(25, 01, 2018);
        Servico s = new Servico("Venda", p, "Fudeu", d);
        Veiculo v = new Veiculo("Luis", "ABC-1234", "Uno");
        try {
            x.adicionarFuncionario(f);
            x.adicionarProduto(p);
            x.adicionarProduto(m);
            x.adicionarVeiculo(v);
            x.adicionarServico(v, s);
            System.out.println(x.logar(f,"123"));
            x.desproverFuncionario(f);
            System.out.println(x.logar(f,"123"));
        } catch (VeiculoRepetidoException e) {
            e.printStackTrace();
        } catch (FuncionarioRepetidoException e) {
            e.printStackTrace();
        }catch(ProdutoRepetidoException e) {
            e.printStackTrace();
        } catch (ServicoRepetidoException e) {
            e.printStackTrace();
        } catch (FuncionarioNaoEncontradoException e) {
            e.printStackTrace();
        } catch (SenhaIncorretaException e) {
            e.printStackTrace();
        } catch (FuncionarioJaEPadraoException e) {
            e.printStackTrace();
        }
    }
}
 */
