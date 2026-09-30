
package LeitorDeDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GerenciadorGrupos{
	private List<Pessoa> listaGeral;
	
	public GerenciadorGrupos(){
		this.listaGeral = new ArrayList<>();
	}
	
	public void adicionarPessoa(Pessoa pessoa) {
		this.listaGeral.add(pessoa);
	}
	
	public List<Pessoa> getGrupoPorSexo(String sexo){
		Map<String, List<Pessoa>> grupos = listaGeral.stream()
				.collect(Collectors.groupingBy(Pessoa::getSexo));
		return grupos.getOrDefault(sexo.toUpperCase(), new ArrayList<>());
	}
}
