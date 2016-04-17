function check() {
	var letters = /^[a-zA-Z]*$/;
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	var reason = document.getElementById("reason").value;
	var addl = document.getElementById("addl").value;
	var checkbox = document.getElementsByName("weekday");
	var box = false;
	
	if (!/^[a-zA-Z]*$/g.test(document.forms[0]["name"].value)) {
		alert("Invalid Characters.");
		return false;
	};
	
	if (name == null || name == "") {
		alert("Name must be filled out");
		return false;
	};
	
	if (email == null || email == "") {
		if (phone == null || phone == ""){
			alert("Either a phone numnber or email address is required");
			return false;			
		};
	};
	
	if (reason == "Other"){
		if (addl == null || addl =="") {
			alert("Please provide additional information in the text box");
			return false;
		};
	};
	
	for (i = 0; i < checkbox.length; i++){
		if (checkbox[i].checked){
				box = true;
				break;
		};
	};
	
	if (box == false){
		alert("Please check at least one day of the week");
		return false;
	};
};
