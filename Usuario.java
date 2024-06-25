import java.util.ArrayList;
import java.util.Collections;

public abstract class Usuario{
  protected String login;
  protected String nome;
  protected String senha;
  protected Local cidade;
  protected ArrayList<Postagem> posts = new ArrayList<Postagem>();
  protected ArrayList<Usuario> seguindo = new ArrayList<Usuario>();
  protected ArrayList<Usuario> seguidores = new ArrayList<Usuario>();
  protected ArrayList<Pessoa> interessados = new ArrayList<Pessoa>();

  public Usuario(String l,String n,String s){
    //System.out.println("novo usuario criado");
    this.login=l;
    this.nome=n;
    this.senha=s;
    
  }

  public boolean validarAcesso(String pwd){
    if(this.senha.equals(pwd)){
      return true;
    }
    else{
      return false;
    }
  }

  public String toString(){
    return this.nome+" - "+this.login;
  }

  public void postar(String foto, String legenda,Data hoje,String senha){
    if(this.validarAcesso(senha)){
      Postagem novo_post=new Postagem(foto,legenda,hoje,this);
      posts.add(novo_post);
    }
    else{
      System.out.println("Senha incorreta!");
    }
  }

  public void seguir(Usuario u){
    this.seguindo.add(u);
    u.seguidores.add(this);
  }

  public void mostrarPosts(){
    for(Postagem p : this.posts){
      System.out.println(this.toString());
      p.mostrarDados();
      System.out.println("*");
    }
  }

  public ArrayList<Postagem> posts(){
    return this.posts;
  }

  public int numSeg(){
    return this.seguidores.size();
  }

  public void feed(){
    ArrayList<Postagem> feed=new ArrayList<Postagem>();

    System.out.println("Feed de "+this.login);
    for(Usuario u : seguindo){
      ArrayList<Postagem> post_user=u.posts();
      for(Postagem p : post_user){
        feed.add(p);
      }
    }
    Collections.sort(feed);
    for(Postagem f: feed){
      f.mostrarDados();
    }
  }

  public ArrayList<Usuario> seguindo(){
    return this.seguindo;
  }

  public int compareTo(Usuario u){
    if(this.seguidores.size()<u.seguidores.size()) return -1;
    if(this.seguidores.size()>u.seguidores.size()) return 1;

    int valor=this.login.compareTo(u.login);
    return valor;

  }
}