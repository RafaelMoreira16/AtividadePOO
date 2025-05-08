import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tela extends JFrame{

    private JPanel painel;
    private JLabel jlFonte, jlTamanho, jlCor;
    private JComboBox jcbFonte, jcbTamanho, jcbCor;
    private JButton jbAlterarF, jbLimparF, jbApagarTexto;
    private JRadioButton jrbNegrito, jrbNormal, jrbItalico, jrbNegritoItalico;
    private ButtonGroup grupoEstilo;
    private JTextArea jtxaTexto;
    private JScrollPane jspTexto;

    List<Cor> cores;


    public Tela(){
        inicializaCores();
        painel = new JPanel();
        jlFonte = new JLabel("Fonte:");
        jlTamanho = new JLabel("Tamanho:");
        jlCor = new JLabel("Cor:");
        jbAlterarF = new JButton("Alterar Formatação");
        jbApagarTexto = new JButton("Apagar Texto");
        jbLimparF = new JButton("Limpar Formatação");
        jcbFonte = new JComboBox<String>(new String[]{
            "Arial", "Abadi", "Calibre", "Comic Sans", "Cambria", "DaunPenh", "Ebrima", "Fairwater Script", "Gabriola", "Hadassah Friedlaender"
        });
        jcbTamanho = new JComboBox<String>(new String[]{
            "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"
        });

        jcbCor = new JComboBox<>(cores.toArray());
        jrbItalico = new JRadioButton("Itálico");
        jrbNegrito = new JRadioButton("Negrito");
        jrbNegritoItalico = new JRadioButton("Negrito-Itálico");
        jrbNormal = new JRadioButton("Normal");
        grupoEstilo = new ButtonGroup();
        jtxaTexto = new JTextArea();
        jspTexto = new JScrollPane(jtxaTexto);
    }

    public void inicializaCores(){     
        // Inicializa a lista de cores
        cores = new ArrayList<>();   
        cores.add(new Cor("Preto", Color.BLACK));
        cores.add(new Cor("Azul", Color.BLUE));
        cores.add(new Cor("Amarelo", Color.YELLOW));
        cores.add(new Cor("Verde", Color.GREEN));
        cores.add(new Cor("Ciano", Color.CYAN));
        cores.add(new Cor("Cinza", Color.GRAY));
        cores.add(new Cor("Majenta", Color.MAGENTA));
        cores.add(new Cor("Vermelho", Color.RED));
        cores.add(new Cor("Rosa", Color.PINK));
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Exercício 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,700);
        setResizable(true);
        setLocation(600,100); 
        add(painel);
        configurarPainel();
    }
    public void configurarPainel(){
        painel.setLayout(null);

        jlFonte.setBounds(10, 10, 50, 30);
        painel.add(jlFonte);

        jcbFonte.setBounds(70, 10, 150, 30);
        painel.add(jcbFonte);

        jlTamanho.setBounds(300, 10, 70, 30);
        painel.add(jlTamanho);

        jcbTamanho.setBounds(380, 10, 130, 30);
        painel.add(jcbTamanho);

        jlCor.setBounds(10,50,50,30);
        painel.add(jlCor);

        jcbCor.setBounds(70,50,150,30);
        painel.add(jcbCor);

        jbAlterarF.setBounds(240,50,150,30);
        jbAlterarF.addActionListener(event -> {
            String fonte = jcbFonte.getSelectedItem().toString();
            Integer tamanho = Integer.parseInt(jcbTamanho.getSelectedItem().toString());
            if (jrbItalico.isSelected()) {
                jtxaTexto.setFont(new Font(fonte, Font.ITALIC, tamanho));
            }
            else if (jrbNegrito.isSelected()) {
                jtxaTexto.setFont(new Font(fonte, Font.BOLD, tamanho));
            }
            else if (jrbNegritoItalico.isSelected()) {
                jtxaTexto.setFont(new Font(fonte, Font.BOLD | Font.ITALIC, tamanho));
            }
            else if (jrbNormal.isSelected()) {
                jtxaTexto.setFont(new Font(fonte, Font.PLAIN, tamanho));
            }
            else {
                jtxaTexto.setFont(new Font(fonte, Font.PLAIN, tamanho));
            }
            Cor corSelecionada = (Cor) jcbCor.getSelectedItem(); 
            jtxaTexto.setForeground(corSelecionada.getColor()); 

        });
        painel.add(jbAlterarF);

        jbLimparF.setBounds(400, 50, 150, 30);
        jbLimparF.addActionListener(event -> {
            jtxaTexto.setFont(new Font("Dialog", Font.PLAIN, 12));
            jtxaTexto.setForeground(Color.BLACK);
        });
        painel.add(jbLimparF);

        grupoEstilo.add(jrbItalico);
        grupoEstilo.add(jrbNegrito);
        grupoEstilo.add(jrbNegritoItalico);
        grupoEstilo.add(jrbNormal);

        jrbItalico.setBounds(10, 90, 80, 30);
        painel.add(jrbItalico);

        jrbNegrito.setBounds(100, 90, 80, 30);
        painel.add(jrbNegrito);

        jrbNegritoItalico.setBounds(190, 90, 120, 30);
        painel.add(jrbNegritoItalico);

        jrbNormal.setBounds(320, 90, 70, 30);
        painel.add(jrbNormal);

        jbApagarTexto.setBounds(400, 90, 150, 30);
        jbApagarTexto.addActionListener(event -> {
            jtxaTexto.setText("");
        });
        painel.add(jbApagarTexto);

        jspTexto.setBounds(10, 130, 570, 520);
        jspTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jspTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jtxaTexto.setLineWrap(true);
        painel.add(jspTexto);
    }
}
