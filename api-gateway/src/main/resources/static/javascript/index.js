
$(document).ready(() => {

	/*$.get('http://localhost:8765/currency-exchange/currencies', (data) => {
		$(".result").html(data);
		alert("Load was performed.");
	});*/


	$('.currency-select').select2({
		ajax: {
			url: 'http://localhost:8765/currency-exchange/currencies',
			dataType: 'json',
			contentType: 'application/json',
			processResults: (data) => {
				const data2 = data.map(item => {
					return {...item, text: item.abbreviation}
				});
				return {
					"results": data2,
					"pagination": {
						"more": false
					}
				}
			}
		},
		placeholder: "Select a currency",
		theme: "bootstrap-5",
		width: '100%'
	});
	
	$('#sendConversionButton').click((e) => {
		e.preventDefault();
		if ($('#firstOptionSelect').val() != null && $('#secondOptionSelect').val() != null) {
			
			if ($('#firstOptionSelect').val() == $('#secondOptionSelect').val()) {
				$("#conversionResult").val($("#currencyQuantity").val());
				return;
			}
			
			$.get('http://localhost:8765/currency-conversion/from/' + 
				$('#firstOptionSelect').select2('data')[0].text + '/to/' + $('#secondOptionSelect').select2('data')[0].text + '/quantity/' + $("#currencyQuantity").val(), (data) => {
					console.log(data);
					$("#conversionResult").val(data.totalCalculatedAmount);
			});
		} else {
			return null;
		}
	});
	
	$('.currency-select').change(() => {
		if ($('#firstOptionSelect').val() != null && $('#secondOptionSelect').val() != null) {
			
			if ($('#firstOptionSelect').val() == $('#secondOptionSelect').val()) {
				$("#conversionRate").val(1);
				return;
			}
			
			$.get('http://localhost:8765/currency-exchange/conversion-rate/from/' + 
				$('#firstOptionSelect').val() + '/to/' + $('#secondOptionSelect').val(), (data) => {
					$("#conversionRate").val(data.conversionMultiple);
			});
		}
	});
	
});
