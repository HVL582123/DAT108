/**
 * 
 */
"use strict";
class Dice {
	constructor(storste = 6){
		this.storste = storste;
		this.value = null;
	}
	
	rollDice(){
		this.value = 1 + Math.trunc(Math.random()*this.storste);
	}
}