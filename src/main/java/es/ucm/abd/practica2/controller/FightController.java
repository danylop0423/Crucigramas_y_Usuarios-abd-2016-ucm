package es.ucm.abd.practica2.controller;

import es.ucm.abd.practica2.controller.FightResult.Winner;
import es.ucm.abd.practica2.dao.AbedemonDAO;
import es.ucm.abd.practica2.model.Abedemon;

import javax.xml.xquery.XQException;

/**
 * Controlador de la ventana principal (excl. paneles)
 *
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class FightController {
    private final AbedemonDAO dao;

    public FightController(AbedemonDAO dao) {
        this.dao = dao;
    }


    public FightResult fight(Abedemon one, Abedemon two) {
        Integer damage1Integer = null;
        Integer damage2Integer = null;

        try {
            damage1Integer = dao.getDamage(two.getId(), one.getId());
            damage2Integer = dao.getDamage(one.getId(), two.getId());
        } catch (XQException e) {
            e.printStackTrace();
        }

        int damage2 = (damage2Integer == null) ? 0 : damage2Integer;
        int damage1 = (damage1Integer == null) ? 0 : damage1Integer;

        Winner winner;
        if (damage1 == damage2) {
            winner = Winner.TIE;
        } else if (damage1 > damage2) {
            winner = Winner.TWO;
        } else {
            winner = Winner.ONE;
        }

        return new FightResult(one, two, damage1, damage2, winner);
    }

}
