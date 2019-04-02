import java.util.Vector;
import java.util.Iterator;

class No {
  private No pai;
  private int key;
  private Object objeto;
  private No esquerdo;
  private No direito;
  private int fb;


  public No (No pai, Object objeto, int key) {
    this.pai = pai;
    this.key = key;
    this.objeto = objeto;
    this.esquerdo = null;
    this.direito = null;
    this.fb = 0;
  }




  public void setFB(int fb){
    this.fb = fb;
  }
  public int getFB(){
    return this.fb;
  }

  public void setObjeto(Object objeto){    //metodo de update
    this.objeto = objeto;
  }
  public Object getObjeto(){             //metodo de acesso
    return this.objeto;
  }
  public void setKey(int key){
    this.key = key;
  }
  public int getKey(){
    return this.key;
  }
  public void setPai(No pai){
    this.pai = pai;
  }
  public No getPai(){
    return this.pai;
  }
  public void setEsquerdo(No esquerdo){      //metodo de update
    this.esquerdo = esquerdo;
  }
  public No getEsquerdo(){               //metodo de acesso
    return esquerdo;
  }
  public void setDireito(No direito){      //metodo de update
    this.direito = direito;
  }
  public No getDireito(){               //metodo de acesso
    return direito;
  }

  public Iterator children(){
    Vector<No> c = new Vector<No>();
    if(esquerdo != null) c.addElement(esquerdo);
    if(direito != null) c.addElement(direito);
    return c.iterator();
  }

}