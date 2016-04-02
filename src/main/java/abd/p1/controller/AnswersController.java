/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.controller;

import abd.p1.model.Opcion;
import abd.p1.model.Pregunta;
import javax.swing.DefaultListModel;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class AnswersController {
    
    private final Pregunta model;
    private final DefaultListModel<Opcion> answersModel;

    public AnswersController(Pregunta model, DefaultListModel<Opcion> answersModel) {
        this.model = model;
        this.answersModel = answersModel;
    }
    
    public String getQuestionStatement() {
        return model.getEnunciado();
    }
}
