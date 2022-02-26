
/**
 * Escreva uma descrição da classe Desenhista aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Desenhista
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;

    /**
     * Construtor para objetos da classe Desenhista
     */
    public Desenhista()
    {
       
    }

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public void desenharRosto()
    {
        Circle circle1 = new Circle();
        circle1.makeVisible();
        circle1.changeSize(200);
        
        Circle circle2 = new Circle();
        circle2.makeVisible();
        circle2.changeSize(-50);
        //circle2.diameter = 50;
        circle2.changeColor("green");
        circle2.moveDown();
        circle2.moveRight();
        circle2.moveRight();
        
        Circle circle3 = new Circle();
        circle3.makeVisible();
        circle3.changeSize(50);
        circle3.changeColor("green");
        circle3.moveDown();
        circle3.moveRight();
        circle3.moveRight();
        circle3.moveRight();
        circle3.moveRight();
        circle3.moveRight();
        
        Triangle triangle1 = new Triangle();
        triangle1.makeVisible();
        triangle1.changeColor("black");
        triangle1.moveVertical(125);
        triangle1.moveHorizontal(75);
        
        Square square1 = new Square();
        square1.makeVisible();
        square1.changeColor("red");
        square1.moveVertical(150);
        square1.moveHorizontal(50);
    }
}
