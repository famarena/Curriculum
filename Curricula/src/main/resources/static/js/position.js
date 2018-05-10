$("#buttonPosition").click(function(){
	var title ="<tr>" +
			     "<th>Nome Posizione</th>" +
			     "<th>Settore</th>" + 
			     "<th>Id</th>" +
			     "<th>Dettagli</th>" +
			   "</tr>" 
	document.getElementById("tablePosition").innerHTML+=title;

	$.ajax({
		url: "position/openPosition",
		success: function(positions){
			$.each(positions, function(i,position){

				var row ="<tr>" +
							"<td>" + position.positionName + "</td>" +
							"<td>" + position.sector + "</td>" +
							"<td>" + position.idPosition + "</td>" +
							"<td>" +
							   "<a href = position/"+ position.idPosition +" class = 'detail' >Dettagli</a>" +
							"</td>" +
						 "</tr>"
				document.getElementById("tablePosition").innerHTML+= row;
			})
		}
	})

});
$(document).on('click', '.detail', function(){
	var href = this.href;
	$.ajax({
		url: href,
		success: function(position){
			$("#detail").empty();
			var table = "<table id = 'tableSkill'></table>"
   		    document.getElementById("detail").innerHTML+=table;
			var skillList = position.requiredSkills;
			$.each(skillList, function(i,reqSkill){
				var title ="<tr>" +
								 "<th>Skill</th>" +
							     "<th>Minimo</th>" + 
			               "</tr>" 
				if(i==0){
     		 	  document.getElementById("tableSkill").innerHTML+=title;
				}
				var row = "<tr>" +
				             "<td>" + reqSkill.skill.name + "</td>" +
				             "<td>" + reqSkill.min + "</td>" +
				          "</tr>"
		        document.getElementById("tableSkill").innerHTML+=row;
		    })
		}
	})
	return false;
})

