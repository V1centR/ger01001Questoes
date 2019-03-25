package br.com.ger1001Questoes.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
	int[][] prova = new int[8][30];
	
	//private ArrayList<List> exameToFront;
	
	HashMap<String, List> mapExame = new HashMap<String, List>();
//	private Map<String, Object> map;
//	private List<String> keyList = new ArrayList<String>(map.keySet());
	
	@SuppressWarnings("rawtypes")
	private ArrayList<List> exame;
	
	@PostConstruct
	public void init() {
		
		disciplina();
	}
	
	@SuppressWarnings("rawtypes")
	public int[][] disciplina() {
		
		disciplinas[0] = "port";
		disciplinas[1] = "afo";
		disciplinas[2] = "info";
		disciplinas[3] = "rlm";
		disciplinas[4] = "dirPen";
		disciplinas[5] = "dirProc";
		disciplinas[6] = "dirConst";
		disciplinas[7] = "dirAdm";

		exame = new ArrayList<List>();

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
//				
//			case "info":
//				System.out.println("Exec info");
//				List itemsInfo = randGenerate(info,infoRange);
//				exame.add(itemsInfo);
//				break;
//
//			case "rlm":
//				System.out.println("Exec rlm");
//				List itemsRlm = randGenerate(rlm,rlmRange);
//				exame.add(itemsRlm);
//				break;
//				
//			case "dirPen":
//				System.out.println("Exec dirPen");
//				List itemsDp = randGenerate(dirPen,dirPenRange);
//				exame.add(itemsDp);
//				break;
//				
//			case "dirProc":
//				System.out.println("Exec dirProc");
//				List itemsDirProc = randGenerate(dirProc,dirProcRange);
//				exame.add(itemsDirProc);
//				break;
//				
//			case "dirConst":
//				System.out.println("Exec dirConst");
//				List itemsdirConst = randGenerate(dirConst,dirConstRange);
//				exame.add(itemsdirConst);
//				//exame.set(1, itemsdirConst);
//				break;
//				
//			case "dirAdm":
//				System.out.println("Exec dirAdm");
//				List itemsdirAdm = randGenerate(dirAdm,dirAdmRange);
//				exame.add(itemsdirAdm);
//				break;
			}
		}
		
		return prova;
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
		Random randomnum = new Random();
		
		for(int i = 0; i<qtd; i++) {
			currentItem = randomnum.nextInt(range);
			
			while(itemsLista.contains(currentItem) || itemsLista.contains(0)) {
				currentItem = randomnum.nextInt(range);
			}
			itemsLista.add(currentItem);
			items.add(currentItem);
		}
		
		return items;
	}
	
	public ArrayList<List> getExame(){
		return exame;
	}
	
	public String[] getDisciplinas(){
		return disciplinas;
	}
	
	//mapExame
	public HashMap<String, List> getMapExame(){
		return mapExame;
	}

}
