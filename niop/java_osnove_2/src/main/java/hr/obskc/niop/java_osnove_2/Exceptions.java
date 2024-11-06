package hr.obskc.niop.java_osnove_2;

public class Exceptions {

    public static void main(String[] args) {
        Exceptions.jednostavnoHvatanje();
    }
    
    public static void jednostavnoHvatanje() {
        int polje[] = new int[3];
        
        polje[0] = 1;
        polje[1] = 2;
        polje[2] = 3;
        
        try { // blok koji testira kod
            polje[1] = 5;
            int a = 10 / 0;
        } catch(ArrayIndexOutOfBoundsException gepeto) { // blok koji obrađuje iznimku
            System.out.println("Dogodila se greška!");
            System.err.println(gepeto.getMessage());
        } catch(ArithmeticException pinokio) {
            System.out.println("Dogodila se greška prilikom dijeljenja!");
            System.err.println("Detalji o iznimci: " + pinokio.toString());
        } finally {
            System.out.println("Još samo jedno, doviđenja!");
        }
        
    }
    
}
