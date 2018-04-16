/**
 * 
 */
//$(function(){
// NOTE ilker above is shorthand for below line
$(document).ready(function(){
	// create new user or edit one
	$('.nBtn, .table .eBtn').on('click', function(event){
//		console.log("ILKER -->");
//		debugger;

		// NOTE ilker if you have href="" in anchor tag this jQuery marker triggers on, then you need to have below line to be able to see modal popup
		//         or if you have th:href="@{detail/(studentId=${student.studentId})}", then you need below line to stop it from showing the result as json object
		event.preventDefault();	
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text=='Edit') {
			// make ajax (REST) call via jQuery's get. Then 
			$.get(href, function(data4student, status){
				$('.myForm #studentId').val(data4student.studentId);
				$('.myForm #name').val(data4student.name);
				$('.myForm #lastname').val(data4student.lastname);
				$('.myForm #grade').val(data4student.grade);
				$('.myForm #age').val(data4student.age);
				$('.myForm #isFullTime').val(data4student.isFullTime);
				$('.myForm #updatedOn').val(data4student.updatedOn);
			});
			// let Bootstrap modal popup via below jQuery call
			$('.myForm #exampleModal').modal();	// modal(), modal('show'), modal('toggle')
		} else {
			$('.myForm #studentId').val('N/A');
			$('.myForm #name').val('');
			$('.myForm #lastname').val('');
			$('.myForm #grade').val('');
			$('.myForm #age').val('');
			$('.myForm #isFullTime').val('');
			$('.myForm #updatedOn').val('');
			// let Bootstrap modal popup via below jQuery call
			$('.myForm #exampleModal').modal();	// modal(), modal('show'), modal('toggle')			
		}
	});
	
	$('.table .dBtn').on('click', function(event){
		event.preventDefault();	
		var href = $(this).attr('href');
		$('#exampleModal4delete #dConfBtn').attr('href', href);
		// let Bootstrap modal popup via below jQuery call
		$('#exampleModal4delete').modal();	// modal(), modal('show'), modal('toggle')			
		

	});
		
});