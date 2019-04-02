class Main {
  public static void main(String[] args) {
    ArvoreAVL arvore = new ArvoreAVL();
    /*for(int i = 10; i <= 80; i+=10){
      arvore.insert("andre", i);
      arvore.display();
    }*/

    arvore.insert("andre", 50);
    arvore.display();
    arvore.insert("andre", 20);
    arvore.display();
    arvore.insert("andre", 80);
    arvore.display();
    arvore.insert("andre", 70);
    arvore.display();
    arvore.insert("andre2", 90);
    arvore.display();
    arvore.insert("andre", 60);
    arvore.display();

    arvore.remove(50);
    arvore.display();
    arvore.remove(80);
    arvore.display();
    arvore.remove(70);
    arvore.display();
    arvore.remove(60);
    arvore.display();

    //System.out.println(arvore.searchByKey(90).getObjeto());


    /*arvore.insert("andre", 10);
    arvore.display();
    arvore.insert("andre", 8);
    arvore.display();
    arvore.insert("andre", 12);
    arvore.display();
    arvore.insert("andre", 3);
    arvore.display();
    arvore.insert("andre", 30);
    arvore.display();
    arvore.insert("andre", 20);
    arvore.display();*/

   /* arvore.insert("andre", 10);
    arvore.display();
    arvore.insert("lucas", 8);
    arvore.display();
    arvore.insert("lucas 2", 6);
    arvore.display();
    arvore.insert("lucas 2", 3);
    arvore.display();
    arvore.insert("lucas 2", 2);
    arvore.display();
    arvore.insert("lucas 2", 1);
    */
    //arvore.insert("marília", 8);
    //arvore.insert("test", 16);
    //arvore.insert("test 2", 14);
    /*System.out.println(arvore.isEmpty()? "arvore vazia":"arovre não vazia");
    System.out.println(arvore.root().getEsquerdo().getObjeto());*/
    //System.out.println((arvore.searchByKey(8).getObjeto()));
    //arvore.display();
    //arvore.remove(15);
    //arvore.display();
    //System.out.println((arvore.searchByKey(15).getObjeto()));
    //System.out.println((arvore.searchByKey(8).getObjeto()));
    //System.out.println(arvore.altura());

  }
}