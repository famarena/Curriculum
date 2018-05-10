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
		success: function(result){
			$.each(result, function(positions,position){
				var row ="<tr>" +
							"<td>" + position.positionName + "</td>" +
							"<td>" + position.sector + "</td>" +
							"<td>" + position.idPosition + "</td>" +
							"<td>" +
							   "<a href = position/detail/"+ position.idPosition +" class = '.detail' >Dettagli</a>" +
							"</td>" +
						 "</tr>"
				document.getElementById("tablePosition").innerHTML+= row;
			})
		}
	})

});
