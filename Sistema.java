import java.util.ArrayList;

public class Sistema{
  ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
  ArrayList<Empresa> empresas = new ArrayList<Empresa>();

  public Usuario buscarUsuario(String login){
    for(Pessoa p : pessoas){
      if(p.login.equals(login)){
        return p;
      }
    }
    for(Empresa e : empresas){
      if(e.login.equals(login)){
        return e;
      }
    }
    return null;
  }

  public void novaPessoa(Pessoa p){
    pessoas.add(p);
  }

  public void novaEmpresa(Empresa e){
    empresas.add(e);
  }

  public void listarUsuarios(){
    for(Pessoa p : pessoas){
      System.out.println("*************");
      System.out.println(p.login);
      System.out.println(p.nome);
      System.out.println(p.bio);
    }

    for(Empresa e : empresas){
      System.out.println("*************");
      System.out.println(e.login);
      System.out.println(e.nome);
      System.out.println(e.area);
    }
  }
  
}