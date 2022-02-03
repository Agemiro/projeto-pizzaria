package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControlContabilidade;

public class TelaContabilidade extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo;
	private JTable tabela;
	
	public TelaContabilidade() {
		
		setTitle("Contabilidade");
		setSize(750,541);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

        tabela();
        
        this.setVisible(true);
		
	}
	
	public void tabela() {		

		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		
		modelo.addColumn("Quantidade vendida");
		modelo.addColumn("Lucro");
		modelo.addColumn("Sabor mais vendido");
		
        ControlContabilidade control = new ControlContabilidade();
								
		Object[] linha = new Object[modelo.getColumnCount()];
			
		linha[0] = control.acessarContabilidade().getQuantidadeVendidaNoMes();
		linha[1] = control.acessarContabilidade().getLucroMes();
		linha[2] = control.acessarContabilidade().getSaboresMaisVendidosNoMes();
			
		modelo.addRow(linha);

		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(0, 30, 750,541);
		
		add(painel);
		
	}
	
}
