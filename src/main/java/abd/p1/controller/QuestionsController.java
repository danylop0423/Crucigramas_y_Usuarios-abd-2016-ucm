/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.controller;

import abd.p1.model.Opcion;
import abd.p1.model.Pregunta;
import abd.p1.view.questions.AnswersWindow;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class QuestionsController {
    private final DefaultListModel<Pregunta> questionsModel;

    public QuestionsController(DefaultListModel<Pregunta> questionsModel) {
        this.questionsModel = questionsModel;
    }

    public void answerQuestion(JPanel parent, Pregunta selectedQuestion) {
        Iterable<Opcion> answers = selectedQuestion.getOpciones();
        DefaultListModel<Opcion> model = new DefaultListModel<>();
        
        for (Opcion answer : answers) {
            model.addElement(answer);
        }
        
        AnswersController controller = new AnswersController(selectedQuestion, model);
        AnswersWindow AnswerW = new AnswersWindow(controller, model);
        AnswerW.setVisible(true);
    }
    
    public void gatherAllQuestions() {
        // Debug code, must call dao
        Pregunta p1 = new Pregunta(0, "¿Te gusta fútbol?", new ArrayList<Opcion>());
        p1.getOpciones().add(new Opcion(0, 1, p1, "Si"));
        p1.getOpciones().add(new Opcion(0, 2, p1, "No"));
        Pregunta p2 = new Pregunta(1, "¿Cuál es tu color favorito?", new ArrayList<Opcion>());
        p2.getOpciones().add(new Opcion(1, 1, p1, "Rojo"));
        p2.getOpciones().add(new Opcion(1, 2, p1, "Verde"));
        p2.getOpciones().add(new Opcion(1, 3, p1, "Azul"));
        p2.getOpciones().add(new Opcion(1, 4, p1, "Amarillo"));
        p2.getOpciones().add(new Opcion(1, 5, p1, "Rosa"));
        p2.getOpciones().add(new Opcion(1, 6, p1, "Ocre"));
        p2.getOpciones().add(new Opcion(1, 7, p1, "Verde Metrosur"));
        Pregunta p3 = new Pregunta(2, "¿A qué partido no votarías nunca?", new ArrayList<Opcion>());
        p3.getOpciones().add(new Opcion(2, 1, p1, "PP"));
        p3.getOpciones().add(new Opcion(2, 2, p1, "PSOE"));
        p3.getOpciones().add(new Opcion(2, 3, p1, "IU"));
        p3.getOpciones().add(new Opcion(2, 4, p1, "UPyD"));

        questionsModel.addElement(p1);
        questionsModel.addElement(p2);
        questionsModel.addElement(p3);
    }
}
