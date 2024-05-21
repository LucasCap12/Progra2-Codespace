package impl;

import api.ABBTDA;

/*La definici´on es que un ´arbol es un conjunto vac´ıo de nodos
o un nodo ra´ız y sus dos sub´arboles. Es decir, que para nosotros
un ´arbol con un solo nodo, ser´a un nodo y dos sub´arboles
vac´ıos. Con esta definici´on, vamos a implementar el ABBTDA: */
public class ABB implements ABBTDA{
    NodoABB raiz;

    public int Raiz(){
        return raiz.info;
    }

    public boolean ArbolVacio(){
        return (raiz == null);
    }

    public void InicializarArbol(){
        raiz = null;
    }

    public ABBTDA HijoDer(){
        return raiz.hijoDer;
    }
    
    public ABBTDA HijoIzq(){
        return raiz.hijoIzq;
    }

    public void AgregarElem(int x){
        if (raiz == null){
            raiz = new NodoABB();
            raiz.info = x;
            raiz.hijoIzq= new ABB();
            raiz.hijoIzq.InicializarArbol();
            raiz.hijoDer = new ABB();
            raiz.hijoDer.InicializarArbol();
        }
        else if (raiz.info > x )
            raiz.hijoIzq.AgregarElem(x);
        else if (raiz.info < x)
            raiz.hijoDer.AgregarElem(x);
    }

    public void EliminarElem(int x){
        if (raiz != null){
            if (raiz.info == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()){
                raiz = null;
            }
            else if (raiz.info == x && !raiz.hijoIzq.ArbolVacio()){
                raiz.info = this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.EliminarElem(raiz.info);
            }
            else if (raiz.info == x && raiz.hijoIzq.ArbolVacio()){
                raiz.info = this.menor(raiz.hijoDer);
                raiz.hijoDer.EliminarElem(raiz.info);
            }
            else if (raiz.info < x){
                raiz.hijoDer.EliminarElem(x);
            }
            else{
                raiz.hijoIzq.EliminarElem(x);
            }

        }
    }

    private int mayor(ABBTDA a){
        if (a.HijoDer().ArbolVacio())
            return a.Raiz();
        else
            return mayor(a.HijoDer());
    }

    private int menor(ABBTDA a){
        if (a.HijoIzq().ArbolVacio())
            return a.Raiz();
        else
            return menor(a.HijoIzq());
    }

}
