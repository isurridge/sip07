$(function() {
	$("form.main :input:not(:hidden, :submit):first").focus();
	$('.warningBox').hide().slideDown();
	$("form.main :input[id='hotelArrive']").datepicker(
			{
				defaultDate : "+1w",
				changeMonth : false,
				numberOfMonths : 2,
				dateFormat : "DD, d MM, yy",
				// showOn: "button",
				// buttonImage: "/skin/images/calendar.gif",
				// buttonImageOnly: true,
				onClose : function(selectedDate) {
					$("form.main :input[id='hotelDeparture']").datepicker(
							"option", "minDate", selectedDate);
				}
			});
	
	$("form.main :input[id='hotelDeparture']").datepicker(
			{
				defaultDate : "+1w",
				changeMonth : false,
				numberOfMonths : 2,
				dateFormat : "DD, d MM, yy",
				onClose : function(selectedDate) {
					$("form.main :input[id='hotelArrive']").datepicker(
							"option", "maxDate", selectedDate + "+1w");
				}
			});

	$("form.main :input[id='airportArrive']").datepicker(
			{
				defaultDate : "+1w",
				changeMonth : false,
				numberOfMonths : 2,
				dateFormat : "DD, d MM, yy",
				onClose : function(selectedDate) {
					$("form.main :input[id='airportDeparture']").datepicker(
							"option", "minDate", selectedDate);
				}
			});
	
	$("form.main :input[id='airportDeparture']").datepicker(
			{
				defaultDate : "+1w",
				changeMonth : false,
				numberOfMonths : 2,
				dateFormat : "DD, d MM, yy",
				onClose : function(selectedDate) {
					$("form.main :input[id='airportArrive']").datepicker(
							"option", "maxDate", selectedDate + "+1w");
				}
			});
});
// dateFormat: "mm/dd/yy",
