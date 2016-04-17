function l() {

	var startingBet = Number(document.getElementById("startingBet").value);
	var walletAmount = Number(startingBet);
	var win = 4;
	var loss = 1;
	var rollNumber = 0;
	var maxWinnings = 0;
	var rollMaxWinnings = 0;
	
	if (isNaN(startingBet)) {
		alert("Please enter a number.");
		return;
	};
	if (startingBet <= 0) {
		alert("Please enter a number greater than zero.");
		return;
	};
	
	do{
		if (walletAmount > maxWinnings) {
			maxWinnings = walletAmount;
			rollMaxWinnings = rollNumber;
		}
		var diOne = Math.round(Math.random() * 6);
		var diTwo = Math.round(Math.random() * 6);
		var diTotal = (diOne + diTwo);
		rollNumber++;
		console.log(rollNumber, "roll number");
		//console.log(diTotal, "di total");
		
		if (diTotal == 7) {
				var walletAmount = (walletAmount + 4);
			} else {
				var walletAmount = (walletAmount - 1);
			};
		
	console.log(walletAmount, "wallet amount");
			
			
	}while (walletAmount > 0);
	
	console.log(rollNumber, "roll number");
	console.log(maxWinnings, "max winnings");
	console.log(rollMaxWinnings, "roll on max winnings");
	
	function results() {
		document.getElementById("initialBet").innerHTML = "$" + startingBet;
		document.getElementById("brokeRolls").innerHTML	= rollNumber;
		document.getElementById("maxWin").innerHTML	= "$" + maxWinnings;
		document.getElementById("rMaxWin").innerHTML = rollMaxWinnings;
		document.getElementById("gameStats").style.display="table";
		document.getElementById("startingBet").value = "";
		document.getElementById("button").value="Play Again";
	};
	results();
};