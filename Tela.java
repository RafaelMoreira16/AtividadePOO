import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
// cria classe responsável por criar e configurar a interface gráfica da aplicação
public class Tela extends JFrame {
// Painel principal onde todos os componentes serão adicionados
    private JPanel painel;
    private JLabel jlFonte, jlTamanho, jlCor;
    private JComboBox<String> jcbFonte, jcbTamanho, jcbCor;
    private JButton jbAlterarF, jbLimparF, jbApagarTexto;
    private JRadioButton jrbNegrito, jrbNormal, jrbItalico, jrbNegritoItalico;
    private ButtonGroup grupoEstilo;
    private JTextArea jtxaTexto;
    private JScrollPane jspTexto;

    private List<Cor> cores;
// Construtor que inicializa as cores, os componentes e configura a janela principal
    public Tela() {
        inicializaCores();
        inicializarComponentes();
        configurarJanela();
    }
// Método que inicializa a lista de cores com objetos da classe "Cor"
    private void inicializaCores() {
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
// Método que instancia e configura os componentes que compõem a interface
    private void inicializarComponentes() {
        painel = new JPanel();
        jlFonte = new JLabel("Fonte:");
        jlTamanho = new JLabel("Tamanho:");
        jlCor = new JLabel("Cor:");
        jbAlterarF = new JButton("Alterar Formatação");
        jbApagarTexto = new JButton("Apagar Texto");
        jbLimparF = new JButton("Limpar Formatação");
        jcbFonte = new JComboBox<>(new String[]{
            "Arial", "Abadi", "Calibre", "Comic Sans", "Cambria", "DaunPenh", "Ebrima", "Fairwater Script", "Gabriola", "Hadassah Friedlaender"
        });
        jcbTamanho = new JComboBox<>(new String[]{"10", "15", "20", "25", "30", "35", "40", "45", "50", "55"});
        jcbCor = new JComboBox<>(cores.toArray(new Cor[0]));
        
        jrbItalico = new JRadioButton("Itálico");
        jrbNegrito = new JRadioButton("Negrito");
        jrbNegritoItalico = new JRadioButton("Negrito-Itálico");
        jrbNormal = new JRadioButton("Normal");
        grupoEstilo = new ButtonGroup();
        
        jtxaTexto = new JTextArea();
        jspTexto = new JScrollPane(jtxaTexto);

        configurarAcoes();
    }

    private void configurarAcoes() {
        jbAlterarF.addActionListener(event -> alterarFormatoTexto());
        jbLimparF.addActionListener(event -> limparFormatoTexto());
        jbApagarTexto.addActionListener(event -> jtxaTexto.setText(""));

        grupoEstilo.add(jrbItalico);
        grupoEstilo.add(jrbNegrito);
        grupoEstilo.add(jrbNegritoItalico);
        grupoEstilo.add(jrbNormal);
    }

    private void alterarFormatoTexto() {
        String fonte = jcbFonte.getSelectedItem().toString();
        int tamanho = Integer.parseInt(jcbTamanho.getSelectedItem().toString());
        int estilo = Font.PLAIN;

        if (jrbNegrito.isSelected()) estilo = Font.BOLD;
        if (jrbItalico.isSelected()) estilo |= Font.ITALIC;
        if (jrbNegritoItalico.isSelected()) estilo = Font.BOLD | Font.ITALIC;

        jtxaTexto.setFont(new Font(fonte, estilo, tamanho));
        Cor corSelecionada = (Cor) jcbCor.getSelectedItem();
        jtxaTexto.setForeground(corSelecionada.getColor());
    }

    private void limparFormatoTexto() {
        jtxaTexto.setFont(new Font("Dialog", Font.PLAIN, 12));
        jtxaTexto.setForeground(Color.BLACK);
    }

    private void configurarJanela() {
        setTitle("Exercício 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setResizable(true);
        setLocation(600, 100);
        setVisible(true);
        add(painel);
        configurarPainel();
    }

    private void configurarPainel() {
        painel.setLayout(null);

        // Adicionando e configurando os componentes
        jlFonte.setBounds(10, 10, 50, 30);
        painel.add(jlFonte);
        jcbFonte.setBounds(70, 10, 150, 30);
        painel.add(jcbFonte);

        jlTamanho.setBounds(300, 10, 70, 30);
        painel.add(jlTamanho);
        jcbTamanho.setBounds(380, 10, 130, 30);
        painel.add(jcbTamanho);

        jlCor.setBounds(10, 50, 50, 30);
        painel.add(jlCor);
        jcbCor.setBounds(70, 50, 150, 30);
        painel.add(jcbCor);

        jbAlterarF.setBounds(240, 50, 150, 30);
        painel.add(jbAlterarF);

        jbLimparF.setBounds(400, 50, 150, 30);
        painel.add(jbLimparF);

        jrbItalico.setBounds(10, 90, 80, 30);
        painel.add(jrbItalico);
        jrbNegrito.setBounds(100, 90, 80, 30);
        painel.add(jrbNegrito);
        jrbNegritoItalico.setBounds(190, 90, 120, 30);
        painel.add(jrbNegritoItalico);
        jrbNormal.setBounds(320, 90, 70, 30);
        painel.add(jrbNormal);

        jbApagarTexto.setBounds(400, 90, 150, 30);
        painel.add(jbApagarTexto);

        jspTexto.setBounds(10, 130, 570, 520);
        jspTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jspTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jtxaTexto.setLineWrap(true);
        painel.add(jspTexto);
    }

    public static void main(String[] args) {
        new Tela();
    }
}
