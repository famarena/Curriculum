//function btn() {
//
//	// ajax call
//	$.ajax({
//		url : "candidate/candidate",
//		type : "GET",
//		dataType : "json"
//	}).done(function(data, textStatus, jqXHR) {
//		generateTable(data);
//	});
//};
//
//function generateTable(data) {
//
//	$.each(response, generateTable(i, data))
//	{
//		var $tr = $
//	}
//	
//	
//}
//function createRow (candidate){
//	
//	 tr += "<td>" + candidate.name + "</td>" + "<td>$" + candidate.surname + "</td></tr>";
//
//	    /* We add the table row to the table body */
//	    tbody.innerHTML += tr;
//	
//}


$.ajax({

	url : '/candidate/candidate',

	method : 'get'

	})

	.done(function (candidate){

	$('#tblcandidate').DataTable({

	data: candidate,
	searching: false,
	columns: [

	{ title: "name", data: 'name' },

	{ title: "surname", data: 'surname' },
	
	
	{ title: "Details", data: 'name' },

	]

	});

	});

//$('add').click(function(e){
//	e.preventDefault();
//	var candidate=
//		{
//			name: $('name').val(),
//			surname: $('surname').val(),
//		}
//	
//
//$.ajax({
//	
//	
//
//	url : '/candidate/candidate',
//
//	method : 'post'
//
//	data: JSON.stringfy(candidate);
//	})
//	.done(function(risp){
//		
//	});
//
//});

	
