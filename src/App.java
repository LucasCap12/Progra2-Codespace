import api.PilaTDA;
import impl.PilaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        PilaTDA p1 = new PilaEstatica();

        p1.InicializarPila();

        for(int i = 0; i <= 50; i++){
            p1.Apilar(i);
        }

        while (!p1.PilaVacia()) {
            System.out.print(p1.Tope()+ " ");
            p1.Desapilar();
        }


    }
}
