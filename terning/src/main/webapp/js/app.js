"use strict";


/**
 * Klasse DiceController. Klassen er begrenset til html element med gitt id.
 *
 * @author Le beste gruppen
 */
class DiceController {

    /**
     *
     * @param {String} elementId - Id til htmlelement DiceController tar utgangspunkt fra.
     */
    constructor(elementId) {
        // binder funksjonen run og rollDice til konteksten til objektet de allerede er bundet til
        this.run = this.run.bind(this);
        this.rollDice = this.rollDice.bind(this);

        this.root = document.getElementById(elementId);
        this.button = this.root.querySelector('*[data-dicebutton]')
        this.output = this.root.querySelector('*[data-diceoutput]');
        this.dice = new Dice();
    }

    /**
     * Kjøres etter siden er lastet inn i nettleseren sin hukommelse.
     */
    run() {
        this.button.addEventListener('click', this.rollDice);
    }


    /**
     * Ruller terning og endrer innholdet i html-elementet som har custom data-attributt, "data-diceoutput"
     */
    rollDice() {
        this.output.innerHTML = this.dice.roll();
    }
}

/**
 * Klasse Dice.
 *
 * @author Le beste gruppen
 */
class Dice {
    roll = () => ((Math.random() * 6 + 1)|0);
}

const controller = new DiceController("root");
document.addEventListener("DOMContentLoaded", controller.run, true);
