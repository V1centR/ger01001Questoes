package br.com.ger1001Questoes.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class GenerateExam {
	
	private Integer portugues = 30;
	private Integer portRange = 150;
	
	private Integer afo = 4;
	private Integer afoRange = 40;
	
	private Integer info = 4;
	private Integer infoRange = 40;
	
	private Integer rlm = 4;
	private Integer rlmRange = 60;
	
	private Integer dirPen = 10;
	private Integer dirPenRange = 60;
	
	private Integer dirProc = 10;
	private Integer dirProcRange = 60;
	
	private Integer dirConst = 10;
	private Integer dirConstRange = 60;
	
	private Integer dirAdm = 10;
	private Integer dirAdmRange = 60;
	
	String[] disciplinas = new String[8];
	private ArrayList<HashMap> multipleExam = new ArrayList<HashMap>();
	HashMap<String, List> mapExame;
	
	@SuppressWarnings("rawtypes")
	private ArrayList<List> exame;
	
	@PostConstruct
	public void init() {
		
		disciplina(3);
		
	}
	
	@SuppressWarnings("rawtypes")
	public void disciplina(int numExames) {
		
		disciplinas[0] = "port";
		disciplinas[1] = "afo";
		disciplinas[2] = "info";
		disciplinas[3] = "rlm";
		disciplinas[4] = "dirPen";
		disciplinas[5] = "dirProc";
		disciplinas[6] = "dirConst";
		disciplinas[7] = "dirAdm";

		//exame = new ArrayList<List>();
		
		for(int x = 0; x < 4;x++) {
			
			mapExame = new HashMap<String, List>();
			
			//##########################
			for(int i = 0; i<disciplinas.length; i ++) {
				
				switch (disciplinas[i]) {

				case "port":
					List items = randGenerate(portugues,portRange);
					//exame.add(items);
					mapExame.put("Língua Portuguesa", items);
					//exame.set(0, items);
					break;
					
				case "afo":
					List itemsAfo = randGenerate(afo,afoRange);
					//exame.add(itemsAfo);
					mapExame.put("AFO", itemsAfo);
					break;
					
				case "info":
					List itemsInfo = randGenerate(info,infoRange);
					mapExame.put("Informática", itemsInfo);
					break;

				case "rlm":
					List itemsRlm = randGenerate(rlm,rlmRange);
					mapExame.put("RLM", itemsRlm);
					break;
					
				case "dirPen":
					List itemsDp = randGenerate(dirPen,dirPenRange);
					//exame.add(itemsDp);
					mapExame.put("Dir Penal",itemsDp);
					break;
					
				case "dirProc":
					List itemsDirProc = randGenerate(dirProc,dirProcRange);
					mapExame.put("Dir Processual",itemsDirProc);
					break;
					
				case "dirConst":
					List itemsdirConst = randGenerate(dirConst,dirConstRange);
					mapExame.put("Dir Const",itemsdirConst);
					break;
					
				case "dirAdm":
					List itemsdirAdm = randGenerate(dirAdm,dirAdmRange);				
					mapExame.put("Dir Adminis",itemsdirAdm);
					break;
				}
			}
			//##########################
			multipleExam.add(mapExame);
		}
		
	}
	
	/*
	 * randGenerate(Integer qtd,Integer range)
	 * qtd = Num of questions
	 * range = radom number os number question on the book
	 */
	@SuppressWarnings("unchecked")
	private List randGenerate(Integer qtd,Integer range) {
		
		@SuppressWarnings("rawtypes")
		List items = new ArrayList();
		
		HashSet<Integer> itemsLista = new HashSet<Integer>();

		int currentItem = 0;
		
		for(int i = 0; i<qtd; i++) {
			
			currentItem = (int) (Math.random()*(range - 1) + 1);
			
			while(itemsLista.contains(currentItem)) {
				currentItem = (int) (Math.random()*(range - 1) + 1);
			}
			itemsLista.add(currentItem);
			items.add(currentItem);
		}
		
		return items;
	}
	
	public HashMap<String, List> getMapExame(){
		return mapExame;
	}
	
	public ArrayList<HashMap> getMultipleExam(){
		return multipleExam;
	}

}
