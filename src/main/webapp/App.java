package main.webapp;

import javax.annotation.PostConstruct;

import br.com.ger1001Questoes.components.GenerateExam;

public class App {

	@PostConstruct
	public static void main(String[] args) {
		
		GenerateExam gen = new GenerateExam();
		gen.disciplina(5);
	}

}
