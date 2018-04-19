function doGet() {
	$
			.ajax(
					{
						type : "GET",
						contentType : "application/json; charset=utf-8",
						dataType : "json",
						url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"
								+ $('#idClient').val()
					}).then(function(data) {
				$('#idClient').val(data.id);
				$('#nom').val(data.name);
			});
}

function doPost() {
	$.ajax({
		type : "POST",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		data : JSON.stringify({
			name : $('#patientName').val()
		}),
		url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"

	}).then(function(data) {
		$('#idClient').val(data.id);
		$('#nom').val(data.name);
	});

}

function doDelete() {
	$.ajax({
		type : "DELETE",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"
				+ $('#idClient').val(),
		success : function(result) {
			if (result)
				alert('Votre client a été supprimé');
		}
	});
}

function doPut() {
	$.ajax({
		type : "PUT",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		data : JSON.stringify({
			id : $('#idClient').val(),
			name : $('#nom').val()
		}),
		url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"
	}).then(function(data) {
		$('#idClient').val(data.id);
		$('#nom').val(data.name);
	});
}