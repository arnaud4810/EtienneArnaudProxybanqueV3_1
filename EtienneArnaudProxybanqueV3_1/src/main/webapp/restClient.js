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
				$('#newPrenom').val(data.prenom);
				$('#newTelephone').val(data.telephone);
				$('#newAdresse').val(data.adresse);
				$('#newConseiller').val(data.conseiller);
				$('#newCustomerAssociatedComptes').val(data.customerAssociatedComptes);
			});
}

function doPost() {
	$.ajax({
		type : "POST",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		data : JSON.stringify({
			nom : $('#newNom').val(),
			prenom : $('#newPrenom').val(),
			telephone : $('#newTelephone').val(),
			adresse : $('#newAdresse').val(),
			conseiller : $('#newConseiller').val(),
			customerAssociatedComptes : $('#newCustomerAssociatedComptes').val()
		}),
		url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"

	}).then(function(data) {
		$('#newIdClient').val(data.idClient);
		$('#newNom').val(data.nom);
		$('#newPrenom').val(data.prenom);
		$('#newTelephone').val(data.telephone);
		$('#newAdresse').val(data.adresse);
		$('#newConseiller').val(data.conseiller);
		$('#newCustomerAssociatedComptes').val(data.customerAssociatedComptes);
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
			idClient : $('#newIdClient').val(),
			nom : $('#newNom').val(),
			prenom : $('#newPrenom').val(),
			telephone : $('#newTelephone').val(),
			adresse : $('#newAdresse').val(),
			conseiller : $('#newConseiller').val(),
			customerAssociatedComptes : $('#newCustomerAssociatedComptes').val()
		}),
		url : "http://localhost:8080/EtienneArnaudProxybanqueV3_1/services/customerService/Customer/"
	}).then(function(data) {
		$('#newIdClient').val(data.idClient);
		$('#newNom').val(data.nom);
		$('#newPrenom').val(data.prenom);
		$('#newTelephone').val(data.telephone);
		$('#newAdresse').val(data.adresse);
		$('#newConseiller').val(data.conseiller);
		$('#newCustomerAssociatedComptes').val(data.customerAssociatedComptes);
	});
}