$("#buttonPosition").click(function(){
	$("#divTablePosition").empty();
	var table ="<table id='tablePosition'>" +
	               "<tr>" +
					     "<th>Nome Posizione</th>" +
					     "<th>Settore</th>" + 
					     "<th>Id</th>" +
					     "<th>Dettagli</th>" +
				   "</tr>" +
				"</table> ";
	document.getElementById("divTablePosition").innerHTML+=table;

	$.ajax({
		url: "position/openPosition",
		success: function(positions){
			$.each(positions, function(i,position){
				var row ="<tr>" +
							"<td>" + position.positionName + "</td>" +
							"<td>" + position.sector + "</td>" +
							"<td>" + position.idPosition + "</td>" +
							"<td><a href = position/"+ position.idPosition +" class = 'detail' >Dettagli</a></td>" +
						 "</tr>";
				document.getElementById("tablePosition").innerHTML+= row;
			})
		}
	})

});
$(document).on('click', '.detail', function(){
	$("#candidates").empty();
	var href = this.href;
	console.log(href);
	$.ajax({
		url: href,
		success: function(position){
			$("#detail").empty();
			var table = "<table id = 'tableSkill'>"+
			               "<tr>" +
			                  "<th>Skill</th>" +
		                      "<th>Minimo</th>" + 
                           "</tr>" +
                         "</table>"
   		    document.getElementById("detail").innerHTML+=table;
			var skillList = position.requiredSkills;
			$.each(skillList, function(i,reqSkill){
					var row = "<tr>" +
					             "<td>" + reqSkill.skill.name + "</td>" +
					             "<td>" + reqSkill.min + "</td>" +
					          "</tr>";
			        document.getElementById("tableSkill").innerHTML+=row;
		    })
		    var search = "<input type='number' id='candidateNumber'></input><a id='search' idP="+position.idPosition+" href=/position/bestCandidates/"+position.idPosition+">CERCA!</a>";
			document.getElementById("detail").innerHTML += search;
		}
	})
	return false;
})
$(document).on('click', '#search', function(){
	var href = this.href + "/"+ $('#candidateNumber').val();
	var idPosition= $(this).attr('idP');
	$.ajax({
		url: href,
		success: function(bestCandidates){
				var table = "<table id = 'tableCandidates'>"+
				               "<tr>" +
				                  "<th>Nome</th>" +
				                  "<th>Cognome</th>" + 
				                  "<th>Id</th>" +
				                  "<th>Data Colloquio</th>" +
				                  "<th>Id Selezionatore</th>"+
				                  "<th>Fissa Colloquio</th>" +
				               "</tr>" +
				            "</table>";
			$("#candidates").empty();
	   		document.getElementById("candidates").innerHTML+=table;
			$.each(bestCandidates, function(i,candidate){
				var row = "<tr>" +
				                "<input type='hidden' id=position"+i+" name='idPosition' value="+idPosition+">" +
		             			"<td>" + candidate.name + "</td>" +
		             			"<td>" + candidate.surname + "</td>" +
		             			"<td name='idCandidate' id=idCandidate"+i+">" + candidate.idCandidate + "</td>" +
		             			"<td><input id=date"+i+" name='stringDateTime' type='datetime-local'></td>" + 
		             			"<td><select id=selector"+i+" name='idSelector' class='selector'></td>" +
		             			"<td><input type='submit' idRow="+i+" class='newInterview'></td>" +
	             		  "</div></tr>";
	           $("#tableCandidates").append(row);
	             
			  })
			  	$.ajax({
	            		url: "/selector/allSelectors",
	            		success: function(selectors){
	            			$.each(selectors, function(i,selector){
	            				$(".selector").append($('<option>', {
	            					val: selector.idSelector,
	            				    text: selector.name + " " + selector.surname
	            				}));
	            			})
	            		}
	          })
		}
	})
	return false;
})

$(document).on('click', '.newInterview', function(){
	var i = $(this).attr("idRow");
	var idCandidate = $("#idCandidate"+i+"").html();
	var dateWithT = $("#date"+i+"").val();
	var idSelector = $("#selector"+i+"").val();
	var idPosition = $("#position"+i+"").val();
	var date = dateWithT.replace('T',' ');
	var interview  ={}
	interview.stringDateTime=date;
	interview.idCandidate=idCandidate;
	interview.idSelector=idSelector;
	interview.idPosition=idPosition;
	console.log(JSON.stringify(interview));
	$.ajax({
		type: "POST",
	    url: "/interview/interviews",
		contentType:'application/json',
		data: JSON.stringify(interview)
		})
	return false;
})

