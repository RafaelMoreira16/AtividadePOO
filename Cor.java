import java.awt.Color;

public class Cor {
    private String nome;    
    private Color color;
    
    public Cor(String nome, Color color){
        this.color = color;
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public String toString(){
        return nome;
    }
}
