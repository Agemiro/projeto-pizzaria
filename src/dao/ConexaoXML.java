package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ConexaoXML{
	
	private XStream xStream = new XStream(new DomDriver("ISO-8859-1"));
	 
    private String nomeArquivo;
 
    private ArrayList<String[]> dados = null;
 
    public ConexaoXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
 
    protected void salvarLista() {
        if (dados != null) {
            try {
                String xml = xStream.toXML(dados);
                File arquivo = new File(nomeArquivo);
                arquivo.createNewFile();
                PrintWriter salvar = new PrintWriter(arquivo);
                salvar.print(xml);
                salvar.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    @SuppressWarnings("unchecked")
	protected ArrayList<String[]> recuperarLista() {
        File arquivo = new File(nomeArquivo);
        try {
            if (arquivo.exists()) {
                FileInputStream arq = new FileInputStream(arquivo);
                dados = (ArrayList<String[]>) xStream.fromXML(arq);
            } else {
                dados = new ArrayList<String[]>();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dados;
    }

}
