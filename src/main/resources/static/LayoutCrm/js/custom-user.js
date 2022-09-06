// get all user
$(document).ready(function(){
  console.log("OK")
	  $.ajax({
	  url: 'http://localhost:8090/api/user',
	  type: 'get',
	  dataType:"json"
	}).done(function(value) {
		console.log(value)
		var index = 1;
		value.forEach(function(data){
		console.log(data)
			var contentUser = `
		<tr>
			<td>${index++}</td>
			<td>${data.fullname}</td>
			<td>${data.email}</td>
			<td>${data.address}</td>
			<td>${data.phone}</td>
			<td>
				<a href="#" class="btn btn-sm btn-primary btn-alert" >Sửa</a>
				 <a href="#" onclick="myFunction(${data.id})" class="btn btn-sm btn-danger">Xóa</a>
				<a href="user-details.html" class="btn btn-sm btn-info">Xem</a>
			</td>
		</tr>
		`
		$('#tbody-users').append(contentUser)
		})

		
	}).fail(function(error) {
	
	});
}); 

function myFunction(id) {
	// e.preventDefault();
	console.log("click nut xoa")
	console.log(id)
	$.ajax({
		url: `http://localhost:8090/api/user/delete/${id}`,
		method: "delete",
		dataType: "json"
		
	}).done(function(value){
	
	}).fail(function(value) {
		
	})
	location.reload();
  }