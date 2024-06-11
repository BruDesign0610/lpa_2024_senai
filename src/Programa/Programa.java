package Programa;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Programa implements ActionListener {
	
	private JTextField campoPeso;
	private JTextField campoAltura;
	private JLabel labelResultado;
	//exibir descricao
	private JLabel labelDescricao;
	
	public static void main(String[] args) {
		new Programa();
	}
	
	public Programa() {
		//1- Cria o frame e atribui título
		JFrame frame = new JFrame("Calculadora IMC");
		// Adiciona operação de fechamento
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//2- Atribui tamanho
		frame.setSize(300, 200);
		
		//3- Cria painel e formato de exibição, no caso grid 4 Linhas e 2 Colunas
		JPanel panel = new JPanel();
		
		//modificou o painel
		panel.setLayout(new GridLayout(5, 2, 10, 10));
		
		//4- Importa label
		JLabel labelPeso = new JLabel("Peso em KG");
		campoPeso = new JTextField();
		
		JLabel labelAltura = new JLabel("Altura em M");
		campoAltura = new JTextField();
		
		//5- Importa botão
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(this);
		
		labelResultado = new JLabel("IMC");
		labelDescricao = new JLabel("Resultado");
		
		// adicionar os componentes no painel
		panel.add(labelPeso);
		panel.add(campoPeso);
		panel.add(labelAltura);
		panel.add(campoAltura);
		panel.add(new JLabel(""));
		panel.add(calcular);
		panel.add(new JLabel(""));
		panel.add(labelResultado);
		panel.add(labelDescricao);
		
		// Add painel ao frame
		frame.add(panel);
		// habilitando a visibilidade ao frame
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    // Transformar string para double
	    double peso = Double.parseDouble(campoPeso.getText());
	    double altura = Double.parseDouble(campoAltura.getText());
	    
	    // calcular IMC
	    double imc = peso / (altura * altura);
	    
	    // Classificar IMC
	    String classificacao;
	    if (imc < 18.5) {
	        classificacao = "Abaixo do peso";
	    } else if (imc >= 18.5 && imc < 25) {
	        classificacao = "Peso normal";
	    } else if (imc >= 25 && imc < 30) {
	        classificacao = "Sobrepeso";
	    } else if (imc >= 30 && imc < 35) {
	        classificacao = "Obesidade Grau I (moderada)";
	    } else if (imc >= 35 && imc < 40) {
	        classificacao = "Obesidade Grau II (severa)";
	    } else {
	        classificacao = "Obesidade Grau III (mórbida)";
	    }
		
		
		
	    // exibindo o resultado final + variável que descreve o imc
	    labelResultado.setText(String.format("IMC: %.2f", imc));
	    labelDescricao.setText("Classificação: " + classificacao);
	}
}
