//package Fotos;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Entrada {
    /**
     * Classe com as rotinas de entrada e saída do projeto
     * @author Hilario Seibel Junior e <seu nome aqui>
     */

    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        //try {
            // Se houver um arquivo input.txt na pasta corrente, o Scanner vai ler dele.
            //this.input = new Scanner(new FileInputStream("input.txt"));
            // NAO ALTERE A LOCALICAÇÃO DO ARQUIVO!!
        //} catch (IOException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        //}
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    public void CadastrarSistema(Sistema s){
        try{  
        FileReader f = new FileReader("dados.txt");
        BufferedReader buff = new BufferedReader(f);
        String linha = buff.readLine();
        while(!linha.equals("F")){
            //se for pessoa:
            if(linha.equals("P")){
                String login=buff.readLine();
                String nome=buff.readLine();
                String senha=buff.readLine();
                String cpf=buff.readLine();
                int dia = Integer.parseInt(buff.readLine());
                int mes = Integer.parseInt(buff.readLine());
                int ano = Integer.parseInt(buff.readLine());
                //cadastra no sistema
                Pessoa p=new Pessoa(login,nome,senha,cpf,dia,mes,ano);
                s.novaPessoa(p);
            }
            //se for empresa:
            if(linha.equals("E")){
                String login=buff.readLine();
                String nome=buff.readLine();
                String senha=buff.readLine();
                String cnpj=buff.readLine();
                //cadastra no sistema
                Empresa e=new Empresa(login,nome,senha,cnpj);
                s.novaEmpresa(e);
            }
            //opcoes de seguir
            if(linha.equals("S")){
                String login_seguir=buff.readLine();
                String login_seguidor=buff.readLine();

                Usuario logado=s.buscarUsuario(login_seguir);
                Usuario vai_seguir=s.buscarUsuario(login_seguidor);
                logado.seguir(vai_seguir);
            }
            linha=buff.readLine();
        }
        
        buff.close();

        //jeito que eu encontrei de tirar o F no final: 
        ArrayList<String> dados = new ArrayList<String>();

        FileReader new_f = new FileReader("dados.txt");
        BufferedReader new_buff = new BufferedReader(new_f);
        String new_linha = new_buff.readLine();

        while(!new_linha.equals("F")){
            dados.add(new_linha);
            new_linha=new_buff.readLine();
        }

        new_buff.close();

        FileWriter file = new FileWriter("dados.txt");
        BufferedWriter write = new BufferedWriter(file);
        for(String d : dados){
            write.write(d+"\n");
          }
        write.close();

        }catch(IOException e){
            System.out.println("erro");
        }
    }

  

    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu1() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar pessoa.\n" +
                "2) Cadastrar empresa.\n" +
                "3) Login.\n" +
                "0) Sair.\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        //adiciona F quando fecha
        if(op==0){
            FileWriter file;
            try {
                file = new FileWriter("dados.txt",true);
                BufferedWriter buff = new BufferedWriter(file);
                buff.write("F");
                buff.close();
            }catch (IOException e) {
                System.out.println("erro");
            }
        }
        return op;
    }

    public int menu2(){

        String msg = "*********************\n" +
        "Escolha uma opção:\n" +
        "1) Seguir usuario.\n" +
        "2) Fazer postagem.\n" +
        "3) Exibir feed.\n" +
        "0) Sair.\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;


    }

    /***************************************************/

    /**
     * Lê os dados de uma nova Pessoa e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadPessoa(Sistema s) {
        //cria e salva pessoa em dados.txt

        String login = this.lerLinha("Escolha um login: ");

        while (s.buscarUsuario(login) != null) {
            login = this.lerLinha("Usuário já existente. Escolha outro login: ");
        }

        String nome = this.lerLinha("Digite seu nome: ");
        String senha = this.lerLinha("Digite sua senha: ");
        String cpf = this.lerLinha("Digite seu cpf: ");
        try{
            int dia = this.lerInteiro("Digite seu dia de nascimento: ");
            int mes = this.lerInteiro("Digite seu mes de nascimento: ");
            int ano = this.lerInteiro("Digite seu ano de nascimento: ");
    
            Pessoa p = new Pessoa(login, nome, senha, cpf, dia, mes, ano);
            s.novaPessoa(p);

             //salva pessoa no dados.txt
            try {
                FileWriter file = new FileWriter("dados.txt",true);
                BufferedWriter buff = new BufferedWriter(file);
                buff.write("P\n");
                buff.write(login+"\n");
                buff.write(nome+"\n");
                buff.write(senha+"\n");
                buff.write(cpf+"\n");
                buff.write(dia+"\n");
                buff.write(mes+"\n");
                buff.write(ano+"\n");
                buff.close();
    
                
            } catch (IOException e) {
                System.out.println("erro");
            }

        }catch(NumberFormatException n){
            System.out.println("ERRO! Digite um numero!");
        }
       



    }

    public void cadEmpresa(Sistema s){
        String login = this.lerLinha("Escolha um login: ");

        while (s.buscarUsuario(login) != null) {
            login = this.lerLinha("Usuário já existente. Escolha outro login: ");
        }

        String nome = this.lerLinha("Digite seu nome: ");
        String senha = this.lerLinha("Digite sua senha: ");
        String cnpj = this.lerLinha("Digite seu cnpj: ");

        Empresa e = new Empresa(login,nome,senha,cnpj);
        s.novaEmpresa(e);

        //salva empresa no dados.txt

        try {
            FileWriter file = new FileWriter("dados.txt",true);
            BufferedWriter buff = new BufferedWriter(file);
            buff.write("E\n");
            buff.write(login+"\n");
            buff.write(nome+"\n");
            buff.write(senha+"\n");
            buff.write(cnpj+"\n");
            buff.close();

            
        } catch (IOException f) {
            System.out.println("erro");
        }

    }

    public void cadPostagem(Sistema s,Usuario u){
        String imagem=lerLinha("Digite arquivo da foto: ");
        String legenda=lerLinha("Digite legenda: ");
        try{
            int dia=lerInteiro("Digite dia de hoje: ");
            int mes=lerInteiro("Digite mes de hoje: ");
            int ano=lerInteiro("Digite ano de hoje: ");
            String senha=lerLinha("Digite sua senha: ");

            Data hoje=new Data(dia,mes,ano);
    
            u.postar(imagem,legenda,hoje,senha);

        }catch(NumberFormatException n){
            System.out.println("ERRO! Digite um numero!");
        }
       
    }

    public void login(Sistema s){
        String login = this.lerLinha("Login: ");
        if(s.buscarUsuario(login)!=null){
            String senha = this.lerLinha("Senha: ");
            Usuario logado=s.buscarUsuario(login);
            if(logado.validarAcesso(senha)){
                System.out.println("Bem vindo(a), "+logado.nome+"!");
                int op=this.menu2();
                while(op!=0){
                    //seguir
                    if(op==1){
                        s.listar_nao_seguidos(logado);
                        String string_seguir=this.lerLinha("Digite o user que deseja seguir: ");
                        Usuario seguir_user=s.buscarUsuario(string_seguir);
                        if(seguir_user!=null){
                            logado.seguir(seguir_user);
                            System.out.println(string_seguir+" seguido(a)!");
                            //cadastrar seguimento
                            try {
                                FileWriter file = new FileWriter("dados.txt",true);
                                BufferedWriter buff = new BufferedWriter(file);
                                buff.write("S\n");
                                buff.write(logado.login+"\n");
                                buff.write(string_seguir+"\n");
                                buff.close();
                    
                                
                            } catch (IOException f) {
                                System.out.println("erro");
                            }
                        }
                        else{
                            System.out.println("erro: usuario invalido");
                        }
                        op=this.menu2();

                    }
                    if(op==2){
                        System.out.println("*FAZER POSTAGEM*");
                        cadPostagem(s,logado);
                        op=this.menu2();
                    }
                    if(op==3){
                        System.out.println("*FEED*");
                        logado.feed();
                        op=this.menu2();
                    }
                }
            }
            else{
                System.out.println("SENHA INCORRETA");
            }
        }
        else{
            System.out.println("USUARIO NAO ENCONTRADO");
            this.login(s);
        }
    }

}