var ws;
function connect() {
	ws = new WebSocket('ws://localhost:8080/api/xmlDataSync');
	ws.onmessage = function(data) {
		getItemDetails(data.data);
	}
	setConnected(true);
}

function getItemDetails(message) {
	if (message === "Duplicate Key found!!. XML Sync Failed.")
		document.getElementById("response").innerHTML = message;
	else
		document.getElementById("response2").innerHTML = message;
}

function sendData() {
	var data = $("#xml").val();
	ws.send(data);
}



$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#send").click(function() {
		sendData();
	});
});
