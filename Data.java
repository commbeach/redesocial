public class Data implements Comparable<Data>{
  private int dia;
  private int mes;
  private int ano;

  public Data(int d, int m, int a){
    this.dia=d;
    this.mes=m;
    this.ano=a;
  }

  public int getAno(){
    return this.ano;
  }

  public int getMes(){
    return this.mes;
  }

  public int getDia(){
    return this.dia;
  }

  public String toString(){
    String dia=this.dia+"";
    String mes=this.mes+"";
    if(this.dia<10){
      dia="0"+dia;
    }
    if(this.mes<10){
      mes="0"+mes;
    }
    return dia+"/"+mes+"/"+this.ano;
  }

  //compara duas datas - retorna 1 se this for mais antigo, -1 se d for mais antigo e 0 se for igual
 public int compareTo(Data d){
  if(this.ano<d.getAno())return -1;
  if(this.ano>d.getAno())return 1;

  if(this.mes<d.getMes())return -1;
  if(this.mes>d.getMes())return 1;

  if(this.dia<d.getDia())return -1;
  if(this.dia>d.getDia())return 1;

  return 0;
 }
}