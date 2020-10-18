/**
 * 
 */
"use strict";
class DiceController {
	contstructor(root) {
		this.run = run.this.bind(this);
		this.rollDice = this.rollDice.bind(this);
	}
	rollDice() {
		const dice = new Dice(6);
		dice.rollDice();
		const diceoutput = document.getElementsByName("data-diceoutput")[0];
		diceoutput.innerText = dice.value;
	}
	run() {
		const dice = new Dice(6);
		dice.rollDice();
	}
}

const controller = new DiceController("root");
document.addEventListener("DOMContentLoaded", controller.run, true);
const btRef = document.getElementById("btn");
btRef.addEventListener("click", controller.rollDice, true);
