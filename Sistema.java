import java.util.ArrayList;

public class Sistema{
  private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
  private ArrayList<Empresa> empresas = new ArrayList<Empresa>();

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
      System.out.println(p.toString());
    }

    for(Empresa e : empresas){
      System.out.println(e.toString());
    }
  }

  public ArrayList<Usuario> todes(){
    ArrayList<Usuario> todes=new ArrayList<Usuario>();
    for(Pessoa p: pessoas){
      todes.add(p);
    }
    for(Empresa e:empresas){
      todes.add(e);
    }
    return todes;
  }

  public void listar_nao_seguidos(Usuario u){
    ArrayList<Usuario> todes=this.todes();
    ArrayList<Usuario> seg=u.seguindo();
    for(Usuario t: todes){
      boolean nsegue=true;
      for(Usuario s: seg){
        if(t.equals(s)||t.equals(u)){
          nsegue=false;
          break;
        }
      }
      if(nsegue)System.out.println(t.toString());
    }
  }
  
}