$(document).ready(function(){
	var title ="<tr>" +
			     "<th>Name</th>" +
			     "<th>Surname</th>" + 
			     "<th>Id</th>" +
			     "<th>Dettagli</th>" +
			   "</tr>" 
	document.getElementById("tableCandidate").innerHTML+=title;

	$.ajax({
		url: "candidate/candidate",
		success: function(candidates){
			$.each(candidates, function(i,candidate){

				var row ="<tr>" +
							"<td>" + candidate.name + "</td>" +
							"<td>" + candidate.surname + "</td>" +
							"<td>" + candidate.idCandidate + "</td>" +
							"<td>" +
							   "<a href = candidate/candidate/"+ candidate.idCandidate +" class = 'detail' >Dettagli</a>" +
							"</td>" +
						 "</tr>"
				document.getElementById("tableCandidate").innerHTML+= row;
			})
		}
	})

			
		
		
	$.ajax({
		url: "skill/skills",
		success: function(skills){
			
			var test ="<select name='skills'>";
			
			$.each(skills, function(i,skill){

				 test += "<option value="+ skill.name + " >" + skill.name + "</option>" 
					
			})

			
			test += "</select>";
				document.getElementById("skills").innerHTML+= test;
				var stringa=  " Skill level: <br> <input type='text'  id='value'  name='value'>"
				document.getElementById("value").innerHTML+= stringa;
				var stringa2=  " <input type='button' value='Another Skill' id= 'addLine'>"
					document.getElementById("another").innerHTML+= stringa2;
		}
	})
	
	
	

});
$(document).on('click', '.detail', function(){
	console.log("Sono entrato in un click");
	var href = this.href;
	$.ajax({
		url: href,
		success: function(candidate){
	
			$("#detail").empty();
			var table = "<table id = 'tableDet'></table>"
   		    document.getElementById("detail").innerHTML+=table;
			var skillRates = candidate.skillrates;
			$.each(skillRates, function(i, skillRate){
				var title ="<tr>" +
								 "<th>Skill</th>" +
							     "<th>Real Skill</th>" + 
							     "<th>Declared Skill</th>" + 
			               "</tr>" 
				if(i==0){
     		 	  document.getElementById("tableDet").innerHTML+=title;
				}
				var row = "<tr>" +
				             "<td>" + skillRate.skill.name + "</td>" +
				             "<td>" + skillRate.realValue + "</td>" +
				             "<td>" + skillRate.declaredValue + "</td>" +
				          "</tr>"
		        document.getElementById("tableDet").innerHTML+=row;
		    })
		}
	})
	return false;
})

$(document).on('click', '#addLine', function(){
	$.ajax({
		url: "skill/skills",
		success: function(skills){
			
			var test ="<select name='skills'>";
			
			$.each(skills, function(i,skill){

				 test += "<option value="+ skill.name + " >" + skill.name + "</option>" 
					
			})

			
			test += "</select>";
				document.getElementById("skills").innerHTML+= test;
				var stringa=  " Skill level: <br> <input type='text'  id='value'  name='value'>"
				document.getElementById("value").innerHTML+= stringa;
			
		}
	})
	
})

$("#form1").submit(function(e){
	
    e.preventDefault();

    var obj = $('#form1').serializeObject();
    console.log(obj);
    $.ajax({
        type: 'POST',
        url: 'candidate/newCandidate',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
     
        success: function(data) {
        	console.log("Json passato");
            alert(data);
        },
    
    error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
    });

	
});


