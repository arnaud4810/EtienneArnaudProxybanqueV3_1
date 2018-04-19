function doGet() {
	$
			.ajax(
					{
						type : "GET",
						contentType : "application/json; charset=utf-8",
						dataType : "json",
						url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"
								+ $('#newIdClient').val()
					}).then(function(data) {
				$('#newIdClient').val(data.idClient);
				$('#newNom').val(data.nom);
			});
}

function doPost() {
	$.ajax({
		type : "POST",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		data : JSON.stringify({
			name : $('#newNom').val()
		}),
		url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"

	}).then(function(data) {
		$('#newIdClient').val(data.idClient);
		$('#newNom').val(data.nom);
	});

}

function doDelete() {
	$.ajax({
		type : "DELETE",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"
				+ $('#newIdClient').val(),
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
			id : $('#newIdClient').val(),
			name : $('#newNom').val()
		}),
		url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"
	}).then(function(data) {
		$('#newIdClient').val(data.idClient);
		$('#newNom').val(data.nom);
	});
}